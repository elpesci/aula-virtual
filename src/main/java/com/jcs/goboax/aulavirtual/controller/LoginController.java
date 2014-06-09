/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcs.goboax.aulavirtual.controller;

import com.jcs.goboax.aulavirtual.dal.UsuarioDao;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.viewmodel.LoginViewModel;
import java.util.Map;
import javax.persistence.TypedQuery;
import javax.persistence.NoResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private final static Logger LOG = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() 
    {
        return new ModelAndView("login", "command", new LoginViewModel());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView processForm(LoginViewModel aLoginViewModel, BindingResult resultl) 
    {
        LOG.debug("doLogin {}");
        
        boolean success = tryLogin(aLoginViewModel.getNombreUsuario(), aLoginViewModel.getPassword());
        
        if(success) {
            return new ModelAndView("home");
        } else {
            LoginViewModel vm = new LoginViewModel();
            vm.setNombreUsuario(aLoginViewModel.getNombreUsuario());
            vm.setIsSuccess(false);
            vm.setMessage("Las credendiales proporcionadas son incorrectas. Por favor intente nuevamente.");
            
            return new ModelAndView("login", "command", vm);
        }
    }
    
    /* Private Methods */
    private boolean tryLogin(String userName, String password) 
    {
        LOG.debug("private tryLogin {}", userName, password);
        boolean result;
        try {
            Usuario usuario = usuarioDao.tryLogin(userName, password);
            result = usuario != null;
        } catch (NoResultException exc) {
            LOG.info("Fallo en login. Usuario " +userName+ " no existe en Aula Virtual");
            result = false;
        }
        
        
        return result;
    }
}
