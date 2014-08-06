package com.jcs.goboax.aulavirtual.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jcs.goboax.aulavirtual.dao.api.PerfilDao;
import com.jcs.goboax.aulavirtual.dao.api.UsuarioDao;
import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;

@Service
public class UsuarioServiceImpl
        implements UsuarioService
{
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PerfilDao perfilDao;

    @Override
    public List<Perfil> readPerfiles()
    {
        return perfilDao.findWithNamedQuery(Perfil.PROFILE_ALL_QUERYNAME);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void createUser(Usuario aUsuario)
    {
        usuarioDao.persist(aUsuario);
    }

}
