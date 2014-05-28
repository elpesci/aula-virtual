/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcs.goboax.aulavirtual.controller;

import com.jcs.goboax.aulavirtual.viewmodel.LoginViewModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() 
    {
        return new ModelAndView("login", "command", new LoginViewModel());
    }
}
