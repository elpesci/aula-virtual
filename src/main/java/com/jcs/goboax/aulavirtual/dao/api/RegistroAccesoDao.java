package com.jcs.goboax.aulavirtual.dao.api;

import com.jcs.goboax.aulavirtual.model.RegistroAcceso;

public interface RegistroAccesoDao
    extends IDao<Integer, RegistroAcceso>
{
    RegistroAcceso readBySessionId(String aSessionId);
}
