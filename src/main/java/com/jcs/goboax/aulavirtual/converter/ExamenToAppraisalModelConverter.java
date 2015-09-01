package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.viewmodel.AppraisalModel;

import org.springframework.core.convert.converter.Converter;

public class ExamenToAppraisalModelConverter
    implements Converter<Examen, AppraisalModel>
{
    
    @Override
    public AppraisalModel convert(Examen anExam) {
        AppraisalModel myAppraisalModel = new AppraisalModel();
        
        myAppraisalModel.setExamenId(anExam.getExamenId());
        myAppraisalModel.setModuloId(anExam.getModulo().getModuloId());
        myAppraisalModel.setNumPreguntas(anExam.getNumPreguntas());
        myAppraisalModel.setNumRespuestasPregunta(anExam.getNumRespuestasPregunta());
        
        myAppraisalModel.setPreguntas(anExam.getPreguntas());
        
        myAppraisalModel.setCourseName(anExam.getModulo().getCurso().getNombre());
        myAppraisalModel.setModuleName(anExam.getModulo().getNombre());
        
        return myAppraisalModel;
    }
    
}
