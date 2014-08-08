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
 * The persistent class for the Instructor database table.
 * 
 */
@Entity
@NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")
@Table(name="Instructor")
public class Instructor
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instructorId;

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

    // bi-directional many-to-one association to Sesion
    @OneToMany(mappedBy = "instructor")
    private List<Sesion> sesions;

    public Instructor()
    {
    }

    public int getInstructorId()
    {
        return this.instructorId;
    }

    public void setInstructorId(int instructorId)
    {
        this.instructorId = instructorId;
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

    public List<Sesion> getSesions()
    {
        return this.sesions;
    }

    public void setSesions(List<Sesion> sesions)
    {
        this.sesions = sesions;
    }

    public Sesion addSesion(Sesion sesion)
    {
        getSesions().add(sesion);
        sesion.setInstructor(this);

        return sesion;
    }

    public Sesion removeSesion(Sesion sesion)
    {
        getSesions().remove(sesion);
        sesion.setInstructor(null);

        return sesion;
    }

}