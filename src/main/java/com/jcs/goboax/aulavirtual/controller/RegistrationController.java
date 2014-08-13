package com.jcs.goboax.aulavirtual.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcs.goboax.aulavirtual.exception.AulaVirtualRegistrationException;
import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.service.api.RegistrationService;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import com.jcs.goboax.aulavirtual.util.FlashMessage;
import com.jcs.goboax.aulavirtual.validator.RegistrationValidator;
import com.jcs.goboax.aulavirtual.viewmodel.Registration;

@Controller
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

    @Autowired
    private FlashMessage flashMessage;

    /**
     * Used to auto-login after activating an account
     */
    @Autowired
    @Qualifier("authenticationManager")
    protected AuthenticationManager authenticationManager;

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
        binder.addValidators(registrationValidator);
    }

    // Display the form on the get request
    @RequestMapping(method = RequestMethod.GET)
    public String showRegistration(Map<String, Object> aModel)
    {
        Registration registration = new Registration();
        aModel.put("registration", registration);
        aModel.put("profiles", profiles);
        return "login/registration";
    }

    @RequestMapping(params = "cancel", method = RequestMethod.POST)
    public String cancelRegistration()
    {
        return "redirect:/login";
    }

    @RequestMapping(params = "save", method = RequestMethod.POST)
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

            return "redirect:/";
        }
        catch (AulaVirtualRegistrationException e)
        {
            result.reject("registration.exception");
            return "login/registration";
        }
    }

    @RequestMapping("/activate/{userId}")
    public String activateAccount(HttpServletRequest aRequest, @PathVariable("userId") Integer aUserId,
                                  @RequestParam(
                                           "k") String aVerificationKey, Map<String, Object> aModel) throws UnsupportedEncodingException
    {
        Usuario myUsuario = usuarioService.activateAccount(aUserId, aVerificationKey);
        if (myUsuario != null && Usuario.UsuarioStatus.ACTIVE.equals(myUsuario.getStatus()))
        {
            flashMessage.success("subject.welcome");
            autoLogin(aRequest, myUsuario.getUsername(), myUsuario.getPassword());
        }
        else
        {
            flashMessage.error("error.resetpassword.notactive");

        }
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
        request.getSession();
        
        UserDetails myUserDetails = usuarioService.loadUserByUsername(username);
        Authentication authenticatedUser = 
            new UsernamePasswordAuthenticationToken(myUserDetails, null, myUserDetails
                .getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
}
