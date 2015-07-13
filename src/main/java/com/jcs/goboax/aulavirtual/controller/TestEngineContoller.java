package com.jcs.goboax.aulavirtual.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.service.api.CursoService;
import com.jcs.goboax.aulavirtual.util.Constants;
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
@RequestMapping("/motorEval")
@Scope(value = "session")
public class TestEngineContoller {
    
    private static final Logger LOG = LoggerFactory
            .getLogger(TestEngineContoller.class);

    @Autowired
    private CursoService cursoService;

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
        List<Curso> myCursos = new ArrayList<Curso>();
        if (request.isUserInRole("SUPER_ADMIN") || request.isUserInRole("COORDINADOR"))
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
}
