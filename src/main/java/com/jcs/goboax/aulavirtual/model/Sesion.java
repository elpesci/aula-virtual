package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the Sesion database table.
 * 
 */
@Entity
@NamedQuery(name = "Sesion.findAll", query = "SELECT s FROM Sesion s")
@Table(name="Sesion")
public class Sesion
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sesionId;

    private int creadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;

    private byte temporal;

    private String ubicacion;

    // bi-directional many-to-one association to Curso
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cursoId")
    private Curso curso;

    // bi-directional many-to-one association to Instructor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    // bi-directional many-to-one association to SesionAlumno
    @OneToMany(mappedBy = "sesion")
    private List<SesionAlumno> sesionAlumnos;

    public Sesion()
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

    public Date getFechaFin()
    {
        return this.fechaFin;
    }

    public void setFechaFin(Date fechaFin)
    {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio()
    {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio)
    {
        this.fechaInicio = fechaInicio;
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

    public byte getTemporal()
    {
        return this.temporal;
    }

    public void setTemporal(byte temporal)
    {
        this.temporal = temporal;
    }

    public String getUbicacion()
    {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion)
    {
        this.ubicacion = ubicacion;
    }

    public Curso getCurso()
    {
        return this.curso;
    }

    public void setCurso(Curso curso)
    {
        this.curso = curso;
    }

    public Instructor getInstructor()
    {
        return this.instructor;
    }

    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }

    public List<SesionAlumno> getSesionAlumnos()
    {
        return this.sesionAlumnos;
    }

    public void setSesionAlumnos(List<SesionAlumno> sesionAlumnos)
    {
        this.sesionAlumnos = sesionAlumnos;
    }

    public SesionAlumno addSesionAlumno(SesionAlumno sesionAlumno)
    {
        getSesionAlumnos().add(sesionAlumno);
        sesionAlumno.setSesion(this);

        return sesionAlumno;
    }

    public SesionAlumno removeSesionAlumno(SesionAlumno sesionAlumno)
    {
        getSesionAlumnos().remove(sesionAlumno);
        sesionAlumno.setSesion(null);

        return sesionAlumno;
    }

}