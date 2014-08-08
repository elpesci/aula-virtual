package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the Evaluacion database table.
 * 
 */
@Embeddable
public class EvaluacionPK
        implements Serializable
{
    // default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(insertable = false, updatable = false)
    private int sesionId;

    @Column(insertable = false, updatable = false)
    private int alumnoId;

    @Column(insertable = false, updatable = false)
    private int respuestaId;

    public EvaluacionPK()
    {
    }

    public int getSesionId()
    {
        return this.sesionId;
    }

    public void setSesionId(int sesionId)
    {
        this.sesionId = sesionId;
    }

    public int getAlumnoId()
    {
        return this.alumnoId;
    }

    public void setAlumnoId(int alumnoId)
    {
        this.alumnoId = alumnoId;
    }

    public int getRespuestaId()
    {
        return this.respuestaId;
    }

    public void setRespuestaId(int respuestaId)
    {
        this.respuestaId = respuestaId;
    }

    public boolean equals(Object other)
    {
        if (this == other)
        {
            return true;
        }
        if (!(other instanceof EvaluacionPK))
        {
            return false;
        }
        EvaluacionPK castOther = (EvaluacionPK) other;
        return (this.sesionId == castOther.sesionId)
                && (this.alumnoId == castOther.alumnoId)
                && (this.respuestaId == castOther.respuestaId);
    }

    public int hashCode()
    {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.sesionId;
        hash = hash * prime + this.alumnoId;
        hash = hash * prime + this.respuestaId;

        return hash;
    }
}