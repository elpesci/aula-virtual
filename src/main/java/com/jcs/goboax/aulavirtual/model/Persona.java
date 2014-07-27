package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;

import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Persona")
public  class Persona implements Serializable {


    @Column(name="nombre",table="Persona",length=50)
    @Basic
    private String nombre;


    @Column(name="correoElectronico",table="Persona",length=100)
    @Basic
    private String correoElectronico;


    @OneToMany(targetEntity=Usuario.class,mappedBy="personaId")
    private Collection<Usuario> usuarioCollection;


    @Column(name="creadoPor",table="Persona",nullable=false)
    @Basic
    private int creadoPor;


    @Column(name="personaId",table="Persona",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer personaId;


    @Column(name="modificadoPor",table="Persona")
    @Basic
    private Integer modificadoPor;


    @OneToMany(targetEntity=Alumno.class,mappedBy="personaId")
    private Collection<Alumno> alumnoCollection;


    @Column(name="apellidoMaterno",table="Persona",length=50)
    @Basic
    private String apellidoMaterno;


    @Column(name="apellidoPaterno",table="Persona",length=50)
    @Basic
    private String apellidoPaterno;


    @OneToMany(targetEntity=Instructor.class,mappedBy="personaId")
    private Collection<Instructor> instructorCollection;


    @Column(name="fechaCreacion",table="Persona",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;


    @Column(name="fechaModificacion",table="Persona")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;

    public Persona(){

    }


   public String getNombre() {
        return this.nombre;
    }


  public void setNombre (String nombre) {
        this.nombre = nombre;
    }



   public String getCorreoElectronico() {
        return this.correoElectronico;
    }


  public void setCorreoElectronico (String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }



   public Collection<Usuario> getUsuarioCollection() {
        return this.usuarioCollection;
    }


  public void setUsuarioCollection (Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }



   public int getCreadoPor() {
        return this.creadoPor;
    }


  public void setCreadoPor (int creadoPor) {
        this.creadoPor = creadoPor;
    }



   public Integer getPersonaId() {
        return this.personaId;
    }


  public void setPersonaId (Integer personaId) {
        this.personaId = personaId;
    }



   public Integer getModificadoPor() {
        return this.modificadoPor;
    }


  public void setModificadoPor (Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }



   public Collection<Alumno> getAlumnoCollection() {
        return this.alumnoCollection;
    }


  public void setAlumnoCollection (Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
    }



   public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }


  public void setApellidoMaterno (String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }



   public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }


  public void setApellidoPaterno (String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }



   public Collection<Instructor> getInstructorCollection() {
        return this.instructorCollection;
    }


  public void setInstructorCollection (Collection<Instructor> instructorCollection) {
        this.instructorCollection = instructorCollection;
    }



   public Date getFechaCreacion() {
        return this.fechaCreacion;
    }


  public void setFechaCreacion (Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }



   public Date getFechaModificacion() {
        return this.fechaModificacion;
    }


  public void setFechaModificacion (Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

}

