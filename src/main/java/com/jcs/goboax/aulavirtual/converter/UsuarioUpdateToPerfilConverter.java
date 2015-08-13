package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.exception.AulaVirtualPersistenceException;
import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import com.jcs.goboax.aulavirtual.util.Constants;
import com.jcs.goboax.aulavirtual.viewmodel.UsuarioUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class UsuarioUpdateToPerfilConverter
    implements Converter<UsuarioUpdateModel, Perfil>
{
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Perfil convert(UsuarioUpdateModel usuarioUpdateModel)
    {
        try
        {
            return usuarioService.readPerfil(usuarioUpdateModel.getProfile());
        }
        catch (AulaVirtualPersistenceException e)
        {
            return usuarioService.readPerfil(Constants.PROFILE_CODE_REGISTRATION_DEFAULT);
        }
    }
}
