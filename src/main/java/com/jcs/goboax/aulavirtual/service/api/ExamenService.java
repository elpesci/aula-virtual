package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.viewmodel.ExamModel;
     

import java.util.List;

public interface ExamenService {
    
    /**
     * Retrieve all available Exams
     * @return 
     */
    List<ExamModel> readExams();
    
}
