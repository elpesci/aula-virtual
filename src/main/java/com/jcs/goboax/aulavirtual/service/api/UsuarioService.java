package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Perfil;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.model.UsuarioPerfil;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService
        extends UserDetailsService
{
    /**
     * Read all the profiles stored into the data source.
     *
     * @return
     */
    List<Perfil> readPerfiles();

    /**
     * Read the profile selected from the UI.
     *
     * @param aCode
     * @return
     */
    Perfil readPerfil(String aCode);

    /**
     * Create new User.
     *
     * @param aUsuario
     */
    void createUser(Usuario aUsuario);

    /**
     * Create Relation between User and Profile.
     *
     * @param aUsuarioPerfil
     */
    void createUserProfile(UsuarioPerfil aUsuarioPerfil);

    /**
     * Reset Password, generate one temporal and change the status.
     *
     * @param anEmail
     */
    void resetPassword(String anEmail);

    Usuario getByCredentials(Integer aUserId, String aPassword);

    Usuario updatePassword(Usuario aUsuario, String aNewPassword);

    Usuario activateAccount(Integer aUserId, String aVerificationKey);

    void sendActivationComplete(Usuario anUsuario);

    Usuario readByEmail(String anEmail);

    /**
     * Read All Users.
     * @return
     */
    List<Usuario> readUsuarios();
    
    Usuario readById(Integer aUserId);
    
    Usuario updateUser(Usuario aUsuario);
}
