package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.PerfilDao;
import com.jcs.goboax.aulavirtual.dao.api.PersonaDao;
import com.jcs.goboax.aulavirtual.dao.api.UsuarioDao;
import com.jcs.goboax.aulavirtual.dao.api.UsuarioPerfilDao;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualException;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualPersistenceException;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualRegistrationException;
import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.model.Persona;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.model.Usuario.UsuarioStatus;
import com.jcs.goboax.aulavirtual.model.UsuarioPerfil;
import com.jcs.goboax.aulavirtual.model.UsuarioPerfilPK;
import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.service.api.EmailService;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import com.jcs.goboax.aulavirtual.util.Constants;
import com.jcs.goboax.aulavirtual.util.Utils;
import com.jcs.goboax.aulavirtual.viewmodel.UsuarioUpdateModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

@Service("usuarioService")
public class UsuarioServiceImpl
        implements UsuarioService
{
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private PersonaDao personaDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PerfilDao perfilDao;

    @Autowired
    private UsuarioPerfilDao usuarioPerfilDao;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AuthenticationService authenticationService;

    @Cacheable(value = "readResults")
    @Transactional(readOnly = true)
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
            aUsuario.setHabilitado(Boolean.TRUE);
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

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserProfile(UsuarioPerfil aUsuarioPerfil)
    {
        UsuarioPerfilPK myUsuarioPerfilPK = new UsuarioPerfilPK();
        myUsuarioPerfilPK.setUsuarioId(aUsuarioPerfil.getUsuario()
                .getUsuarioId());
        myUsuarioPerfilPK.setPerfilId(aUsuarioPerfil.getPerfil().getPerfilId());
        aUsuarioPerfil.setId(myUsuarioPerfilPK);
        usuarioPerfilDao.update(aUsuarioPerfil);
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
            myUsuario.setFechaModificacion(new Date());
            myUsuario.setModificadoPor(authenticationService.getUsuario().getUsuarioId());
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

    @Override
    public List<Usuario> readUsuarios()
    {
        return usuarioDao.findWithNamedQuery(Usuario.USUARIO_NOT_SUPERADMIN);
    }

    @Override
    public Usuario readById(Integer aUserId)
    {
        return usuarioDao.findByKey(aUserId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Usuario updateUser(Usuario aUsuario)
    {
        return usuarioDao.update(aUsuario);
    }

    @Transactional
    @Override
    public void updateRegistration(UsuarioUpdateModel aRegistration, ConversionService conversionService)
    {
        try
        {
            Usuario myUsuario = readByEmail(aRegistration.getEmail());
            Persona myPersona = myUsuario.getPersona();
            myPersona.setApellidoPaterno(aRegistration.getLastName());
            myPersona.setApellidoMaterno(aRegistration.getSecondLastName());
            myPersona.setNombre(aRegistration.getName());
            myPersona.setFechaModificacion(new Date());
            LOG.debug("Convert to Usuario {}", aRegistration.getEmail());
            Perfil myPerfil = conversionService.convert(aRegistration, Perfil.class);
            LOG.debug("Profile to assign {}", myPerfil.getCodigo());

            LOG.debug("Update Persona {}", myPersona.getCorreoElectronico());
            personaDao.update(myPersona);
            myUsuario.setPersona(myPersona);
            myUsuario.setHabilitado(aRegistration.getHabilitado());
            if (aRegistration.getHabilitado())
            {
                myUsuario.setStatus(UsuarioStatus.ACTIVE);
            }
            else
            {
                myUsuario.setStatus(UsuarioStatus.DISABLED);
            }
            myUsuario.setFechaModificacion(new Date());
            myUsuario.setModificadoPor(authenticationService.getUsuario().getUsuarioId());
            LOG.debug("Updating Usuario [{}]",
                    myUsuario.getUsername());

            updateUser(myUsuario);

            for (UsuarioPerfil myUsuarioPerfil : myUsuario.getUsuarioPerfils())
            {
                if (myUsuarioPerfil.getPerfil() != myPerfil)
                {
                    usuarioPerfilDao.remove(myUsuarioPerfil.getId());

                    UsuarioPerfil myUsuarioPerfilNew = new UsuarioPerfil();
                    myUsuarioPerfilNew.setCreadoPor(Constants.SUPER_USER_ID);
                    myUsuarioPerfilNew.setFechaCreacion(new Date());
                    myUsuarioPerfilNew.setUsuario(myUsuario);
                    myUsuarioPerfilNew.setPerfil(myPerfil);

                    createUserProfile(myUsuarioPerfilNew);
                }
            }


        }
        catch (RuntimeException e)
        {
            LOG.error("The system can not save the Registration request", e);
            throw new AulaVirtualRegistrationException("The system can not save the Registration request", e);
        }
    }
}
