package com.jcs.goboax.aulavirtual.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.service.api.CursoService;
import com.jcs.goboax.aulavirtual.service.api.ExamenService;
import com.jcs.goboax.aulavirtual.service.api.ModuleService;
import com.jcs.goboax.aulavirtual.service.api.ValoracionService;
import com.jcs.goboax.aulavirtual.util.Constants;
import com.jcs.goboax.aulavirtual.util.FlashMessage;
import com.jcs.goboax.aulavirtual.util.NavigationTargets;
import com.jcs.goboax.aulavirtual.viewmodel.AppraisalModel;
import com.jcs.goboax.aulavirtual.viewmodel.ExamModel;
import com.jcs.goboax.aulavirtual.viewmodel.ExamenConfigModel;
import com.jcs.goboax.aulavirtual.viewmodel.ExamenModel;
import com.jcs.goboax.aulavirtual.viewmodel.ExamenModelWrapper;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/motorEval")
@Scope(value = "session")
public class TestEngineContoller
{

    private static final Logger LOG = LoggerFactory
            .getLogger(TestEngineContoller.class);

    @Autowired
    private ExamenService examenService;

    @Autowired
    private CursoService cursoService;
    
    @Autowired
    private ModuleService moduloService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private FlashMessage flashMessage;
    
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ValoracionService valoracionService;

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

        for (Curso aCurso : myCursos)
        {
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
            List<Curso> myCursos = cursoService.readCourses();
            Map<Integer, String> myCursosMap = new HashMap<Integer, String>();

            for (Curso aCurso : myCursos)
            {
                myCursosMap.put(aCurso.getCursoId(), aCurso.getNombre());
            }
            
            aModel.put("courses", myCursosMap);
            aModel.put("target", NavigationTargets.EXAM_ADD);
            aModel.put("action", "add");
            return "testEngine/add";
        }
        
        Examen newExamen = new Examen();
        newExamen.setModulo(moduloService.readModuleById(examModel.getModuleId()));
        newExamen.setNumPreguntas(examModel.getNumOfQuestions());
        newExamen.setNumRespuestasPregunta(examModel.getNumAnswersPerQuestion());
        
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

    @RequestMapping(value = "/saveExam", method = RequestMethod.POST)
    public
    @ResponseBody
    ExamenModel saveExam(@RequestBody ExamenModelWrapper examen)
    {
        LOG.debug("{}", examen);
        ExamenModel myExamenModel = examen.getExamen();
        Examen myExamen = conversionService.convert(myExamenModel, Examen.class);
        LOG.debug("{}", myExamen);
        Examen myExamenUpdated = examenService.updateExam(myExamen);
        return conversionService.convert(myExamenUpdated, ExamenModel.class);
    }
    
    @RequestMapping(value = "/configEdit/{examenId}", method = RequestMethod.GET)
    public String updateConfigParams(@PathVariable(value = "examenId") Integer anExamId,
                               Map<String, Object> aModel)
    {
        Examen myExamen = examenService.readExamById(anExamId);
        
        ExamenConfigModel myExamenConfig = conversionService.convert(myExamen, ExamenConfigModel.class);
        
        aModel.put("examModel", myExamenConfig);
        aModel.put(Constants.TARGET, NavigationTargets.EXAM_CONFIG_DO_EDIT);
        aModel.put("action", Constants.EDIT);
        
        return "testEngine/editConfig";
    }
    
    @RequestMapping(params = "save", value = "/updExamConfig", method = RequestMethod.POST)
    public String updateConfigParamsDo(@Validated @ModelAttribute("examModel")ExamenConfigModel examModel,
                              BindingResult result, Map<String, Object> aModel)
    {
        LOG.debug("Updating config parameters for Examen ...");
        if (result.hasErrors())
        {
            aModel.put(Constants.TARGET, NavigationTargets.EXAM_CONFIG_DO_EDIT);
            aModel.put("action", Constants.EDIT);
            
            return "testEngine/editConfig";
        }
        
        Examen updatableExamen = conversionService.convert(examModel, Examen.class);
        
        examenService.updateExam(updatableExamen);
        
        flashMessage.success("testEngine.updateExamConfigParams.success.label");
        
        return "redirect:/motorEval";
    }
    
    @RequestMapping(params = "cancel", value = "/updExamConfig", method = RequestMethod.POST)
    public String cancelUpdateConfigParams()
    {
        return "redirect:/motorEval";
    }
    
    @RequestMapping(value = "/preguntasEdit/{examenId}", method = RequestMethod.GET)
    public String updatePreguntas(@PathVariable(value = "examenId") Integer anExamId,
                               Map<String, Object> aModel)
    {
        Examen myExamen = examenService.readExamById(anExamId);
        
        aModel.put("cursoNombre", myExamen.getModulo().getCurso().getNombre());
        aModel.put("moduloNombre", myExamen.getModulo().getNombre());
        aModel.put("examenId", myExamen.getExamenId());
        aModel.put("moduloId", myExamen.getModulo().getModuloId());
        aModel.put("numPreguntas", myExamen.getNumPreguntas());
        aModel.put("numRespuestasPregunta", myExamen.getNumRespuestasPregunta());
        
        return "testEngine/editExam";
    }
    
    @RequestMapping(value = "/examenJson/{examenId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public
    @ResponseBody
    String examenJsonSerialized(HttpServletRequest request,
            @PathVariable(value = "examenId") Integer anExamId) throws IOException
    {
        Examen myExamen = examenService.readExamById(anExamId);
        
        ExamenModel myExamenModel = conversionService.convert(myExamen, ExamenModel.class);
        
        Map<String, ExamenModel> examToJsonMap = new HashMap<String, ExamenModel>();
        examToJsonMap.put("Examen", myExamenModel);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json2 = gson.toJson(examToJsonMap);

        return json2;
    }
    
    @RequestMapping(value = "/evalModulo/{moduloId}", method = RequestMethod.GET)
    public String getExamenForAppraisal(@PathVariable(value = "moduloId") Integer aModuleId,
                                        Map<String, Object> aModel)
    {            
        Modulo aModule = moduloService.readModuleById(aModuleId);
        Examen myAppraisalExam = examenService.getExamForAppraisalByModule(aModule);
        
        AppraisalModel anAppraisalExamModel = conversionService.convert(myAppraisalExam,
                                                                        AppraisalModel.class);
        
        aModel.put("exam", anAppraisalExamModel);
        aModel.put(Constants.TARGET, NavigationTargets.RATE_APPRAISAL);
        aModel.put(Constants.ACTION, Constants.ADD);
        
        return "modulo/appraise";
    }
    
    @RequestMapping(params = "save", value = "/scoreExam", method = RequestMethod.POST)
    public String scoreExamDo(@Validated AppraisalModel anAppraisalModel,
                              BindingResult result, Map<String, Object> aModel)
    {
        if (result.hasErrors())
        {
            aModel.put("exam", anAppraisalModel);
            aModel.put(Constants.TARGET, NavigationTargets.RATE_APPRAISAL);
            aModel.put(Constants.ACTION, Constants.ADD);

            return "modulo/appraise";
        }

        valoracionService.reviewTest(anAppraisalModel);

        return "appraise/receipt";
    }
}