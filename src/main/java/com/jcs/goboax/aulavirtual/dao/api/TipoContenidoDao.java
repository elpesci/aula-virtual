package com.jcs.goboax.aulavirtual.dao.api;

import com.jcs.goboax.aulavirtual.model.TipoContenido;

import java.util.List;

public interface TipoContenidoDao
        extends IDao<Integer, TipoContenido>
{
    List<TipoContenido> readAllContentType();
}
