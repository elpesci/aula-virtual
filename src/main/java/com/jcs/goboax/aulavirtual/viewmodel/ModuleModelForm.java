package com.jcs.goboax.aulavirtual.viewmodel;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class ModuleModelForm
{
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String generalGoal;
    @NotEmpty
    private String specificGoal;
    @NotEmpty
    private String sylabus;
    @NotEmpty
    private String tasks;
    @NotNull
    private Integer courseId;

    private Boolean active = true;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGeneralGoal()
    {
        return generalGoal;
    }

    public void setGeneralGoal(String generalGoal)
    {
        this.generalGoal = generalGoal;
    }

    public String getSpecificGoal()
    {
        return specificGoal;
    }

    public void setSpecificGoal(String specificGoal)
    {
        this.specificGoal = specificGoal;
    }

    public String getSylabus()
    {
        return sylabus;
    }

    public void setSylabus(String sylabus)
    {
        this.sylabus = sylabus;
    }

    public Integer getCourseId()
    {
        return courseId;
    }

    public void setCourseId(Integer courseId)
    {
        this.courseId = courseId;
    }

    public Boolean getActive()
    {
        return active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }
}
