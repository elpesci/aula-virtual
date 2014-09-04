package com.jcs.goboax.aulavirtual.converter;

import org.springframework.core.convert.converter.Converter;

import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.viewmodel.CourseModel;

public class CursoToCourseModelConverter
    implements Converter<Curso, CourseModel>
{

    @Override
    public CourseModel convert(Curso aCurso)
    {
        CourseModel myCourseModel = new CourseModel();
        myCourseModel.setId(aCurso.getCursoId());
        myCourseModel.setGoal(aCurso.getObjetivo());
        myCourseModel.setAddressedTo(aCurso.getAudiencia());
        myCourseModel.setName(aCurso.getNombre());
        myCourseModel.setActive(aCurso.getHabilitado());
        return myCourseModel;
    }

}
