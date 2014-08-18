package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.util.Constants;
import com.jcs.goboax.aulavirtual.viewmodel.CourseModel;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class CourseModelToCursoConverter
        implements Converter<CourseModel, Curso>
{
    @Override
    public Curso convert(CourseModel courseModel)
    {
        Curso myCurso = new Curso();
        myCurso.setCursoId(courseModel.getId());
        myCurso.setCreadoPor(Constants.SUPER_USER_ID);
        myCurso.setFechaCreacion(new Date());
        myCurso.setAudiencia(courseModel.getAddressedTo());
        myCurso.setObjetivo(courseModel.getGoal());
        myCurso.setNombre(courseModel.getName());
        myCurso.setHabilitado(true);
        return myCurso;
    }
}
