package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the Persona database table.
 * 
 */
@Entity
@NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
public class Persona
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private int personaId;

    private String apellidoMaterno;

    private String apellidoPaterno;

    private String correoElectronico;

    private int creadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;

    private String nombre;

    // bi-directional many-to-one association to Alumno
    @OneToMany(mappedBy = "persona")
    private List<Alumno> alumnos;

    // bi-directional many-to-one association to Instructor
    @OneToMany(mappedBy = "persona")
    private List<Instructor> instructors;

    // bi-directional many-to-one association to Usuario
    @OneToMany(mappedBy = "persona")
    private List<Usuario> usuarios;

    public Persona()
    {
    }

    public int getPersonaId()
    {
        return this.personaId;
    }

    public void setPersonaId(int personaId)
    {
        this.personaId = personaId;
    }

    public String getApellidoMaterno()
    {
        return this.apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno)
    {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno()
    {
        return this.apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno)
    {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getCorreoElectronico()
    {
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico)
    {
        this.correoElectronico = correoElectronico;
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

    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public List<Alumno> getAlumnos()
    {
        return this.alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos)
    {
        this.alumnos = alumnos;
    }

    public Alumno addAlumno(Alumno alumno)
    {
        getAlumnos().add(alumno);
        alumno.setPersona(this);

        return alumno;
    }

    public Alumno removeAlumno(Alumno alumno)
    {
        getAlumnos().remove(alumno);
        alumno.setPersona(null);

        return alumno;
    }

    public List<Instructor> getInstructors()
    {
        return this.instructors;
    }

    public void setInstructors(List<Instructor> instructors)
    {
        this.instructors = instructors;
    }

    public Instructor addInstructor(Instructor instructor)
    {
        getInstructors().add(instructor);
        instructor.setPersona(this);

        return instructor;
    }

    public Instructor removeInstructor(Instructor instructor)
    {
        getInstructors().remove(instructor);
        instructor.setPersona(null);

        return instructor;
    }

    public List<Usuario> getUsuarios()
    {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios)
    {
        this.usuarios = usuarios;
    }

    public Usuario addUsuario(Usuario usuario)
    {
        getUsuarios().add(usuario);
        usuario.setPersona(this);

        return usuario;
    }

    public Usuario removeUsuario(Usuario usuario)
    {
        getUsuarios().remove(usuario);
        usuario.setPersona(null);

        return usuario;
    }

}