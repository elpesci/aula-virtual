package com.jcs.goboax.aulavirtual.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.service.api.CursoService;
import com.jcs.goboax.aulavirtual.validator.CourseModelValidator;
import com.jcs.goboax.aulavirtual.viewmodel.CourseModel;
import com.jcs.goboax.aulavirtual.viewmodel.CursoToJsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cursos")
public class CursosController
{
    @Autowired
    private CursoService cursoService;

    @Autowired
    private CourseModelValidator courseModelValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder)
    {
        binder.setValidator(courseModelValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String cursos() throws IOException
    {
        return "cursos";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    String cursosList() throws IOException
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
    public String cursoAdd(Map aModel)
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
}
