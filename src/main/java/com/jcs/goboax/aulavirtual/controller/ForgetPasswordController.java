package com.jcs.goboax.aulavirtual.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcs.goboax.aulavirtual.exception.AulaVirtualException;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import com.jcs.goboax.aulavirtual.util.FlashMessage;
import com.jcs.goboax.aulavirtual.viewmodel.ForgetPasswordForm;

@Controller
@RequestMapping("/login/forgetPassword")
public class ForgetPasswordController
{
    private static final Logger LOG = LoggerFactory.getLogger(ForgetPasswordController.class);
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private FlashMessage flashMessage;

    @RequestMapping(method = RequestMethod.GET)
    public String forgetPassword(Map<String, Object> aModel)
    {
        aModel.put("forgetPasswordForm", new ForgetPasswordForm());
        aModel.put("target", "/login/forgetPassword");
        return "login/forgetPassword";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String forgetPassword(@Validated ForgetPasswordForm forgetPasswordForm,
                                 BindingResult result)
    {
        if (result.hasErrors())
        {
            return "login/forgetPassword";
        }

        try
        {
            usuarioService.resetPassword(forgetPasswordForm.getEmail());
        }
        catch (AulaVirtualException e)
        {
            LOG.info("Email doesn't exist");
            flashMessage.error("forgetPassword.exception");
            result.reject("forgetPassword.exception");
            return "login/forgetPassword";
        }

        flashMessage.success("forgetPassword.send.success");
        return "redirect:/";
    }
}
