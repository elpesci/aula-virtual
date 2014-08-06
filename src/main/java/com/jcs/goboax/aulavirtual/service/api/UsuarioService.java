package com.jcs.goboax.aulavirtual.service.api;

import java.util.List;

import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.model.Usuario;

public interface UsuarioService
{
    /**
     * Read all the profiles stored into the data source.
     * @return
     */
    List<Perfil> readPerfiles();
    
    void createUser(Usuario aUsuario);
}
