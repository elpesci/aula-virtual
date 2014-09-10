package com.jcs.goboax.aulavirtual.viewmodel;


public class ModuleModelForm
{
    private int id;
    private String name;
    private String generalGoal;
    private String specificGoal;
    private String sylabus;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
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
}
