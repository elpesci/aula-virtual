package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.ExamenDao;

import com.jcs.goboax.aulavirtual.model.Examen;

import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.service.api.ExamenService;
import com.jcs.goboax.aulavirtual.viewmodel.ExamModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class ExamenServiceImpl 
    implements ExamenService
{    
    @Autowired
    private ExamenDao examenDao;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public List<Examen> readExams() {
        
        List<Examen> exams = examenDao.findWithNamedQuery(Examen.EXAMEN_ALL_QUERYNAME);
        
        return exams;
    }

    @Transactional
    @Override
    public void createExam(ExamModel anExamModel) {
        
        Examen myExamen = conversionService.convert(anExamModel, Examen.class);
        myExamen.setFechaCreacion(new Date());
        myExamen.setCreadoPor(authenticationService.getUsuario().getUsuarioId());
        
        examenDao.persist(myExamen);
    }
    
}