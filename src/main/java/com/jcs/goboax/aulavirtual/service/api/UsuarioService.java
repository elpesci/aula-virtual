package com.jcs.goboax.aulavirtual.service.api;

import java.util.List;

import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.model.UsuarioPerfil;

public interface UsuarioService
{
    /**
     * Read all the profiles stored into the data source.
     * @return
     */
    List<Perfil> readPerfiles();

    /**
     * Read the profile selected from the UI.
     * @param aCode
     * @return
     */
    Perfil readPerfil(String aCode);

    /**
     * Create new User.
     * @param aUsuario
     */
    void createUser(Usuario aUsuario);

    /**
     * Create Relation between User and Profile.
     * @param aUsuarioPerfil
     */
    void createUserProfile(UsuarioPerfil aUsuarioPerfil);

    void resetPassword(String anEmail);
}
