package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.dao.api.ExamenDao;
import com.jcs.goboax.aulavirtual.dao.api.ModuloDao;
import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.viewmodel.ExamenConfigModel;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class ExamenConfigModelToExamen 
    implements Converter<ExamenConfigModel, Examen> 
{

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ExamenDao examenDao;
    
    @Autowired
    private ModuloDao moduloDao;
    
    @Override
    public Examen convert(ExamenConfigModel anExamenConfigModel) {
        
        Examen myExam = new Examen();
        
        if(anExamenConfigModel.getExamenId() != null) {
            myExam = examenDao.findByKey(anExamenConfigModel.getExamenId());
            myExam.setModificadoPor(authenticationService.getUsuario().getUsuarioId());
            myExam.setFechaModificacion(new Date());
        } else {
            myExam.setCreadoPor(authenticationService.getUsuario().getUsuarioId());
            myExam.setFechaCreacion(new Date());
        }
        
        myExam.setModulo(moduloDao.findByKey(anExamenConfigModel.getModuloId()));
        myExam.setNumPreguntas(anExamenConfigModel.getNumPreguntas());
        myExam.setNumRespuestasPregunta(anExamenConfigModel.getNumRespuestasPregunta());
        
        return myExam;
    }
    
}
