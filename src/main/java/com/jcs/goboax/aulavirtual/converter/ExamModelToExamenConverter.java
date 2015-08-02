package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.viewmodel.ExamModel;
import org.springframework.core.convert.converter.Converter;

public class ExamModelToExamenConverter 
    implements Converter<ExamModel, Examen>
{

    @Override
    public Examen convert(ExamModel anExamModel) {
        
        Examen myExam = new Examen();
        
        myExam.setNumPreguntas(anExamModel.getNumOfQuestions());
        myExam.setNumRespuestasPregunta(anExamModel.getNumAnswersPerQuestion());
        
        return myExam;
    }
    
}
