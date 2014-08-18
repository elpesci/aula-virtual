package com.jcs.goboax.aulavirtual.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{

    @RequestMapping(value = "/")
    public ModelAndView test(HttpServletResponse response)
    {
        return new ModelAndView("cursos");
    }
}
