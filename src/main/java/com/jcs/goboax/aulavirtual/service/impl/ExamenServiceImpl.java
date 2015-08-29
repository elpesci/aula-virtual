package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.ExamenDao;
import com.jcs.goboax.aulavirtual.dao.api.ModuloDao;

import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.model.Pregunta;
import com.jcs.goboax.aulavirtual.model.Respuesta;

import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.service.api.ExamenService;
import com.jcs.goboax.aulavirtual.viewmodel.ExamModel;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;
import org.apache.commons.collections.ListUtils;

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

    @Transactional(readOnly = true)
    @Override
    public Examen readExamByModule(Modulo aModule) 
    {
        Examen myExam = examenDao.readByModule(aModule);
        
        return myExam;
    }

    @Transactional(readOnly = true)
    @Override
    public Examen getExamForAppraisalByModule(Modulo aModule) 
    {
        Examen myAppraisalExam = new Examen();
        Examen masterExam = examenDao.readByModule(aModule);
        
        myAppraisalExam.setExamenId(masterExam.getExamenId());
        myAppraisalExam.setModulo(masterExam.getModulo());
        myAppraisalExam.setNumPreguntas(masterExam.getNumPreguntas());
        myAppraisalExam.setNumRespuestasPregunta(masterExam.getNumRespuestasPregunta());
        
        List<Pregunta> questionsUniverse = masterExam.getPreguntas();
        
        // Ramdomize all exam questions
        Collections.shuffle(questionsUniverse);
        
        List<Pregunta> questionsSample = questionsUniverse.subList(0, masterExam.getNumPreguntas()-1);
        
        for(Pregunta selectedQuestion : questionsSample)
        {
            // Retrieve right answer and add it to temporal collection
            List<Respuesta> rightAns = new ArrayList<Respuesta>();
            for(Respuesta answer : selectedQuestion.getRespuestas())
            {
                if(answer.getEsRespuestaCorrecta())
                {
                    rightAns.add(answer);
                    break;
                }
            }
            
            // Retrieve all wrong answers and add them to temporal collection
            List<Respuesta> wrongAns = new ArrayList<Respuesta>();
            for(Respuesta answer : selectedQuestion.getRespuestas())
            {
                if(!answer.getEsRespuestaCorrecta())
                {
                    wrongAns.add(answer);
                }
            }
            
            // Ramdomize wrong answers
            Collections.shuffle(wrongAns);
            
            // Joining right answer with subset of wrong answers
            // Wrong answers subset length = Examen.NumOfAnswersPerQuestion - 1,
            // since we already have right answer.
            List<Respuesta> answersSubset;
            answersSubset = ListUtils.union(rightAns, wrongAns.subList(0, masterExam.getNumRespuestasPregunta() - 2));
            
            // Ramdomize answers subset
            Collections.shuffle(answersSubset);
            
            // Set randomized answer options to current question.
            selectedQuestion.setRespuestas(null);
            selectedQuestion.setRespuestas(answersSubset);
        }
        
        // Set randomized questions to Exam
        myAppraisalExam.setPreguntas(null);
        myAppraisalExam.setPreguntas(questionsSample);
        
        return myAppraisalExam;
    }
}
