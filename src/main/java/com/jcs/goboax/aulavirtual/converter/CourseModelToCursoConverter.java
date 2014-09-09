package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.dao.api.CursoDao;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.util.Constants;
import com.jcs.goboax.aulavirtual.viewmodel.CourseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class CourseModelToCursoConverter
        implements Converter<CourseModel, Curso>
{
    private static final Logger LOG = LoggerFactory.getLogger(CourseModelToCursoConverter.class);

    @Autowired
    private CursoDao cursoDao;

    @Override
    public Curso convert(CourseModel courseModel)
    {
        Curso myCurso = new Curso();
        if (courseModel.getId() != null)
        {
            myCurso = cursoDao.findByKey(courseModel.getId());
        }
        myCurso.setAudiencia(courseModel.getAddressedTo());
        myCurso.setObjetivo(courseModel.getGoal());
        myCurso.setNombre(courseModel.getName());
        myCurso.setHabilitado(courseModel.isActive());
        return myCurso;
    }
}
