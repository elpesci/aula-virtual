package com.jcs.goboax.aulavirtual.viewmodel;

import com.jcs.goboax.aulavirtual.model.Usuario;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class ResetPasswordForm
{
    private Usuario usuario;

    @Length(min = 8, max = 20)
    @NotEmpty
    private String newPassword;

    @NotEmpty
    private String confirmNewPassword;

    private boolean sendConfirmationEmail;

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public String getNewPassword()
    {
        return newPassword;
    }

    public void setNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword()
    {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword)
    {
        this.confirmNewPassword = confirmNewPassword;
    }

    public boolean isSendConfirmationEmail()
    {
        return sendConfirmationEmail;
    }

    public void setSendConfirmationEmail(boolean sendConfirmationEmail)
    {
        this.sendConfirmationEmail = sendConfirmationEmail;
    }
}
