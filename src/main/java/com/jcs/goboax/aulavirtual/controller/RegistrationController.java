package com.jcs.goboax.aulavirtual.controller;

import com.jcs.goboax.aulavirtual.service.api.RegistrationService;
import com.jcs.goboax.aulavirtual.validator.RegistrationValidator;
import com.jcs.goboax.aulavirtual.viewmodel.Registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/login/registration")
public class RegistrationController
{
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private RegistrationValidator registrationValidator;
    
    @Autowired
    private RegistrationService registrationService;    

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(registrationValidator);
    }

    // Display the form on the get request
    @RequestMapping(method = RequestMethod.GET)
    public String showRegistration(Map aModel) {
        Registration registration = new Registration();
        aModel.put("registration", registration);
        return "login/registration";
    }

    // Process the form.
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@Validated Registration registration,
                                      BindingResult result) {

        if (result.hasErrors()) {
            return "login/registration";
        }
        LOG.debug("Processing Registration....");
        registrationService.saveRegistration(registration);
        
        return "login";
    }
}
