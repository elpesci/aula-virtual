package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.api.TipoContenidoDao;
import com.jcs.goboax.aulavirtual.model.TipoContenido;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TipoContenidoDaoImpl
    extends BaseDaoImpl<Integer, TipoContenido>
    implements TipoContenidoDao
{

    @Override
    public List<TipoContenido> readAllContentType()
    {
        return findWithNamedQuery(TipoContenido.TIPO_CONTENIDO_ALL_QUERYNAME);
    }
}
