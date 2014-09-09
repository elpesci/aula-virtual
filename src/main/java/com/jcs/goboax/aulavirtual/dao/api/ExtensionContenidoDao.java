package com.jcs.goboax.aulavirtual.dao.api;

import com.jcs.goboax.aulavirtual.model.ExtensionContenido;

import java.util.List;

public interface ExtensionContenidoDao
    extends IDao<Integer, ExtensionContenido>
{
    List<String> readExtensionesContenido();
}
