package com.jcs.goboax.aulavirtual.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jcs.goboax.aulavirtual.util.FlashMessage;

@Controller
public class LoginController
{

    private final static Logger LOG = LoggerFactory
            .getLogger(LoginController.class);

    @Autowired
    private FlashMessage flashMessage;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "logout", required = false) String aLogout,
            @RequestParam(value = "error", required = false) String anError)
    {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken))
        {
            return new ModelAndView("forward:/");
        }

        ModelAndView model = new ModelAndView();
        if (aLogout != null)
        {
            LOG.debug("{}", "Logout successful");
            flashMessage.notice("logout.success");
        }
        
        if (anError != null)
        {
            LOG.debug("{}", "Login Error");
            model.addObject("error", true);
        }
        
        model.setViewName("login");
        return model;
    }
}
