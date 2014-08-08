package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.api.ContenidoDao;
import com.jcs.goboax.aulavirtual.model.Contenido;
import org.springframework.stereotype.Repository;

@Repository
public class ContenidoDaoImpl
        extends BaseDaoImpl<Integer, Contenido>
        implements ContenidoDao
{
}
