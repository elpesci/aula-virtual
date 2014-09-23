package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.TipoContenido;

import java.util.List;

public interface TipoContenidoService
{
    List<TipoContenido> readAllTipoContenido();

    /**
     * Read all the valid extension to content store.
     * @return List of the allowed extensions.
     */
    List<String> readExtensionesContenido();
}
