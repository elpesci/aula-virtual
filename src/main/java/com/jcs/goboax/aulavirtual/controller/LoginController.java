/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcs.goboax.aulavirtual.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcs.goboax.aulavirtual.viewmodel.LoginViewModel;

@Controller
public class LoginController {

    private final static Logger LOG = LoggerFactory.getLogger(LoginController.class);
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() 
    {
        return new ModelAndView("login", "command", new LoginViewModel());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processForm(LoginViewModel aLoginViewModel, BindingResult resultl) 
    {
        LOG.debug("doLogin {}", aLoginViewModel.getNombreUsuario());
        return "home";
    }
}
