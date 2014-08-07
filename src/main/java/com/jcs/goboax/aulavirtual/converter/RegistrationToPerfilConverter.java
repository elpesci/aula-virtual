package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.exception.AulaVirtualPersistenceException;
import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import com.jcs.goboax.aulavirtual.util.Constants;
import com.jcs.goboax.aulavirtual.viewmodel.Registration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class RegistrationToPerfilConverter
        implements Converter<Registration, Perfil>
{
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationToPerfilConverter.class);
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Perfil convert(Registration registration)
    {
        try
        {
            return usuarioService.readPerfil(registration.getProfile());
        }
        catch (AulaVirtualPersistenceException e)
        {
            LOG.info("Setting Default Profile");
            return usuarioService.readPerfil(Constants.PROFILE_CODE_REGISTRATION_DEFAULT);
        }
    }
}
