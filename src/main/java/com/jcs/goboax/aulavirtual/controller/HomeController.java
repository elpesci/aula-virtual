package com.jcs.goboax.aulavirtual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController
{

    @RequestMapping(value = "/")
    public String test(HttpServletResponse response)
    {
        return "forward:/cursos";
    }
}
