package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.TipoContenidoDao;
import com.jcs.goboax.aulavirtual.model.TipoContenido;
import com.jcs.goboax.aulavirtual.service.api.TipoContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TipoContenidoServiceImpl
        implements TipoContenidoService
{
    @Autowired
    TipoContenidoDao tipoContenidoDao;

    @Override
    public List<TipoContenido> readAllTipoContenido()
    {
        return tipoContenidoDao.readAllContentType();
    }

    @Cacheable(value = "searchResults")
    @Override
    public Map<Integer, String> readAllTipoContenidoMap()
    {
        Map<Integer, String> myMap = new HashMap<Integer, String>();
        for (TipoContenido myTipoContenido : readAllTipoContenido())
        {
            myMap.put(myTipoContenido.getTipoContenidoId(), myTipoContenido.getDescripcion());
        }
        return myMap;
    }
}
