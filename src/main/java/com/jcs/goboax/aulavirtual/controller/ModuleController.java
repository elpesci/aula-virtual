package com.jcs.goboax.aulavirtual.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.service.api.ModuleService;
import com.jcs.goboax.aulavirtual.util.FlashMessage;
import com.jcs.goboax.aulavirtual.viewmodel.ModuleModelForm;
import com.jcs.goboax.aulavirtual.viewmodel.ObjectToJsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
    private FlashMessage flashMessage;

    @Autowired
    private ConversionService conversionService;

    @RequestMapping(method = RequestMethod.GET)
    public String modulos(@RequestParam("cursoId") Integer aCourseId,
                          Map<String, Object> aModel) throws IOException
    {
        aModel.put("courseId", aCourseId);
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


        return "modulos/add";
    }
}
