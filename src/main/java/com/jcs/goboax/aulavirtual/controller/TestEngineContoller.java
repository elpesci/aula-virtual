package com.jcs.goboax.aulavirtual.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.service.api.CursoService;
import com.jcs.goboax.aulavirtual.service.api.ExamenService;
import com.jcs.goboax.aulavirtual.util.FlashMessage;
import com.jcs.goboax.aulavirtual.util.NavigationTargets;
import com.jcs.goboax.aulavirtual.viewmodel.ExamModel;
import com.jcs.goboax.aulavirtual.viewmodel.ObjectToJsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/motorEval")
@Scope(value = "session")
public class TestEngineContoller {
    
    private static final Logger LOG = LoggerFactory
            .getLogger(TestEngineContoller.class);
    
    @Autowired
    private ExamenService examenService;
    
    @Autowired
    private CursoService cursoService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private FlashMessage flashMessage;
    
    @RequestMapping(method = RequestMethod.GET)
    public String motorEval(HttpServletRequest aServletRequest) throws IOException
    {
        if (aServletRequest.isUserInRole("SUPER_ADMIN")
                || aServletRequest.isUserInRole("COORDINADOR"))
        {
            return "testEngine";
        }
        else
        {
            return "accessdenied";
        }
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public
    @ResponseBody
    String testList(HttpServletRequest request) throws IOException
    {
        List<Examen> exams = new ArrayList<Examen>();
        if (request.isUserInRole("SUPER_ADMIN") || request.isUserInRole("COORDINADOR")) 
        {
            exams = examenService.readExams();
        }
        
        @SuppressWarnings("unchecked")
        List<ExamModel> myExamModels = (List<ExamModel>) conversionService.convert(
                exams,
                TypeDescriptor.collection(List.class,
                        TypeDescriptor.valueOf(Examen.class)),
                TypeDescriptor.collection(List.class,
                        TypeDescriptor.valueOf(ExamModel.class)));
        
        ObjectToJsonObject<ExamModel> myExamToJsonObject = new ObjectToJsonObject<ExamModel>();

        myExamToJsonObject.setiTotalDisplayRecords(exams.size());
        myExamToJsonObject.setiTotalRecords(exams.size());
        myExamToJsonObject.setAaData(myExamModels);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json2 = gson.toJson(myExamToJsonObject);

        return json2;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String examenAdd(Map<String, Object> aModel)
    {
        List<Curso> myCursos = cursoService.readCourses();
        Map<Integer, String> myCursosMap = new HashMap<Integer, String>();
        
        for(Curso aCurso : myCursos){
            myCursosMap.put(aCurso.getCursoId(), aCurso.getNombre());
        }
        
        ExamModel myExamModel = new ExamModel();
        aModel.put("courses", myCursosMap);
        aModel.put("examModel", myExamModel);
        aModel.put("target", NavigationTargets.EXAM_ADD);
        aModel.put("action", "add");
        return "testEngine/add";
    }

    @RequestMapping(params = "save", value = "/add", method = RequestMethod.POST)
    public String examenAddDo(@Validated ExamModel examModel,
                              BindingResult result, Map<String, Object> aModel)
    {
        
        LOG.debug("Adding Examen ...");
        if (result.hasErrors())
        {
            aModel.put("target", NavigationTargets.EXAM_ADD);
            aModel.put("action", "add");
            return "testEngine/add";
        }
        
        Examen newExamen = examenService.insertExam(examModel);
        
        flashMessage.success("testEngine.addExam.success.label");
        aModel.put("target", NavigationTargets.EXAM_ADD_QA);
        aModel.put("action", "add_qa");
        aModel.put("exam", newExamen);
        
        return "testEngine/addQuestionsAnswers";
    }

    @RequestMapping(params = "cancel", value = "/add", method = RequestMethod.POST)
    public String cancelExamenAdd()
    {
        return "redirect:/motorEval";
    }
}
