package com.jcs.goboax.aulavirtual.dao.api;

import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.model.Curso;

import java.util.List;

public interface ContenidoDao
        extends IDao<Integer, Contenido>
{
    /**
     *
     * @param aCurso
     * @return
     */
    List<Contenido> readContentsByCourse(Curso aCurso);
}
