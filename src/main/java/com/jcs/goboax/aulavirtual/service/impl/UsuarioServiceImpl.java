package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.PerfilDao;
import com.jcs.goboax.aulavirtual.dao.api.UsuarioDao;
import com.jcs.goboax.aulavirtual.dao.api.UsuarioPerfilDao;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualException;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualPersistenceException;
import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.model.Usuario.UsuarioStatus;
import com.jcs.goboax.aulavirtual.model.UsuarioPerfil;
import com.jcs.goboax.aulavirtual.model.UsuarioPerfilPK;
import com.jcs.goboax.aulavirtual.service.api.EmailService;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import com.jcs.goboax.aulavirtual.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service("usuarioService")
public class UsuarioServiceImpl
        implements UsuarioService
{
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);

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
        try
        {
            String myVerificationKey = Utils.generateVerificationKey(aUsuario.getUsername(), aUsuario.getPassword());
            aUsuario.setVerificationKey(myVerificationKey);
            aUsuario.setStatus(UsuarioStatus.VERIFICATION_PENDING);
            LOG.debug("Status set to: {}", UsuarioStatus.VERIFICATION_PENDING);
            usuarioDao.persist(aUsuario);
        }
        catch (NoSuchAlgorithmException e)
        {
            LOG.error("Unable to generate Validation Key", e);
            throw new AulaVirtualPersistenceException("Unable to generate Validation Key", e);
        }
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

    @Override
    public Usuario getByCredentials(Integer aUserId, String aPassword)
    {
        return usuarioDao.getByCredentials(aUserId, aPassword);
    }

    @Transactional
    @Override
    public Usuario updatePassword(Usuario aUsuario, String aNewPassword)
    {
        if (aUsuario.isChangePassword())
        {
            aUsuario.setStatus(Usuario.UsuarioStatus.ACTIVE);
        }
        aUsuario.setPassword(Utils.encodePassword(aNewPassword));

        return usuarioDao.update(aUsuario);
    }

    @Transactional
    @Override
    public Usuario activateAccount(Integer aUserId, String aVerificationKey)
    {
        Usuario myUsuario = usuarioDao.findByKey(aUserId);
        LOG.debug("User to Activate {}", myUsuario);

        if (myUsuario != null
                && myUsuario.isVerificationPending()
                && aVerificationKey.equals(myUsuario.getVerificationKey()))
        {
            myUsuario.setVerificationKey(null);
            myUsuario.setStatus(UsuarioStatus.ACTIVE);
            usuarioDao.update(myUsuario);
            sendActivationComplete(myUsuario);
            
            return myUsuario;
        }
        
        return null;
    }

    private String resetPassword(Usuario aUsuario)
    {
        String password = Utils.generateRandomPassword();
        aUsuario.setPassword(Utils.encodePassword(password));
        aUsuario.setStatus(Usuario.UsuarioStatus.CHANGE_PASSWORD);
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

    @Override
    public void sendActivationComplete(Usuario anUsuario)
    {
        emailService.sendActivationComplete(anUsuario);
    }

    @Override
    public Usuario readByEmail(String anEmail)
    {
        return usuarioDao.findByEmail(anEmail);
    }
}
