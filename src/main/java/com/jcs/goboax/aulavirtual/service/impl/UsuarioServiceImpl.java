package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.PerfilDao;
import com.jcs.goboax.aulavirtual.dao.api.UsuarioDao;
import com.jcs.goboax.aulavirtual.dao.api.UsuarioPerfilDao;
import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.model.UsuarioPerfil;
import com.jcs.goboax.aulavirtual.model.UsuarioPerfilPK;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl
        implements UsuarioService
{
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PerfilDao perfilDao;

    @Autowired
    private UsuarioPerfilDao usuarioPerfilDao;

    @Override
    public List<Perfil> readPerfiles()
    {
        return perfilDao.findWithNamedQuery(Perfil.PROFILE_ALL_QUERYNAME);
    }

    @Override
    public Perfil readPerfil(String aCode)
    {
        return perfilDao.getProfileByCode(aCode);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void createUser(Usuario aUsuario)
    {
        usuarioDao.persist(aUsuario);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void createUserProfile(UsuarioPerfil aUsuarioPerfil)
    {
        UsuarioPerfilPK myUsuarioPerfilPK = new UsuarioPerfilPK();
        myUsuarioPerfilPK.setUsuarioId(aUsuarioPerfil.getUsuario().getUsuarioId());
        myUsuarioPerfilPK.setPerfilId(aUsuarioPerfil.getPerfil().getPerfilId());
        aUsuarioPerfil.setId(myUsuarioPerfilPK);
        usuarioPerfilDao.persist(aUsuarioPerfil);
    }
}
