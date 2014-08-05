package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.PersonaDao;
import com.jcs.goboax.aulavirtual.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcs.goboax.aulavirtual.dao.api.UsuarioDao;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.service.api.RegistrationService;
import com.jcs.goboax.aulavirtual.viewmodel.Registration;

@Service
public class RegstrationServiceImpl 
    implements RegistrationService {
    
    private static final Logger LOG = LoggerFactory.getLogger(RegstrationServiceImpl.class);
    
    @Autowired
    private ConversionService conversionService;
    
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PersonaDao personaDao;


    @Transactional
    @Override
    public boolean saveRegistration(Registration aRegistration) {
        Persona myPersona = conversionService.convert(aRegistration, Persona.class);
        Usuario myUsuario = conversionService.convert(aRegistration, Usuario.class);

        personaDao.persist(myPersona);
        myUsuario.setPersonaId(myPersona);
        usuarioDao.persist(myUsuario);



        return false;
    }

}
