package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the SesionAlumno database table.
 * 
 */
@Entity
@NamedQuery(name = "SesionAlumno.findAll", query = "SELECT s FROM SesionAlumno s")
@Table(name="SesionAlumno")
public class SesionAlumno
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SesionAlumnoPK id;

    private BigDecimal calificacion;

    private int creadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;

    // bi-directional many-to-one association to Evaluacion
    @OneToMany(mappedBy = "sesionAlumno")
    private List<Evaluacion> evaluacions;

    // bi-directional many-to-one association to Alumno
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Alumno_alumnoId")
    private Alumno alumno;

    // bi-directional many-to-one association to Sesion
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Sesion_sesionId")
    private Sesion sesion;

    public SesionAlumno()
    {
    }

    public SesionAlumnoPK getId()
    {
        return this.id;
    }

    public void setId(SesionAlumnoPK id)
    {
        this.id = id;
    }

    public BigDecimal getCalificacion()
    {
        return this.calificacion;
    }

    public void setCalificacion(BigDecimal calificacion)
    {
        this.calificacion = calificacion;
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

    public List<Evaluacion> getEvaluacions()
    {
        return this.evaluacions;
    }

    public void setEvaluacions(List<Evaluacion> evaluacions)
    {
        this.evaluacions = evaluacions;
    }

    public Evaluacion addEvaluacion(Evaluacion evaluacion)
    {
        getEvaluacions().add(evaluacion);
        evaluacion.setSesionAlumno(this);

        return evaluacion;
    }

    public Evaluacion removeEvaluacion(Evaluacion evaluacion)
    {
        getEvaluacions().remove(evaluacion);
        evaluacion.setSesionAlumno(null);

        return evaluacion;
    }

    public Alumno getAlumno()
    {
        return this.alumno;
    }

    public void setAlumno(Alumno alumno)
    {
        this.alumno = alumno;
    }

    public Sesion getSesion()
    {
        return this.sesion;
    }

    public void setSesion(Sesion sesion)
    {
        this.sesion = sesion;
    }

}