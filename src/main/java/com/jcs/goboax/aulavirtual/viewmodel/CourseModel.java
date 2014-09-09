package com.jcs.goboax.aulavirtual.viewmodel;

public class CourseModel
{
    private Integer id;
    private String name;
    private String goal;
    private String addressedTo;
    private boolean active = true;

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean isActive)
    {
        this.active = isActive;
    }

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

    public String getGoal()
    {
        return goal;
    }

    public void setGoal(String goal)
    {
        this.goal = goal;
    }

    public String getAddressedTo()
    {
        return addressedTo;
    }

    public void setAddressedTo(String addressedTo)
    {
        this.addressedTo = addressedTo;
    }
}
