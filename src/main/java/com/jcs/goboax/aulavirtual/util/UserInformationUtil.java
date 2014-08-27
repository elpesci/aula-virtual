package com.jcs.goboax.aulavirtual.util;

import java.io.Serializable;

public class UserInformationUtil
    implements Serializable
{
    private String username;
    private String name;
    private String lastName;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}
