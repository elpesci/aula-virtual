package com.jcs.goboax.aulavirtual.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.service.api.CursoService;
import com.jcs.goboax.aulavirtual.service.api.ModuleService;
import com.jcs.goboax.aulavirtual.util.Constants;
import com.jcs.goboax.aulavirtual.util.FlashMessage;
import com.jcs.goboax.aulavirtual.util.NavigationTargets;
import com.jcs.goboax.aulavirtual.viewmodel.ModuleModelForm;
import com.jcs.goboax.aulavirtual.viewmodel.ObjectToJsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/modulos")
public class ModuleController
{
    private static final Logger LOG = LoggerFactory.getLogger(ModuleController.class);

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private FlashMessage flashMessage;

    @Autowired
    private ConversionService conversionService;

    @RequestMapping(method = RequestMethod.GET)
    public String modulos(@RequestParam("cursoId") Integer aCourseId,
                          Map<String, Object> aModel) throws IOException
    {
        Curso myCurso = cursoService.readCourseById(aCourseId);

        aModel.put("course", myCurso);
        return "modulos";
    }

    // TODO Create external API and move this call.
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public @ResponseBody
    String modulosList(HttpServletRequest request,
                       @RequestParam("cursoId") Integer aCourseId) throws IOException
    {
        List<Modulo> myModulos = new ArrayList<Modulo>();
        if (request.isUserInRole("SUPER_ADMIN"))
        {
            myModulos = moduleService.readModulesByCourse(aCourseId);
        }
        else
        {
            myModulos = moduleService.readModulesByCourse(aCourseId);
        }

        @SuppressWarnings("unchecked")
        List<ModuleModelForm> myModuleModelForm = (List<ModuleModelForm>) conversionService.convert(
                myModulos,
                TypeDescriptor.collection(List.class,
                        TypeDescriptor.valueOf(Modulo.class)),
                TypeDescriptor.collection(List.class,
                        TypeDescriptor.valueOf(ModuleModelForm.class)));

        ObjectToJsonObject<ModuleModelForm> myCursoToJsonObject = new ObjectToJsonObject<ModuleModelForm>();

        myCursoToJsonObject.setiTotalDisplayRecords(myModulos.size());
        myCursoToJsonObject.setiTotalRecords(myModulos.size());
        myCursoToJsonObject.setAaData(myModuleModelForm);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json2 = gson.toJson(myCursoToJsonObject);

        return json2;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String moduleAdd(@RequestParam("courseId") Integer aCourseId,
                             Map<String, Object> aModel)
    {
        ModuleModelForm myModuleModelForm = new ModuleModelForm();
        myModuleModelForm.setCourseId(aCourseId);

        Curso myCurso = cursoService.readCourseById(aCourseId);

        aModel.put(Constants.ACTION, Constants.ADD);
        aModel.put(Constants.TARGET, NavigationTargets.MODULE_ADD);
        aModel.put("moduleModelForm", myModuleModelForm);
        aModel.put("course", myCurso);

        return "modulos/add";
    }

    @RequestMapping(params = "save", value = "/add", method = RequestMethod.POST)
    public String moduleAdd(@Validated ModuleModelForm moduleModelForm,
                            BindingResult result, Map<String, Object> aModel)
    {
        if (result.hasErrors())
        {
            aModel.put(Constants.ACTION, Constants.ADD);
            aModel.put(Constants.TARGET, NavigationTargets.MODULE_ADD);
            return "modulos/add";
        }

        moduleService.createModule(moduleModelForm);

        flashMessage.success("module.add.success");
        return "redirect:/modulos?cursoId=" + moduleModelForm.getCourseId();
    }

    @RequestMapping(params = "cancel", value = "/add", method = RequestMethod.POST)
    public String moduleAdd(ModuleModelForm moduleModelForm)
    {
        return "redirect:/modulos?cursoId=" + moduleModelForm.getCourseId();
    }

    @RequestMapping(value = "/edit/{moduleId}", method = RequestMethod.GET)
    public String moduleEdit(@PathVariable("moduleId") Integer aModuleId,
                            Map<String, Object> aModel)
    {
        Modulo myModulo = moduleService.readModuleById(aModuleId);

        if (myModulo == null)
        {
            flashMessage.error("module.not.exists");
            return "redirect:/cursos";
        }

        ModuleModelForm myModuleModelForm = conversionService.convert(myModulo, ModuleModelForm.class);

        aModel.put(Constants.ACTION, Constants.EDIT);
        aModel.put(Constants.TARGET, NavigationTargets.MODULE_EDIT);
        aModel.put("moduleModelForm", myModuleModelForm);
        aModel.put("course", myModulo.getCurso());

        return "modulos/add";
    }

    @RequestMapping(params = "save", value = "/edit", method = RequestMethod.POST)
    public String moduleEdit(@Validated ModuleModelForm moduleModelForm,
                            BindingResult result, Map<String, Object> aModel)
    {
        if (result.hasErrors())
        {
            aModel.put(Constants.ACTION, Constants.EDIT);
            aModel.put(Constants.TARGET, NavigationTargets.MODULE_EDIT);
            return "modulos/add";
        }

        moduleService.updateModule(moduleModelForm);

        flashMessage.success("module.edit.success");
        return "redirect:/modulos?cursoId=" + moduleModelForm.getCourseId();
    }

    @RequestMapping(params = "cancel", value = "/edit", method = RequestMethod.POST)
    public String moduleEdit(ModuleModelForm moduleModelForm)
    {
        return "redirect:/modulos?cursoId=" + moduleModelForm.getCourseId();
    }
}
