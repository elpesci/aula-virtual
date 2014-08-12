package com.jcs.goboax.aulavirtual.controller;

import com.jcs.goboax.aulavirtual.exception.AulaVirtualException;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import com.jcs.goboax.aulavirtual.util.FlashMessage;
import com.jcs.goboax.aulavirtual.viewmodel.ForgetPasswordForm;
import com.jcs.goboax.aulavirtual.viewmodel.ResetPasswordForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/login/forgetPassword")
public class ForgetPasswordController
{
    private static final Logger LOG = LoggerFactory.getLogger(ForgetPasswordController.class);

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FlashMessage flashMessage;

    /**
     * Used to auto-login after activating an account
     */
    @Autowired
    @Qualifier("authenticationManager")
    protected AuthenticationManager authenticationManager;

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

    @RequestMapping(value = "/reset/{userId}/{temporalPwd}", method = RequestMethod.GET)
    public String forgetPassword(@PathVariable("userId") Integer aUserId,
                                 @PathVariable("temporalPwd") String aTemporalPwd,
                                 Map<String, Object> aModel)
    {
        Usuario myUsuario = usuarioService.getByCredentials(aUserId, aTemporalPwd);
        if (myUsuario != null && myUsuario.isChangePassword())
        {
            ResetPasswordForm resetForm = new ResetPasswordForm();
            myUsuario.setPassword(aTemporalPwd);
            resetForm.setUsuario(myUsuario);
            resetForm.setSendConfirmationEmail(false);
            aModel.put("resetPasswordForm", resetForm);
            aModel.put("target", "/login/forgetPassword/resetpassword");
            return "login/resetpassword";
        }
        else
        {
            flashMessage.error("error.resetpassword.notactive");
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
    public String resetPasswordSubmit(@ModelAttribute("resetPasswordForm") ResetPasswordForm resetForm,
                                      BindingResult result, HttpServletRequest request)
    {

        Usuario myUsuario = resetForm.getUsuario();
        resetForm.setUsuario(usuarioService.getByCredentials(myUsuario.getUsuarioId(), myUsuario.getPassword()));

        if (result.hasErrors())
        {
            resetForm.setUsuario(myUsuario);
            return "login/resetpassword";
        }

        myUsuario = resetForm.getUsuario();
        LOG.debug("updating password for user = {}", myUsuario.getUsuarioId());
        myUsuario = usuarioService.updatePassword(myUsuario, resetForm.getNewPassword());
        LOG.debug("new Password {}", myUsuario.getPassword());
        autoLogin(request, myUsuario.getUsername(), resetForm.getNewPassword());
//        if (resetForm.isSendConfirmationEmail())
//        {
//            usuarioService.sendActivationComplete(myUsuario);
//        }

        return "redirect:/";
    }

    /**
     * Auto logins a user using his username and password
     *
     * @param request  The http request to get the session
     * @param username The username of the user that will be auto logged
     * @param password The password of the user
     */
    private void autoLogin(HttpServletRequest request, String username, String password)
    {
        // generate session if one doesn't exist
        LOG.debug("Gnerate Token");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        LOG.debug("Gnerated Token {}", token);
        LOG.debug("Gnerated Token {}", token.isAuthenticated());
        request.getSession();
        LOG.debug("After Session");
        token.setDetails(new WebAuthenticationDetails(request));
        LOG.debug("Gnerated Token set details");
        Authentication authenticatedUser = authenticationManager.authenticate(token);
        LOG.debug("Authenticate");
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
        LOG.debug("END");
    }
}
