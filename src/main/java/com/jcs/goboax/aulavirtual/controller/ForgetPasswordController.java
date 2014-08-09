package com.jcs.goboax.aulavirtual.controller;

import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import com.jcs.goboax.aulavirtual.viewmodel.CourseModel;
import com.jcs.goboax.aulavirtual.viewmodel.ForgetPasswordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/login/forgetPassword")
public class ForgetPasswordController
{
    @Autowired
    private UsuarioService usuarioService;

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

        usuarioService.resetPassword(forgetPasswordForm.getEmail());

        return "redirect:/";
    }
}
