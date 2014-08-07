package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.CursoDao;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.service.api.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl
    implements CursoService
{
    @Autowired
    private CursoDao cursoDao;

    @Override
    public List<Curso> getCursos()
    {
        return cursoDao.findWithNamedQuery(Curso.CURSO_ALL_QUERYNAME);
    }
}
