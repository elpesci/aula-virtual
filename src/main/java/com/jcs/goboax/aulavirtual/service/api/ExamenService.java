package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.viewmodel.ExamModel;
     

import java.util.List;

public interface ExamenService {
    
    /**
     * Retrieve all available Exams
     * @return 
     */
    List<Examen> readExams();
    
    /**
     * Save an Exam
     * @param anExamModel 
     */
    void createExam(ExamModel anExamModel);

    /**
     *
     * @param anExamen
     * @return
     */
    Examen updateExam(Examen anExamen);

    /**
     * Save an Exam
     * @param anExamModel
     * @return
     */
    Examen insertExam(ExamModel anExamModel);
    
    
    /**
     * Retrieve an Exam by its Id
     * @param anExamId
     * @return
     */
    Examen readExamById(Integer anExamId);
    
    
    /**
     * Retrieve an Exam by ModuleId
     * @param aModule
     * @return
     */
    Examen readExamByModule(Modulo aModule);
    
    /**
     * Retrieve an Appraisal Exam with the number of questions
     * and number of answers per question according to Exam parameters (Random questions / Random answers)
     * @param aModule
     * @return
     */
    Examen getExamForAppraisalByModule(Modulo aModule);

    void submitAppraisal(Integer myAnswerModel);
}
