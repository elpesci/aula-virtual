package com.jcs.goboax.aulavirtual.converter;

import org.springframework.core.convert.converter.Converter;

import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.viewmodel.ExamModel;

public class ExamenToExamModelConverter 
    implements Converter<Examen, ExamModel>
{

    @Override
    public ExamModel convert(Examen aExamen) {
        
        ExamModel myExamModel = new ExamModel();
        myExamModel.setId(aExamen.getExamenId());
        myExamModel.setCourseId(aExamen.getModulo().getCurso().getCursoId());
        myExamModel.setCourseName(aExamen.getModulo().getCurso().getNombre());
        myExamModel.setModuleId(aExamen.getModulo().getModuloId());
        myExamModel.setNumOfQuestions(aExamen.getNumPreguntas());
        myExamModel.setNumAnswersPerQuestion(aExamen.getNumRespuestasPregunta());
        
        return myExamModel;
    }
    
}
