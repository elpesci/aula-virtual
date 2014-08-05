package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Evaluacion")
public class Evaluacion
        implements Serializable {

    private static final long serialVersionUID = 1746469417732513735L;

    @EmbeddedId
    private EvaluacionPK id;

    @Column(name = "creadoPor", table = "Evaluacion", nullable = false)
    @Basic
    private int creadoPor;

    @Column(name = "modificadoPor", table = "Evaluacion")
    @Basic
    private Integer modificadoPor;

    @Column(name = "fechaCreacion", table = "Evaluacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;

    @Column(name = "fechaModificacion", table = "Evaluacion")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;

    @ManyToOne(optional = false, targetEntity = Respuesta.class)
    @JoinColumn(name = "respuestaId", referencedColumnName = "respuestaId", insertable = false, nullable = true, unique = false, updatable = false)
    private Respuesta respuesta;

    @ManyToOne(optional = false, targetEntity = SesionAlumno.class)
    @JoinColumns({
            @JoinColumn(name = "sesionId", referencedColumnName = "Sesion_sesionId", insertable = false, nullable = true, unique = false, updatable = false),
            @JoinColumn(name = "alumnoId", referencedColumnName = "Alumno_alumnoId", insertable = false, nullable = true, unique = false, updatable = false) })
    private SesionAlumno sesionAlumno;

    public Evaluacion() {

    }

    public int getCreadoPor() {
        return this.creadoPor;
    }

    public void setCreadoPor(int creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Integer getModificadoPor() {
        return this.modificadoPor;
    }

    public void setModificadoPor(Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
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

    public Respuesta getRespuesta() {
        return this.respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public SesionAlumno getSesionAlumno() {
        return this.sesionAlumno;
    }

    public void setSesionAlumno(SesionAlumno sesionAlumno) {
        this.sesionAlumno = sesionAlumno;
    }

}
