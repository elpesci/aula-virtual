package com.jcs.goboax.aulavirtual.viewmodel;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by acardenas on 8/3/14.
 */
public class Registration
{
    private String name;
    private String lastName;
    private String secondLastName;
    @NotEmpty(message = "{email.empty}")
    private String email;
    private String password;
    private String confirmPassword;
    private String profile;

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

    public String getSecondLastName()
    {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName)
    {
        this.secondLastName = secondLastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getConfirmPassword()
    {
        return confirmPassword;
    }

    public void setConfirmPassword(String comfirmPassword)
    {
        this.confirmPassword = comfirmPassword;
    }

    public String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        this.profile = profile;
    }

}
