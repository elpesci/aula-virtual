package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.RegistroAcceso;

public interface RegistroAccesoService
{
    void createRecord(RegistroAcceso registroAcceso);

    RegistroAcceso readRegistroAccesoBySessionId(String aSessionId);

    RegistroAcceso updateRegistroAcceso(RegistroAcceso aRegistroAcceso);
}
