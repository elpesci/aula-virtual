package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Examen;
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
    
}
