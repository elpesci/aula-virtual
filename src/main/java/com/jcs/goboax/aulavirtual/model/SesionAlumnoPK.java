package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the SesionAlumno database table.
 * 
 */
@Embeddable
public class SesionAlumnoPK
        implements Serializable
{
    // default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "Sesion_sesionId", insertable = false, updatable = false)
    private int sesion_sesionId;

    @Column(name = "Alumno_alumnoId", insertable = false, updatable = false)
    private int alumno_alumnoId;

    public SesionAlumnoPK()
    {
    }

    public int getSesion_sesionId()
    {
        return this.sesion_sesionId;
    }

    public void setSesion_sesionId(int sesion_sesionId)
    {
        this.sesion_sesionId = sesion_sesionId;
    }

    public int getAlumno_alumnoId()
    {
        return this.alumno_alumnoId;
    }

    public void setAlumno_alumnoId(int alumno_alumnoId)
    {
        this.alumno_alumnoId = alumno_alumnoId;
    }

    public boolean equals(Object other)
    {
        if (this == other)
        {
            return true;
        }
        if (!(other instanceof SesionAlumnoPK))
        {
            return false;
        }
        SesionAlumnoPK castOther = (SesionAlumnoPK) other;
        return (this.sesion_sesionId == castOther.sesion_sesionId)
                && (this.alumno_alumnoId == castOther.alumno_alumnoId);
    }

    public int hashCode()
    {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.sesion_sesionId;
        hash = hash * prime + this.alumno_alumnoId;

        return hash;
    }
}