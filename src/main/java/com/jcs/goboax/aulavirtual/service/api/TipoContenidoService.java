package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.TipoContenido;

import java.util.List;
import java.util.Map;

public interface TipoContenidoService
{
    List<TipoContenido> readAllTipoContenido();

    public Map<Integer, String> readAllTipoContenidoMap();
}
