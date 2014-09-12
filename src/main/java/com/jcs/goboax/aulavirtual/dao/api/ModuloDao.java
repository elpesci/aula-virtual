package com.jcs.goboax.aulavirtual.dao.api;

import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.model.Modulo;

import java.util.List;

public interface ModuloDao
    extends IDao<Integer, Modulo>
{
    List<Modulo> readByCourse(Curso aCurso);

    List<Modulo> readByCourse(Integer aCursoId);
}
