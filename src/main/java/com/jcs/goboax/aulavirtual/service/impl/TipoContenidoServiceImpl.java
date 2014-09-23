package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.ExtensionContenidoDao;
import com.jcs.goboax.aulavirtual.dao.api.TipoContenidoDao;
import com.jcs.goboax.aulavirtual.model.TipoContenido;
import com.jcs.goboax.aulavirtual.service.api.TipoContenidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoContenidoServiceImpl
        implements TipoContenidoService
{
    private static final Logger LOG = LoggerFactory.getLogger(TipoContenidoServiceImpl.class);

    @Autowired
    private TipoContenidoDao tipoContenidoDao;

    @Autowired
    private ExtensionContenidoDao extensionContenidoDao;

    @Cacheable(value = "readResults")
    @Override
    public List<TipoContenido> readAllTipoContenido()
    {
        return tipoContenidoDao.readAllContentType();
    }

    @Cacheable(value = "readStringResults")
    @Override
    public List<String> readExtensionesContenido()
    {
        LOG.debug("{}", extensionContenidoDao.readExtensionesContenido());
        return extensionContenidoDao.readExtensionesContenido();
    }
}
