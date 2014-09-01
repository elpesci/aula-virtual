package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.api.ExtensionContenidoDao;
import com.jcs.goboax.aulavirtual.model.ExtensionContenido;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ExtensionContenidoDaoImpl
    extends BaseDaoImpl<Integer, ExtensionContenido>
    implements ExtensionContenidoDao
{
    @Override
    public List<String> readExtensionesContenido()
    {
        TypedQuery<String> myTypedQuery =
                entityManager.createNamedQuery(ExtensionContenido.EXTENSION_CONTENIDO_EXTENSIONES, String.class);

        return myTypedQuery.getResultList();
    }
}
