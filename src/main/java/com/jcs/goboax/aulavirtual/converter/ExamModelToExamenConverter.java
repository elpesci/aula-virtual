package com.jcs.goboax.aulavirtual.converter;

import org.springframework.core.convert.converter.Converter;

import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.viewmodel.ExamModel;

public class ExamModelToExamenConverter 
    implements Converter<ExamModel, Examen>
{

    @Override
    public Examen convert(ExamModel anExamModel) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
