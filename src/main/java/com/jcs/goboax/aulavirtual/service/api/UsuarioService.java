package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.model.Usuario;

public interface UsuarioService
{
    /**
     * Retrieves a Profile given a User.
     * @param aUsuario
     * @return
     */
    Perfil getPerfil(Usuario aUsuario);
}
