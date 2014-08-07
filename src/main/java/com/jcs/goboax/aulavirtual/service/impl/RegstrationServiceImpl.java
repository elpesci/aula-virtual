package com.jcs.goboax.aulavirtual.service.impl;

import javax.security.sasl.AuthenticationException;

import com.jcs.goboax.aulavirtual.dao.api.PersonaDao;
import com.jcs.goboax.aulavirtual.model.Persona;

import com.jcs.goboax.aulavirtual.model.UsuarioPerfilPK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcs.goboax.aulavirtual.dao.api.UsuarioDao;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualException;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.service.api.RegistrationService;
import com.jcs.goboax.aulavirtual.viewmodel.Registration;

@Service
public class RegstrationServiceImpl
        implements RegistrationService
{

    private static final Logger LOG = LoggerFactory.getLogger(RegstrationServiceImpl.class);

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PersonaDao personaDao;


    @Transactional
    @Override
    public void saveRegistration(Registration aRegistration)
    {
        try
        {
            LOG.debug("Convert to Persona {}", aRegistration.getEmail());
            Persona myPersona = conversionService.convert(aRegistration, Persona.class);
            LOG.debug("Convert to Usuario {}", aRegistration.getEmail());
            Usuario myUsuario = conversionService.convert(aRegistration, Usuario.class);

            LOG.debug("Persist Persona {}", myPersona.getCorreoElectronico());
            personaDao.persist(myPersona);
            myUsuario.setPersonaId(myPersona);
            LOG.debug("Persist Usurio related to Persona [{}, {}]",
                    myUsuario.getUsername(), myPersona.getPersonaId());
            usuarioDao.persist(myUsuario);

            UsuarioPerfilPK myUsuarioPerfilPK = new UsuarioPerfilPK();
        }
        catch (RuntimeException e)
        {
            LOG.error("The system can not save the Registration request", e);
            throw new AulaVirtualException("The system can not save the Registration request", e);
        }
    }

}
