package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.RegistroAccesoDao;
import com.jcs.goboax.aulavirtual.model.RegistroAcceso;
import com.jcs.goboax.aulavirtual.service.api.RegistroAccesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistroAccesoServiceImpl
    implements RegistroAccesoService
{
    @Autowired
    private RegistroAccesoDao registroAccesoDao;

    @Transactional
    @Override
    public void createRecord(RegistroAcceso registroAcceso)
    {
        registroAccesoDao.persist(registroAcceso);
    }
}
