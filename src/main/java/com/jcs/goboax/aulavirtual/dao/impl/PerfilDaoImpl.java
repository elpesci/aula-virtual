package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.api.PerfilDao;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualPersistenceException;
import com.jcs.goboax.aulavirtual.model.Perfil;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

@Repository
public class PerfilDaoImpl
        extends BaseDaoImpl<Integer, Perfil>
        implements PerfilDao
{

    @Override
    public Perfil getProfileByCode(String aCode)
    {
        TypedQuery<Perfil> myQuery = entityManager.createNamedQuery(Perfil.PROFILE_BY_CODE_QUERYNAME, entityClass);
        myQuery.setParameter(Perfil.PROFILE_BY_CODE_PARAMETER, aCode);
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
}
