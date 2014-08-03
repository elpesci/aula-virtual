package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SesionAlumno")
public class SesionAlumno
        implements Serializable {

    private static final long serialVersionUID = 259871221229198655L;

    @EmbeddedId
    private SesionAlumnoPK id;

    @Column(name = "creadoPor", table = "SesionAlumno", nullable = false)
    @Basic
    private int creadoPor;

    @OneToMany(targetEntity = Evaluacion.class, mappedBy = "sesionAlumno")
    private Collection<Evaluacion> evaluacionCollection;

    @Column(name = "calificacion", table = "SesionAlumno")
    @Basic
    private Long calificacion;

    @Column(name = "modificadoPor", table = "SesionAlumno")
    @Basic
    private Integer modificadoPor;

    @ManyToOne(optional = false, targetEntity = Sesion.class)
    @JoinColumn(name = "Sesion_sesionId", referencedColumnName = "sesionId", insertable = false, nullable = true, unique = false, updatable = false)
    private Sesion sesion;

    @Column(name = "fechaCreacion", table = "SesionAlumno", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;

    @Column(name = "fechaModificacion", table = "SesionAlumno")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;

    @ManyToOne(optional = false, targetEntity = Alumno.class)
    @JoinColumn(name = "Alumno_alumnoId", referencedColumnName = "alumnoId", insertable = false, nullable = true, unique = false, updatable = false)
    private Alumno alumno;

    public SesionAlumno() {

    }

    public int getCreadoPor() {
        return this.creadoPor;
    }

    public void setCreadoPor(int creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Collection<Evaluacion> getEvaluacionCollection() {
        return this.evaluacionCollection;
    }

    public void setEvaluacionCollection(
            Collection<Evaluacion> evaluacionCollection) {
        this.evaluacionCollection = evaluacionCollection;
    }

    public Long getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getModificadoPor() {
        return this.modificadoPor;
    }

    public void setModificadoPor(Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Sesion getSesion() {
        return this.sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Alumno getAlumno() {
        return this.alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

}
