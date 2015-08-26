package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.model.UsuarioPerfil;
import com.jcs.goboax.aulavirtual.util.Constants;
import com.jcs.goboax.aulavirtual.viewmodel.UsuarioModel;
import org.springframework.core.convert.converter.Converter;

public class UsuarioToUsuarioModelConverter
    implements Converter<Usuario, UsuarioModel>
{
    @Override
    public UsuarioModel convert(Usuario usuario)
    {
        UsuarioModel myUsuarioModel = new UsuarioModel();

        myUsuarioModel.setId(usuario.getUsuarioId());
        myUsuarioModel.setUsername(usuario.getUsername());
        StringBuilder myFullName = new StringBuilder();
        myFullName.append(usuario.getPersona().getNombre()).append(Constants.SPACE)
                .append(usuario.getPersona().getApellidoPaterno()).append(Constants.SPACE)
                .append(usuario.getPersona().getApellidoMaterno());
        myUsuarioModel.setName(myFullName.toString());

        StringBuilder myProfiles = new StringBuilder();
        for (UsuarioPerfil myUsuarioPerfil : usuario.getUsuarioPerfils())
        {
            myProfiles.append(myUsuarioPerfil.getPerfil().getNombre());
        }
        myUsuarioModel.setProfile(myProfiles.toString());
        myUsuarioModel.setStatus(usuario.getStatus());

        return myUsuarioModel;
    }
}
