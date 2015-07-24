package com.jcs.goboax.aulavirtual.viewmodel;

public class ExamModel {
    private Integer id;
    private Integer courseId;
    private Integer moduleId;
    private String courseName;
    private short numOfQuestions;
    private short numAnswersPerQuestion;

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
    public short getNumOfQuestions() {
        return numOfQuestions;
    }

    /**
     * @param numOfQuestions the numOfQuestions to set
     */
    public void setNumOfQuestions(short numOfQuestions) {
        this.numOfQuestions = numOfQuestions;
    }

    /**
     * @return the numAnswersPerQuestion
     */
    public short getNumAnswersPerQuestion() {
        return numAnswersPerQuestion;
    }

    /**
     * @param numAnswersPerQuestion the numAnswersPerQuestion to set
     */
    public void setNumAnswersPerQuestion(short numAnswersPerQuestion) {
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
