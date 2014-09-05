package com.jcs.goboax.aulavirtual.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcs.goboax.aulavirtual.dao.api.ContenidoDao;
import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.service.api.CursoService;
import com.jcs.goboax.aulavirtual.service.api.TipoContenidoService;
import com.jcs.goboax.aulavirtual.util.FlashMessage;
import com.jcs.goboax.aulavirtual.util.NavigationTargets;
import com.jcs.goboax.aulavirtual.validator.ContentModelFormValidator;
import com.jcs.goboax.aulavirtual.validator.CourseModelValidator;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModel;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModelForm;
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
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private ContentModelFormValidator contentModelFormValidator;

    // TODO Remove me
    @Autowired
    private ContenidoDao contenidoDao;

    @Autowired
    private ConversionService conversionService;
    
    @Autowired
    private FlashMessage flashMessage;

    @Autowired
    private TipoContenidoService tipoContenidoService;

    @Autowired
    private AuthenticationService authenticationService;

    @InitBinder("courseModel")
    private void initBinder(WebDataBinder binder)
    {
        binder.setValidator(courseModelValidator);
    }

    @InitBinder("contentModelForm")
    private void initContentModelBinder(WebDataBinder binder)
    {
        binder.setValidator(contentModelFormValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String cursos() throws IOException
    {
        LOG.debug("{}", authenticationService.getUsuario().getUsuarioId());
        return "cursos";
    }

    // TODO Create external API and move this call.
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public @ResponseBody String cursosList(HttpServletRequest request) throws IOException
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

    @RequestMapping(value = "/{courseId}/content/add", method = RequestMethod.GET)
    public String contentAdd(@PathVariable("courseId") Integer aCourseId,
            Map<String, Object> aModel)
    {
        ContentModelForm myContentModelForm = new ContentModelForm();
        Map<Integer, String> myTipoContenido = tipoContenidoService.readAllTipoContenidoMap();
        List<String> myExtensionesContenido = tipoContenidoService.readExtensionesContenido();
        Curso oCurso = cursoService.readCourseById(aCourseId);

        aModel.put("target", "/cursos/" + aCourseId + "/content/add");
        aModel.put("contentModelForm", myContentModelForm);
        aModel.put("action", "add");
        aModel.put("contentTypeNames", myTipoContenido);
        aModel.put("extensionContenido", myExtensionesContenido);
        aModel.put("course", oCurso);

        return "contenido/add";
    }

    @RequestMapping(value = "/{courseId}/content/add", method = RequestMethod.POST)
    public String contentAdd(@PathVariable("courseId") Integer aCourseId,
                             @Validated ContentModelForm courseModel, BindingResult result,
                             Map<String, Object> aModel)
    {
        if (result.hasErrors())
        {
            Map<Integer, String> myTipoContenido = tipoContenidoService.readAllTipoContenidoMap();

            aModel.put("target", "/cursos/" + aCourseId + "/content/add");
            aModel.put("action", "add");
            aModel.put("contentTypeNames", myTipoContenido);
            
            return "contenido/add";

        }
        LOG.debug(courseModel.getName());
        LOG.debug(courseModel.getContent().getContentType());

        cursoService.createContent(courseModel, aCourseId);
        return "redirect:/cursos/" + aCourseId + "/contents";

    }

    @RequestMapping(value = "/content/edit/{contentId}", method = RequestMethod.GET)
    public String contentEdit(Map<String, Object> aModel,
                            @PathVariable("contentId") Integer aContentId)
    {
        Contenido myContenido = cursoService.readContentById(aContentId);

        if (myContenido == null)
        {
            flashMessage.error("content.not.exists");
            return "redirect:/cursos";
        }

        ContentModelForm myContentModelForm =
                conversionService.convert(myContenido, ContentModelForm.class);

        aModel.put("contentModelForm", myContentModelForm);
        aModel.put("target", NavigationTargets.CONTENT_EDIT);
        aModel.put("action", "edit");
        aModel.put("course", myContenido.getCurso());

        return "contenido/add";
    }

    @RequestMapping(value = "/content/edit", method = RequestMethod.POST)
    public String doContentEdit(Map<String, Object> aModel,
                              @Validated ContentModelForm courseModel, BindingResult result)
    {

        if (result.hasErrors())
        {
            aModel.put("target", NavigationTargets.CONTENT_EDIT);
            aModel.put("action", "edit");

            flashMessage.error("content.not.exists");
            return "contenido/add";
        }

        cursoService.updateContent(courseModel);

        return "redirect:/cursos";
    }
    
    @RequestMapping(value = "/content/delete/{id}", method = RequestMethod.GET )
    public String doContentDelete(@PathVariable("id") Integer aContentId)
    {
        Curso myCurso = cursoService.readCourseByContentId(aContentId);
        
        cursoService.removeContent(aContentId);
        flashMessage.success("content.delete.succes.message");

        return "redirect:/cursos/" + myCurso.getCursoId() + "/contents";
    }
    
    @RequestMapping(params = "cancel", value = "/{courseId}/content/add", method = RequestMethod.POST)
    public String cancelContentAdd(@PathVariable("courseId") Integer aCourseId)
    {
        return "redirect:/cursos/" + aCourseId + "/contents";
    }

    @RequestMapping(value = "/content/download/{id}", method = RequestMethod.GET)
    public void doDownload(HttpServletRequest request,
            HttpServletResponse response, @PathVariable("id") Integer anId)
            throws IOException
    {

        try
        {
            Contenido myContenido = contenidoDao.findByKey(anId);
            byte[] myFileContent = myContenido.getArchivoMaterial();
            response.setContentType(myContenido.getContentType());
            response.setHeader("Content-disposition", "attachment; filename=\""
                    + myContenido.getNombre() + "\"");
            FileCopyUtils.copy(myFileContent, response.getOutputStream());
        }
        catch (IOException e)
        {
            LOG.error("unable to create file,  please see the stackTrace", e);
        }

    }

    @RequestMapping(value = "/{cursoId}/contents", method = RequestMethod.GET)
    public String contents(@PathVariable("cursoId") Integer aCourse, Map<String, Object> aModel)
    {
        Curso myCurso = cursoService.readCourseById(aCourse);
        aModel.put("course", myCurso);
        return "contenido/list";
    }

    @RequestMapping(value = "/{cursoId}/content/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public @ResponseBody String contentList(@PathVariable("cursoId") Integer aCourseId) throws IOException
    {
        List<Contenido> myContenidos = cursoService.readContents(aCourseId);

        @SuppressWarnings("unchecked")
        List<ContentModel> myContentModels = (List<ContentModel>) conversionService.convert(
                myContenidos,
                TypeDescriptor.collection(List.class,
                        TypeDescriptor.valueOf(Contenido.class)),
                TypeDescriptor.collection(List.class,
                        TypeDescriptor.valueOf(ContentModel.class)));

        ObjectToJsonObject<ContentModel> myObjectToJsonObject = new ObjectToJsonObject<ContentModel>();

        myObjectToJsonObject.setiTotalDisplayRecords(myContenidos.size());
        myObjectToJsonObject.setiTotalRecords(myContenidos.size());
        myObjectToJsonObject.setAaData(myContentModels);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String myJsonResponse = gson.toJson(myObjectToJsonObject);

        return myJsonResponse;
    }
}
