package com.jcs.goboax.aulavirtual.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcs.goboax.aulavirtual.exception.AulaVirtualRegistrationException;
import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.service.api.RegistrationService;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import com.jcs.goboax.aulavirtual.validator.RegistrationValidator;
import com.jcs.goboax.aulavirtual.viewmodel.Registration;

@Controller
@Scope(value = "request")
@RequestMapping("/login/registration")
public class RegistrationController
{
    private static final Logger LOG = LoggerFactory
            .getLogger(RegistrationController.class);

    @Autowired
    private RegistrationValidator registrationValidator;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UsuarioService usuarioService;

    private Map<String, String> profiles;

    @PostConstruct
    public void init()
    {
        List<Perfil> myProfiles = usuarioService.readPerfiles();
        profiles = registrationService.convertProfilesToMap(myProfiles);
        
    }

    @InitBinder
    private void initBinder(WebDataBinder binder)
    {
        binder.setValidator(registrationValidator);
    }

    // Display the form on the get request
    @RequestMapping(method = RequestMethod.GET)
    public String showRegistration(Map aModel)
    {
        Registration registration = new Registration();
        aModel.put("registration", registration);
        aModel.put("profiles", profiles);
        return "login/registration";
    }

    // Process the form.
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@Validated Registration registration,
            BindingResult result)
    {
        try
        {
            if (result.hasErrors())
            {
                return "login/registration";
            }
            LOG.debug("Processing Registration....");
            registrationService.createRegistration(registration);

            return "login";
        }
        catch (AulaVirtualRegistrationException e)
        {
            result.reject("registration.exception");
            return "login/registration";
        }
    }
}
