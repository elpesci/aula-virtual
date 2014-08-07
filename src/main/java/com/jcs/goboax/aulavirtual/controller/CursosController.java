package com.jcs.goboax.aulavirtual.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcs.goboax.aulavirtual.dao.api.ContenidoDao;
import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.service.api.CursoService;
import com.jcs.goboax.aulavirtual.validator.ContentModelValidator;
import com.jcs.goboax.aulavirtual.validator.CourseModelValidator;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModel;
import com.jcs.goboax.aulavirtual.viewmodel.CourseModel;
import com.jcs.goboax.aulavirtual.viewmodel.CursoToJsonObject;

@Controller
@RequestMapping("/cursos")
public class CursosController
{
    private static final Logger LOG = LoggerFactory.getLogger(CursosController.class); 
    
    @Autowired
    private CursoService cursoService;

    @Autowired
    private CourseModelValidator courseModelValidator;
    
    @Autowired
    private ContentModelValidator contentModelValidator;
    
    
    //TODO Remove me
    @Autowired
    private ContenidoDao contenidoDao;

    @InitBinder("courseModel")
    private void initBinder(WebDataBinder binder)
    {
        binder.setValidator(courseModelValidator);
    }
    
    @InitBinder("contentModel")
    private void initContentModelBinder(WebDataBinder binder)
    {
        binder.setValidator(contentModelValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String cursos() throws IOException
    {
        return "cursos";
    }

    // TODO Create external API and move this call.
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String cursosList() throws IOException
    {
        List<Curso> myCursos = cursoService.readCourses();

        CursoToJsonObject myCursoToJsonObject = new CursoToJsonObject();

        myCursoToJsonObject.setiTotalDisplayRecords(myCursos.size());
        myCursoToJsonObject.setiTotalRecords(myCursos.size());
        myCursoToJsonObject.setAaData(myCursos);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json2 = gson.toJson(myCursoToJsonObject);

        return json2;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String cursoAdd(Map<String, Object> aModel)
    {
        CourseModel myCourseModel = new CourseModel();
        aModel.put("courseModel", myCourseModel);
        return "cursos/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String cursosAddDo(@Validated CourseModel courseModel,
            BindingResult result)
    {
        if (result.hasErrors())
        {
            return "cursos/add";
        }

        cursoService.createCourse(courseModel);

        return "redirect:/cursos";
    }

    @RequestMapping(value = "/{courseId}/content/add", method = RequestMethod.GET)
    public String contentAdd(@PathVariable("courseId") Integer aCourseId,
            Map<String, Object> aModel)
    {
        ContentModel myContentModel = new ContentModel();
        
        aModel.put("target", "/cursos/" + aCourseId + "/content/add");
        aModel.put("contentModel", myContentModel);
        
        return "contenido/add";
    }
    
    @RequestMapping(value = "/{courseId}/content/add", method = RequestMethod.POST)
    public String contentAdd( @PathVariable("courseId") Integer aCourseId, 
            ContentModel courseModel,
            BindingResult result)
    {
        LOG.debug(courseModel.getName());
        LOG.debug(courseModel.getContent().getContentType());
        
        cursoService.createContent(courseModel, aCourseId);
        return "contenido/add";
    
    }
    
    @RequestMapping(value = "/content/test/{id}", method = RequestMethod.GET)
    public void doDownload(HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable("id") Integer anId) throws IOException {
 
        try
        {
            Contenido myContenido = contenidoDao.findByKey(anId);
            byte[] myFileContent = myContenido.getArchivoMaterial();
//            response.setContentType("text/csv");
            response.setHeader("Content-disposition", "attachment; filename=\"" 
                    + myContenido.getNombre() + "\"");
            FileCopyUtils.copy(myFileContent, response.getOutputStream());
        }
        catch (IOException e)
        {
            LOG.error("unable to create CSV file,  please see the stackTrace", e);
        }
 
    }
}
