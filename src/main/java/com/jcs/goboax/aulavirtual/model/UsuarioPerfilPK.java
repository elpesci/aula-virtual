package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the UsuarioPerfil database table.
 * 
 */
@Embeddable
public class UsuarioPerfilPK
        implements Serializable
{
    // default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(insertable = false, updatable = false)
    private int usuarioId;

    @Column(insertable = false, updatable = false)
    private int perfilId;

    public UsuarioPerfilPK()
    {
    }

    public int getUsuarioId()
    {
        return this.usuarioId;
    }

    public void setUsuarioId(int usuarioId)
    {
        this.usuarioId = usuarioId;
    }

    public int getPerfilId()
    {
        return this.perfilId;
    }

    public void setPerfilId(int perfilId)
    {
        this.perfilId = perfilId;
    }

    public boolean equals(Object other)
    {
        if (this == other)
        {
            return true;
        }
        if (!(other instanceof UsuarioPerfilPK))
        {
            return false;
        }
        UsuarioPerfilPK castOther = (UsuarioPerfilPK) other;
        return (this.usuarioId == castOther.usuarioId)
                && (this.perfilId == castOther.perfilId);
    }

    public int hashCode()
    {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.usuarioId;
        hash = hash * prime + this.perfilId;

        return hash;
    }
}