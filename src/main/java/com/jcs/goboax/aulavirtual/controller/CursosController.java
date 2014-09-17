package com.jcs.goboax.aulavirtual.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.service.api.CursoService;
import com.jcs.goboax.aulavirtual.util.FlashMessage;
import com.jcs.goboax.aulavirtual.util.NavigationTargets;
import com.jcs.goboax.aulavirtual.validator.CourseModelValidator;
import com.jcs.goboax.aulavirtual.viewmodel.CourseModel;
import com.jcs.goboax.aulavirtual.viewmodel.ObjectToJsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cursos")
@Scope(value = "session")
public class CursosController
{
    private static final Logger LOG = LoggerFactory
            .getLogger(CursosController.class);

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CourseModelValidator courseModelValidator;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private FlashMessage flashMessage;

    @Autowired
    private AuthenticationService authenticationService;

    @InitBinder("courseModel")
    private void initBinder(WebDataBinder binder)
    {
        binder.setValidator(courseModelValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String cursos(HttpServletRequest aServletRequest) throws IOException
    {
        if (aServletRequest.isUserInRole("SUPER_ADMIN")
                || aServletRequest.isUserInRole("COORDINADOR"))
        {
            return "cursos";
        }
        else
        {
            return "cursos/detail";
        }
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String cursosDetail() throws IOException
    {
        return "cursos/detail";
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.GET)
    public String cursos(@PathVariable("courseId") Integer aCourseId,
                         Map<String, Object> aModel) throws IOException
    {
        Curso myCurso = cursoService.readCourseById(aCourseId);
        aModel.put("course", myCurso);

        return "cursos/detail";
    }

    // TODO Create external API and move this call.
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public
    @ResponseBody
    String cursosList(HttpServletRequest request) throws IOException
    {
        List<Curso> myCursos = new ArrayList<Curso>();
        if (request.isUserInRole("SUPER_ADMIN"))
        {
            myCursos = cursoService.readCourses();
        }
        else
        {
            myCursos = cursoService.readCoursesEnable();
        }

        @SuppressWarnings("unchecked")
        List<CourseModel> myCourseModels = (List<CourseModel>) conversionService.convert(
                myCursos,
                TypeDescriptor.collection(List.class,
                        TypeDescriptor.valueOf(Curso.class)),
                TypeDescriptor.collection(List.class,
                        TypeDescriptor.valueOf(CourseModel.class)));

        ObjectToJsonObject<CourseModel> myCursoToJsonObject = new ObjectToJsonObject<CourseModel>();

        myCursoToJsonObject.setiTotalDisplayRecords(myCursos.size());
        myCursoToJsonObject.setiTotalRecords(myCursos.size());
        myCursoToJsonObject.setAaData(myCourseModels);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json2 = gson.toJson(myCursoToJsonObject);

        return json2;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String cursoAdd(Map<String, Object> aModel)
    {
        CourseModel myCourseModel = new CourseModel();
        aModel.put("courseModel", myCourseModel);
        aModel.put("target", NavigationTargets.COURSE_ADD);
        aModel.put("action", "add");
        return "cursos/add";
    }

    @RequestMapping(params = "save", value = "/add", method = RequestMethod.POST)
    public String cursosAddDo(@Validated CourseModel courseModel,
                              BindingResult result, Map<String, Object> aModel)
    {
        LOG.debug("Adding Curso ...");
        if (result.hasErrors())
        {
            aModel.put("target", NavigationTargets.COURSE_ADD);
            aModel.put("action", "add");
            return "cursos/add";
        }

        cursoService.createCourse(courseModel);
        flashMessage.success("course.success");
        return "redirect:/cursos";
    }

    @RequestMapping(params = "cancel", value = "/add", method = RequestMethod.POST)
    public String cancelAddCourse()
    {
        return "redirect:/cursos";
    }

    @RequestMapping(value = "/{cursoId}/edit", method = RequestMethod.GET)
    public String cursoEdit(Map<String, Object> aModel,
                            @PathVariable("cursoId") Integer aCourseId)
    {
        Curso myCurso = cursoService.readCourseById(aCourseId);

        if (myCurso == null)
        {
            flashMessage.error("course.not.exists");
            return "redirect:/cursos";
        }

        CourseModel myCourseModel = conversionService.convert(myCurso, CourseModel.class);
        aModel.put("courseModel", myCourseModel);
        aModel.put("target", NavigationTargets.COURSE_EDIT);
        aModel.put("action", "edit");

        return "cursos/add";
    }

    @RequestMapping(params = "save", value = "/edit", method = RequestMethod.POST)
    public String cursosEdit(@Validated CourseModel courseModel,
                             BindingResult result, Map<String, Object> aModel)
    {
        LOG.debug("Editing Curso ...");
        if (result.hasErrors())
        {
            aModel.put("target", NavigationTargets.COURSE_EDIT);
            aModel.put("action", "edit");
            return "cursos/add";
        }

        cursoService.updateCourse(courseModel);
        flashMessage.success("course.success");
        return "redirect:/cursos";
    }

    @RequestMapping(value = "/delete/{courseId}", method = RequestMethod.GET)
    public String removeCourse(@PathVariable(value = "courseId") Integer aCourseId,
                               Map<String, Object> aModel)
    {
        cursoService.disableCourse(aCourseId);

        flashMessage.success("course.disable.success");

        return "redirect:/cursos";
    }

    @RequestMapping(params = "cancel", value = "/edit", method = RequestMethod.POST)
    public String cancelEditCourse()
    {
        return "redirect:/cursos";
    }

}
