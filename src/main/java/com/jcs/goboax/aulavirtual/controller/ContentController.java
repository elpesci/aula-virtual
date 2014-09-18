package com.jcs.goboax.aulavirtual.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.service.api.ContentService;
import com.jcs.goboax.aulavirtual.service.api.ModuleService;
import com.jcs.goboax.aulavirtual.service.api.TipoContenidoService;
import com.jcs.goboax.aulavirtual.util.Constants;
import com.jcs.goboax.aulavirtual.util.FlashMessage;
import com.jcs.goboax.aulavirtual.util.NavigationTargets;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModel;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModelForm;
import com.jcs.goboax.aulavirtual.viewmodel.ObjectToJsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/modulo")
public class ContentController
{
    private static final Logger LOG = LoggerFactory.getLogger(ContentController.class);

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private ContentService contentService;

    @Autowired
    private TipoContenidoService tipoContenidoService;

    @Autowired
    private FlashMessage flashMessage;

    @Autowired
    private ConversionService conversionService;

    @RequestMapping(value = "/{moduleId}/content/add", method = RequestMethod.GET)
    public String contentAdd(@PathVariable("moduleId") Integer aModuleId,
                             Map<String, Object> aModel)
    {
        ContentModelForm myContentModelForm = new ContentModelForm();
        Modulo myModulo = moduleService.readModuleById(aModuleId);

        aModel.put(Constants.TARGET, "/modulo/" + aModuleId + "/content/add");
        aModel.put("contentModelForm", myContentModelForm);
        aModel.put(Constants.ACTION, Constants.ADD);
        aModel.put("module", myModulo);

        return "contenido/add";
    }

    @RequestMapping(params = "save", value = "/{moduleId}/content/add", method = RequestMethod.POST)
    public String contentAdd(@PathVariable("moduleId") Integer aModuleId,
                             @Validated ContentModelForm aContentModelForm, BindingResult result,
                             Map<String, Object> aModel)
    {
        if (result.hasErrors())
        {
            Map<Integer, String> myTipoContenido = tipoContenidoService.readAllTipoContenidoMap();

            aModel.put(Constants.TARGET, "/modulo/" + aModuleId + "/content/add");
            aModel.put(Constants.ACTION, Constants.ADD);
            aModel.put("contentTypeNames", myTipoContenido);

            return "contenido/add";

        }
        LOG.debug(aContentModelForm.getName());
        LOG.debug(aContentModelForm.getContent().getContentType());

        contentService.createContent(aContentModelForm, aModuleId);
        Modulo myModulo = moduleService.readModuleById(aModuleId);

        flashMessage.success("content.add.success");

        aModel.put("module", myModulo);

        return "redirect:/modulo/" + aModuleId + "/contents";

    }

    @RequestMapping(params = "cancel", value = "/{moduleId}/content/add", method = RequestMethod.POST)
    public String cancelContentAdd(@PathVariable("moduleId") Integer aModuleId)
    {
        return "redirect:/modulo/" + aModuleId + "/contents";
    }

    @RequestMapping(value = "/content/edit/{contentId}", method = RequestMethod.GET)
    public String contentEdit(Map<String, Object> aModel,
                              @PathVariable("contentId") Integer aContentId)
    {
        Contenido myContenido = contentService.readContentById(aContentId);

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
        aModel.put("course", myContenido.getModulo());

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

        contentService.updateContent(courseModel);

        return "redirect:/cursos";
    }

    @RequestMapping(value = "/content/delete/{id}", method = RequestMethod.GET )
    public String doContentDelete(@PathVariable("id") Integer aContentId)
    {
        //Curso myCurso = contentService.readCourseByContentId(aContentId);

        contentService.removeContent(aContentId);
        flashMessage.success("content.delete.succes.message");

        return "redirect:/cursos/" + "/contents";
    }

    @RequestMapping(value = "/content/download/{id}", method = RequestMethod.GET)
    public void doDownload(HttpServletRequest request,
                           HttpServletResponse response, @PathVariable("id") Integer anId)
            throws IOException
    {
        try
        {
            Contenido myContenido = contentService.readContentById(anId);
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

    @RequestMapping(value = "/{moduleId}/contents", method = RequestMethod.GET)
    public String contents(@PathVariable("moduleId") Integer aModuleId, Map<String, Object> aModel)
    {
        Modulo myModulo = moduleService.readModuleById(aModuleId);
        aModel.put("module", myModulo);

        return "contenido/list";
    }

    @RequestMapping(value = "/{moduleId}/content/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public @ResponseBody
    String contentList(@PathVariable("moduleId") Integer aModuleId) throws IOException
    {
        List<Contenido> myContenidos = contentService.readContentsByModule(aModuleId);

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
