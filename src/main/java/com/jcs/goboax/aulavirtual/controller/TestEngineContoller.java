package com.jcs.goboax.aulavirtual.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcs.goboax.aulavirtual.service.api.ExamenService;
import com.jcs.goboax.aulavirtual.viewmodel.ExamModel;
import com.jcs.goboax.aulavirtual.viewmodel.ObjectToJsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/motorEval")
@Scope(value = "session")
public class TestEngineContoller {
    
    private static final Logger LOG = LoggerFactory
            .getLogger(TestEngineContoller.class);
    
    @Autowired
    private ExamenService examenService;

    @Autowired
    private ConversionService conversionService;
    
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
        List<ExamModel> exams = new ArrayList<ExamModel>();
        if (request.isUserInRole("SUPER_ADMIN") || request.isUserInRole("COORDINADOR")) 
        {
            exams = examenService.readExams();
        }
        
        String info = String.format("Number of Exams: {0}", exams.size());
        LOG.info(info);
        
        @SuppressWarnings("unchecked")
        ObjectToJsonObject<ExamModel> myExamToJsonObject = new ObjectToJsonObject<ExamModel>();

        myExamToJsonObject.setiTotalDisplayRecords(exams.size());
        myExamToJsonObject.setiTotalRecords(exams.size());
        myExamToJsonObject.setAaData(exams);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json2 = gson.toJson(myExamToJsonObject);

        return json2;
    }
}
