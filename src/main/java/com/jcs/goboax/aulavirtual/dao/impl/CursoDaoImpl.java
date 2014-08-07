package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.BaseDao;
import com.jcs.goboax.aulavirtual.dao.api.CursoDao;
import com.jcs.goboax.aulavirtual.model.Curso;
import org.springframework.stereotype.Repository;

@Repository
public class CursoDaoImpl
    extends BaseDao<Integer, Curso>
    implements CursoDao
{
}
