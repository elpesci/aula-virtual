/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.api.UsuarioDao;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualPersistenceException;
import com.jcs.goboax.aulavirtual.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

/**
 * @author julio
 */
@Repository
public class UsuarioDaoImpl
        extends BaseDaoImpl<Integer, Usuario>
        implements UsuarioDao
{

    @Override
    public Usuario findByEmail(String anEmail)
    {
        TypedQuery<Usuario> myQuery = entityManager.createNamedQuery(Usuario.USUARIO_BY_EMAIL, entityClass);
        myQuery.setParameter(Usuario.USUARIO_EMAIL_PARAMETER, anEmail);
        try
        {
            return myQuery.getSingleResult();
        }
        catch (NoResultException e)
        {
            throw new AulaVirtualPersistenceException("No Result for Query", e);
        }
        catch (NonUniqueResultException e)
        {
            throw new AulaVirtualPersistenceException("More than one result", e);
        }
    }

    @Override
    public Usuario getByCredentials(Integer aUserId, String aPassword)
    {
        Usuario myUsuario = findByKey(aUserId);
        if (myUsuario != null)
        {
            BCryptPasswordEncoder myBCryptPasswordEncoder = new BCryptPasswordEncoder();
            boolean isValid = myBCryptPasswordEncoder.matches(aPassword, myUsuario.getPassword());
            if (isValid)
            {
                return myUsuario;
            }
        }
        return null;
    }
}
