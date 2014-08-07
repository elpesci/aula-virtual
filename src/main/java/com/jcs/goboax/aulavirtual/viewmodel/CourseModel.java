package com.jcs.goboax.aulavirtual.viewmodel;

/**
 * Created by acardenas on 8/6/14.
 */
public class CourseModel
{
    private String name;
    private String goal;
    private String addressedTo;

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
