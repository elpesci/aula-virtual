package com.jcs.goboax.aulavirtual.dao.api;

import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.model.Modulo;

import java.util.List;

public interface ModuloDao
    extends IDao<Integer, Modulo>
{
    List<Modulo> readByCourse(Curso aCurso);

    List<Modulo> readByCourse(Integer aCursoId);

    /**
     * Retrieve all the modules given a course
     * @param aCurso Course to filter the modules.
     * @param onlyActives When it's true retrieve only active, otherwise retrieve all of them.
     * @return
     */
    List<Modulo> readByCourse(Curso aCurso, Boolean onlyActives);

    /**
     * Retreive
     * @param aCourseId
     * @param onlyActives When it's true retrieve only active, otherwise retrieve all of them.
     * @return
     */
    List<Modulo> readByCourse(Integer aCourseId, Boolean onlyActives);
    
    /**
     * Returns all Modules for a particular course that do not have an exam
     * @param aCourseId
     * @return
     */
    List<Modulo> readByCourseNoExam(Curso aCurso);
}