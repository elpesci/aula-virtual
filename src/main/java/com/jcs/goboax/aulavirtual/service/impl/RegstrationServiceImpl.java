package com.jcs.goboax.aulavirtual.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jcs.goboax.aulavirtual.model.UsuarioPerfil;
import com.jcs.goboax.aulavirtual.service.api.EmailService;
import com.jcs.goboax.aulavirtual.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcs.goboax.aulavirtual.dao.api.PersonaDao;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualRegistrationException;
import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.model.Persona;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.service.api.RegistrationService;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import com.jcs.goboax.aulavirtual.viewmodel.Registration;

@Service
public class RegstrationServiceImpl
        implements RegistrationService
{

    private static final Logger LOG = LoggerFactory.getLogger(RegstrationServiceImpl.class);

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PersonaDao personaDao;

    @Autowired EmailService emailService;


    @Transactional
    @Override
    public void createRegistration(Registration aRegistration)
    {
        try
        {
            LOG.debug("Convert to Persona {}", aRegistration.getEmail());
            Persona myPersona = conversionService.convert(aRegistration, Persona.class);
            LOG.debug("Convert to Usuario {}", aRegistration.getEmail());
            Usuario myUsuario = conversionService.convert(aRegistration, Usuario.class);
            Perfil myPerfil = conversionService.convert(aRegistration, Perfil.class);
            LOG.debug("Profile to assign {}", myPerfil.getCodigo());

            LOG.debug("Persist Persona {}", myPersona.getCorreoElectronico());
            personaDao.persist(myPersona);
            myUsuario.setPersona(myPersona);
            LOG.debug("Persist Usuario [{}]",
                    myUsuario.getUsername());
            usuarioService.createUser(myUsuario);

            UsuarioPerfil myUsuarioPerfil = new UsuarioPerfil();
            myUsuarioPerfil.setCreadoPor(Constants.SUPER_USER_ID);
            myUsuarioPerfil.setFechaCreacion(new Date());
            myUsuarioPerfil.setUsuario(myUsuario);
            myUsuarioPerfil.setPerfil(myPerfil);

            usuarioService.createUserProfile(myUsuarioPerfil);
            emailService.sendWelcomeEmail(myUsuario);
        }
        catch (RuntimeException e)
        {
            LOG.error("The system can not save the Registration request", e);
            throw new AulaVirtualRegistrationException("The system can not save the Registration request", e);
        }
    }


    @Override
    public Map<String, String> convertProfilesToMap(List<Perfil> aProfiles)
    {
        Map<String, String> myReturn = new HashMap<String, String>();
        for (Perfil myPerfil : aProfiles)
        {
            myReturn.put(myPerfil.getCodigo(), myPerfil.getNombre());
        }
        
        return myReturn;
    }
}
