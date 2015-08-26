package com.jcs.goboax.aulavirtual.viewmodel;

import com.jcs.goboax.aulavirtual.model.Usuario;

public class UsuarioModel
{
    private Integer id;
    private String username;
    private String name;
    private String profile;
    private Usuario.UsuarioStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        this.profile = profile;
    }

    public Usuario.UsuarioStatus getStatus()
    {
        return status;
    }

    public void setStatus(Usuario.UsuarioStatus status)
    {
        this.status = status;
    }
}
