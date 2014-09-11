package com.jcs.goboax.aulavirtual.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.service.api.ContentService;
import com.jcs.goboax.aulavirtual.service.api.TipoContenidoService;
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
@RequestMapping("/cursos")
public class ContentController
{
    private static final Logger LOG = LoggerFactory.getLogger(ContentController.class);

    @Autowired
    private ContentService contentService;

    @Autowired
    private TipoContenidoService tipoContenidoService;

    @Autowired
    private FlashMessage flashMessage;

    @Autowired
    private ConversionService conversionService;

    @RequestMapping(value = "/{courseId}/content/add", method = RequestMethod.GET)
    public String contentAdd(@PathVariable("courseId") Integer aCourseId,
                             Map<String, Object> aModel)
    {
        ContentModelForm myContentModelForm = new ContentModelForm();
        Map<Integer, String> myTipoContenido = tipoContenidoService.readAllTipoContenidoMap();
        List<String> myExtensionesContenido = tipoContenidoService.readExtensionesContenido();
//        Curso oCurso = contentService.readCourseById(aCourseId);

        aModel.put("target", "/cursos/" + aCourseId + "/content/add");
        aModel.put("contentModelForm", myContentModelForm);
        aModel.put("action", "add");
        aModel.put("contentTypeNames", myTipoContenido);
        aModel.put("extensionContenido", myExtensionesContenido);
//        aModel.put("course", oCurso);

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

//        cursoService.createContent(courseModel, aCourseId);
        return "redirect:/cursos/" + aCourseId + "/contents";

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
//
//        try
//        {
//            Contenido myContenido = contenidoDao.findByKey(anId);
//            byte[] myFileContent = myContenido.getArchivoMaterial();
//            response.setContentType(myContenido.getContentType());
//            response.setHeader("Content-disposition", "attachment; filename=\""
//                    + myContenido.getNombre() + "\"");
//            FileCopyUtils.copy(myFileContent, response.getOutputStream());
//        }
//        catch (IOException e)
//        {
//            LOG.error("unable to create file,  please see the stackTrace", e);
//        }

    }

    @RequestMapping(value = "/{cursoId}/contents", method = RequestMethod.GET)
    public String contents(@PathVariable("cursoId") Integer aCourse, Map<String, Object> aModel)
    {
        //Curso myCurso = cursoService.readCourseById(aCourse);
//        aModel.put("course", myCurso);
        return "contenido/list";
    }

    @RequestMapping(value = "/{cursoId}/content/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public @ResponseBody
    String contentList(@PathVariable("cursoId") Integer aCourseId) throws IOException
    {
        List<Contenido> myContenidos = contentService.readContentsByModule(aCourseId);

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
