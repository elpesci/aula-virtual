package com.jcs.goboax.aulavirtual.viewmodel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ExamModel
{
    private Integer id;

    @NotNull
    private Integer courseId;

    @NotNull
    private Integer moduleId;

    private String courseName;
    
    private String moduleName;
    
    private String settings;

    @Min(1)
    @NotNull
    private int numOfQuestions;

    @NotNull
    @Min(1)
    private int numAnswersPerQuestion;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getCourseId()
    {
        return courseId;
    }

    public void setCourseId(Integer courseId)
    {
        this.courseId = courseId;
    }

    public Integer getModuleId()
    {
        return moduleId;
    }

    public void setModuleId(Integer moduleId)
    {
        this.moduleId = moduleId;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public int getNumOfQuestions()
    {
        return numOfQuestions;
    }

    public void setNumOfQuestions(int numOfQuestions)
    {
        this.numOfQuestions = numOfQuestions;
    }

    public int getNumAnswersPerQuestion()
    {
        return numAnswersPerQuestion;
    }

    public void setNumAnswersPerQuestion(int numAnswersPerQuestion)
    {
        this.numAnswersPerQuestion = numAnswersPerQuestion;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }


}
