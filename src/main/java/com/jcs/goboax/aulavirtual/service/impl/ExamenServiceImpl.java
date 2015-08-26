package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.ExamenDao;
import com.jcs.goboax.aulavirtual.dao.api.ModuloDao;

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
@Transactional
public class ExamenServiceImpl 
    implements ExamenService
{    
    @Autowired
    private ExamenDao examenDao;
    
    @Autowired
    private ModuloDao moduloDao;

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
        
        examenDao.persist(createForInsert(anExamModel));
    }

    @Override
    public Examen updateExam(Examen anExamen)
    {
        return examenDao.update(anExamen);
    }

    @Transactional
    @Override
    public Examen insertExam(ExamModel anExamModel) {
        
        Examen myExamen = createForInsert(anExamModel);
        
        examenDao.persist(myExamen);
        
        return myExamen;
    }
    
    private Examen createForInsert(ExamModel anExamModel) {
        
        Examen myExamen = conversionService.convert(anExamModel, Examen.class);
        myExamen.setModulo(moduloDao.findByKey(anExamModel.getModuleId()));
        myExamen.setFechaCreacion(new Date());
        myExamen.setCreadoPor(authenticationService.getUsuario().getUsuarioId());
        
        return myExamen;
    }

    @Transactional(readOnly = true)
    @Override
    public Examen readExamById(Integer anExamId) {
        
        Examen myExamen = examenDao.findByKey(anExamId);
        
        return myExamen;
    }
}
