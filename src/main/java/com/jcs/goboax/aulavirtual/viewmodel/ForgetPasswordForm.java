package com.jcs.goboax.aulavirtual.viewmodel;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class ForgetPasswordForm
{

    @NotEmpty(message = "{NotNull.message}")
//    @Length(max = 30)
//    @Email
    private String email;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}