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
        myExamModel.setModuleName(aExamen.getModulo().getNombre());
        myExamModel.setNumOfQuestions(aExamen.getNumPreguntas());
        myExamModel.setNumAnswersPerQuestion(aExamen.getNumRespuestasPregunta());
        
        StringBuilder sb = new StringBuilder();
        sb.append("Preguntas en el examen: ")
                .append(myExamModel.getNumOfQuestions())
                .append(" - Opciones de respuesta: ")
                .append(myExamModel.getNumAnswersPerQuestion());
        
        myExamModel.setSettings(sb.toString());
        
        return myExamModel;
    }
    
}
