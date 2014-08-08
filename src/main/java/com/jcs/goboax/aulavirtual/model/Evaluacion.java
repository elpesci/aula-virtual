package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the Evaluacion database table.
 * 
 */
@Entity
@NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e")
@Table(name="Evaluacion")
public class Evaluacion
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name="respuestaId", column=@Column(name="respuestaId", insertable = false, updatable = false)),
        @AttributeOverride(name="alumnoId", column=@Column(name="alumnoId", insertable = false, updatable = false)),
        @AttributeOverride(name="respuestaId", column=@Column(name="respuestaId", insertable = false, updatable = false))
    })
    private EvaluacionPK id;

    private int creadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;

    // bi-directional many-to-one association to Respuesta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "respuestaId")
    private Respuesta respuesta;

    // bi-directional many-to-one association to SesionAlumno
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "alumnoId", referencedColumnName = "Alumno_alumnoId"),
            @JoinColumn(name = "sesionId", referencedColumnName = "Sesion_sesionId") })
    private SesionAlumno sesionAlumno;

    public Evaluacion()
    {
    }

    public EvaluacionPK getId()
    {
        return this.id;
    }

    public void setId(EvaluacionPK id)
    {
        this.id = id;
    }

    public int getCreadoPor()
    {
        return this.creadoPor;
    }

    public void setCreadoPor(int creadoPor)
    {
        this.creadoPor = creadoPor;
    }

    public Date getFechaCreacion()
    {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion)
    {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion()
    {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion)
    {
        this.fechaModificacion = fechaModificacion;
    }

    public int getModificadoPor()
    {
        return this.modificadoPor;
    }

    public void setModificadoPor(int modificadoPor)
    {
        this.modificadoPor = modificadoPor;
    }

    public Respuesta getRespuesta()
    {
        return this.respuesta;
    }

    public void setRespuesta(Respuesta respuesta)
    {
        this.respuesta = respuesta;
    }

    public SesionAlumno getSesionAlumno()
    {
        return this.sesionAlumno;
    }

    public void setSesionAlumno(SesionAlumno sesionAlumno)
    {
        this.sesionAlumno = sesionAlumno;
    }

}