package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.api.ValoracionDao;
import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.model.Valoracion;
import com.jcs.goboax.aulavirtual.model.ValoracionPK;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ValoracionDaoImpl
        extends BaseDaoImpl<ValoracionPK, Valoracion>
        implements ValoracionDao
{
    @Override
    public List<Valoracion> retrieveValoracionByUser(Integer aUserId)
    {
        TypedQuery<Valoracion> myQuery = entityManager.createNamedQuery(Valoracion.VALORACION_BY_USER_ID, Valoracion.class);
        myQuery.setParameter(Valoracion.VALORACION_USER_ID_PARAM, aUserId);

        return myQuery.getResultList();
    }
}
