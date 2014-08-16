package com.jcs.goboax.aulavirtual.viewmodel;


import com.jcs.goboax.aulavirtual.validator.annotation.FieldMatch;
import com.jcs.goboax.aulavirtual.validator.annotation.UniqueEmail;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@FieldMatch(first = "password", second = "confirmPassword")
public class Registration
{
    private String name;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String secondLastName;
    @NotEmpty
    @Email
    @UniqueEmail
    private String email;
    @NotEmpty
    @Length(min = 8, max = 30)
    private String password;
    @NotEmpty
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
