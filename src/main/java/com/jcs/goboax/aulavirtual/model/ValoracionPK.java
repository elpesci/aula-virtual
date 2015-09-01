package com.jcs.goboax.aulavirtual.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ValoracionPK implements Serializable
{
    private int examenId;
    private int usuarioId;

    public int getExamenId()
    {
        return examenId;
    }

    public void setExamenId(int examenId)
    {
        this.examenId = examenId;
    }

    public int getUsuarioId()
    {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId)
    {
        this.usuarioId = usuarioId;
    }
}
