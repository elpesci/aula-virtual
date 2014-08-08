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
 * The persistent class for the Alumno database table.
 * 
 */
@Entity
@NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
@Table(name="Alumno")
public class Alumno
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alumnoId;

    private int creadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;

    // bi-directional many-to-one association to Persona
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personaId")
    private Persona persona;

    // bi-directional many-to-one association to SesionAlumno
    @OneToMany(mappedBy = "alumno")
    private List<SesionAlumno> sesionAlumnos;

    public Alumno()
    {
    }

    public int getAlumnoId()
    {
        return this.alumnoId;
    }

    public void setAlumnoId(int alumnoId)
    {
        this.alumnoId = alumnoId;
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

    public Persona getPersona()
    {
        return this.persona;
    }

    public void setPersona(Persona persona)
    {
        this.persona = persona;
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
        sesionAlumno.setAlumno(this);

        return sesionAlumno;
    }

    public SesionAlumno removeSesionAlumno(SesionAlumno sesionAlumno)
    {
        getSesionAlumnos().remove(sesionAlumno);
        sesionAlumno.setAlumno(null);

        return sesionAlumno;
    }

}