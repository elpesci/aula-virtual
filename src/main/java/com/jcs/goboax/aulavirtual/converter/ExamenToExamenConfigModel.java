package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.viewmodel.ExamenConfigModel;
import org.springframework.core.convert.converter.Converter;

public class ExamenToExamenConfigModel
    implements Converter<Examen, ExamenConfigModel> {

    @Override
    public ExamenConfigModel convert(Examen anExam) {
        ExamenConfigModel myExamenConfigModel = new ExamenConfigModel();
        
        myExamenConfigModel.setExamenId(anExam.getExamenId());
        myExamenConfigModel.setModuloId(anExam.getModulo().getModuloId());
        myExamenConfigModel.setModulo(anExam.getModulo());
        myExamenConfigModel.setNumPreguntas(anExam.getNumPreguntas());
        myExamenConfigModel.setNumRespuestasPregunta(anExam.getNumRespuestasPregunta());
        
        return myExamenConfigModel;
    }
    
}
