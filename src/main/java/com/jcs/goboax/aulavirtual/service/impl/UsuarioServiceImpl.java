package com.jcs.goboax.aulavirtual.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jcs.goboax.aulavirtual.dao.api.PerfilDao;
import com.jcs.goboax.aulavirtual.dao.api.UsuarioDao;
import com.jcs.goboax.aulavirtual.dao.api.UsuarioPerfilDao;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualException;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualPersistenceException;
import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.model.UsuarioPerfil;
import com.jcs.goboax.aulavirtual.model.UsuarioPerfilPK;
import com.jcs.goboax.aulavirtual.service.api.EmailService;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import com.jcs.goboax.aulavirtual.util.Utils;

@Service("usuarioService")
public class UsuarioServiceImpl
        implements UsuarioService
{
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PerfilDao perfilDao;

    @Autowired
    private UsuarioPerfilDao usuarioPerfilDao;

    @Autowired
    private EmailService emailService;

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
        myUsuarioPerfilPK.setUsuarioId(aUsuarioPerfil.getUsuario()
                .getUsuarioId());
        myUsuarioPerfilPK.setPerfilId(aUsuarioPerfil.getPerfil().getPerfilId());
        aUsuarioPerfil.setId(myUsuarioPerfilPK);
        usuarioPerfilDao.persist(aUsuarioPerfil);
    }

    @Transactional
    @Override
    public void resetPassword(String anEmail)
    {
        Usuario myUsuario = usuarioDao.findByEmail(anEmail);
        String myPassword = resetPassword(myUsuario);
        if (myUsuario == null)
        {
            throw new AulaVirtualException("User Does not exists");
        }
        usuarioDao.update(myUsuario);
        emailService.sendTemporaryPasswordEmail(myUsuario, myPassword);
    }

    private String resetPassword(Usuario aUsuario)
    {
        String password = Utils.generateRandomPassword();
        aUsuario.setPassword(Utils.encodePassword(password));
        // aUsuario.setStatus(CHANGE_PASSWORD);
        return password;
    }

    @Override
    public UserDetails loadUserByUsername(String aUsername)
            throws UsernameNotFoundException
    {
        try
        {
            Usuario myUsuario = usuarioDao.findByEmail(aUsername);
            return myUsuario;
        }
        catch (AulaVirtualPersistenceException e)
        {
            throw new UsernameNotFoundException("user not found");
        }
    }
}
