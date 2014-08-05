package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.UsuarioDao;
import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioServiceImpl
    implements UsuarioService
{
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Perfil getPerfil(Usuario aUsuario)
    {
        return null;
    }
}
