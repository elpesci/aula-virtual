package com.jcs.goboax.aulavirtual.dao.api;

import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.model.Modulo;

import java.util.List;

public interface ContenidoDao
        extends IDao<Integer, Contenido>
{
    /**
     * @param aModulo
     * @return
     */
    List<Contenido> readContentsByModule(Modulo aModulo);
}
