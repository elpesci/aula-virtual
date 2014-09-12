package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.ModuloDao;
import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.service.api.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl
        implements ModuleService
{
    @Autowired
    private ModuloDao moduloDao;


    @Override
    public List<Modulo> readModulesByCourse(Integer aCourseId)
    {
        return moduloDao.readByCourse(aCourseId);
    }
}
