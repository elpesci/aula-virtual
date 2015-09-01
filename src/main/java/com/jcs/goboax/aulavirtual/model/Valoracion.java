package com.jcs.goboax.aulavirtual.model;

import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Valoracion")
public class Valoracion
    implements Serializable
{

    @EmbeddedId
    private ValoracionPK id;
    private Integer preguntasExamen;
    private Integer preguntasCorrectas;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] examen;
    private int creadoPor;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    public ValoracionPK getId()
    {
        return id;
    }

    public void setId(ValoracionPK id)
    {
        this.id = id;
    }

    public Integer getPreguntasExamen()
    {
        return preguntasExamen;
    }

    public void setPreguntasExamen(Integer preguntasExamen)
    {
        this.preguntasExamen = preguntasExamen;
    }

    public Integer getPreguntasCorrectas()
    {
        return preguntasCorrectas;
    }

    public void setPreguntasCorrectas(Integer preguntasCorrectas)
    {
        this.preguntasCorrectas = preguntasCorrectas;
    }

    public byte[] getExamen()
    {
        return examen;
    }

    public void setExamen(byte[] examen)
    {
        this.examen = examen;
    }

    public int getCreadoPor()
    {
        return creadoPor;
    }

    public void setCreadoPor(int creadoPor)
    {
        this.creadoPor = creadoPor;
    }

    public Date getFechaCreacion()
    {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion)
    {
        this.fechaCreacion = fechaCreacion;
    }
}
