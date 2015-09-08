package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.model.UsuarioPerfil;
import com.jcs.goboax.aulavirtual.viewmodel.UsuarioUpdateModel;
import org.springframework.core.convert.converter.Converter;

public class UsuarioToUsuarioUpdateModel
    implements Converter<Usuario, UsuarioUpdateModel>
{
    @Override
    public UsuarioUpdateModel convert(Usuario usuario)
    {
        UsuarioUpdateModel myUsuarioUpdateModel = new UsuarioUpdateModel();
        myUsuarioUpdateModel.setEmail(usuario.getUsername());
        myUsuarioUpdateModel.setLastName(usuario.getPersona().getApellidoPaterno());
        myUsuarioUpdateModel.setSecondLastName(usuario.getPersona().getApellidoMaterno());
        myUsuarioUpdateModel.setName(usuario.getPersona().getNombre());
        StringBuilder myProfiles = new StringBuilder();
        for (UsuarioPerfil myUsuarioPerfil : usuario.getUsuarioPerfils())
        {
            myProfiles.append(myUsuarioPerfil.getPerfil().getCodigo());
        }
        myUsuarioUpdateModel.setProfile(myProfiles.toString());
        myUsuarioUpdateModel.setHabilitado(usuario.getHabilitado());
        return myUsuarioUpdateModel;
    }
}
