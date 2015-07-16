package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.ExamenDao;

import com.jcs.goboax.aulavirtual.model.Examen;

import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.service.api.ExamenService;

import com.jcs.goboax.aulavirtual.viewmodel.ExamModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public List<ExamModel> readExams() {
        
        List<ExamModel> results = new ArrayList<ExamModel>();
        
        List<Examen> exams = examenDao.findWithNamedQuery(Examen.EXAMEN_ALL_QUERYNAME);
        
        for(Examen exam : exams) {
            ExamModel model = new ExamModel();
            model.setId(exam.getExamenId());
            model.setCourseName(exam.getCurso().getNombre());
            model.setNumOfQuestions(exam.getNumPreguntas());
            model.setNumAnswersPerQuestion(exam.getNumRespuestasPregunta());
            
            results.add(model);
        }
        
        return results;
    }
    
}
