package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.api.ContenidoDao;
import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.model.Modulo;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ContenidoDaoImpl
        extends BaseDaoImpl<Integer, Contenido>
        implements ContenidoDao
{
    @Override
    public List<Contenido> readContentsByModule(Modulo aModulo)
    {
        TypedQuery<Contenido> myTypedQuery =
                entityManager.createNamedQuery(Contenido.CONTENT_BY_MODULE, entityClass);
        myTypedQuery.setParameter(Contenido.CONTENT_MODULE_PARAMETER, aModulo);
        return myTypedQuery.getResultList();
    }
}
