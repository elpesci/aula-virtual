package com.jcs.goboax.aulavirtual.service.impl;

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

    @Transactional
    @Override
    public boolean saveRegistration(Registration aRegistration) {        
        Usuario myUsuario = conversionService.convert(aRegistration, Usuario.class);
        LOG.debug("usuario : {}", myUsuario.getUsername());
        usuarioDao.persist(myUsuario);
        // TODO Auto-generated method stub
        return false;
    }

}
