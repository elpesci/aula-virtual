package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.api.CursoDao;
import com.jcs.goboax.aulavirtual.dao.api.ModuloDao;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.model.Modulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ModuloDaoImpl
        extends BaseDaoImpl<Integer, Modulo>
        implements ModuloDao
{
    @Autowired
    private CursoDao cursoDao;

    @Override
    public List<Modulo> readByCourse(Curso aCurso)
    {
        TypedQuery<Modulo> myQuery = entityManager.createNamedQuery(Modulo.MODULE_BY_COURSE, Modulo.class);
        myQuery.setParameter(Modulo.MODULE_COURSE_PARAMETER, aCurso);

        return myQuery.getResultList();
    }

    @Override
    public List<Modulo> readByCourse(Integer aCursoId)
    {
        Curso myCurso = cursoDao.findByKey(aCursoId);
        return readByCourse(myCurso);
    }
}
