package com.jcs.goboax.aulavirtual.viewmodel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class ExamModel {
    private Integer id;
    
    @NotNull
    private Integer courseId;
    
    @NotNull
    private Integer moduleId;
    
    private String courseName;
    
    @NotEmpty
    //@Min(1)
    private int numOfQuestions;
    
    @NotEmpty
    //@Min(1)
    private int numAnswersPerQuestion;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the numOfQuestions
     */
    public int getNumOfQuestions() {
        return numOfQuestions;
    }

    /**
     * @param numOfQuestions the numOfQuestions to set
     */
    public void setNumOfQuestions(int numOfQuestions) {
        this.numOfQuestions = numOfQuestions;
    }

    /**
     * @return the numAnswersPerQuestion
     */
    public int getNumAnswersPerQuestion() {
        return numAnswersPerQuestion;
    }

    /**
     * @param numAnswersPerQuestion the numAnswersPerQuestion to set
     */
    public void setNumAnswersPerQuestion(int numAnswersPerQuestion) {
        this.numAnswersPerQuestion = numAnswersPerQuestion;
    }

    /**
     * @return the courseId
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * @return the moduleId
     */
    public Integer getModuleId() {
        return moduleId;
    }

    /**
     * @param moduleId the moduleId to set
     */
    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
    
    
}
