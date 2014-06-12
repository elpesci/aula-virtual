package com.jcs.goboax.aulavirtual.model;


import java.io.Serializable;

import java.lang.Integer;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Alumno")
public  class Alumno implements Serializable {


    @ManyToOne(optional=false,targetEntity=Persona.class)
    @JoinColumn(name="personaId",referencedColumnName="personaId",insertable=true,nullable=true,unique=false,updatable=true)
    private Persona personaId;


    @Column(name="creadoPor",table="Alumno",nullable=false)
    @Basic
    private int creadoPor;


    @Column(name="modificadoPor",table="Alumno")
    @Basic
    private Integer modificadoPor;


    @Column(name="alumnoId",table="Alumno",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer alumnoId;


    @Column(name="fechaCreacion",table="Alumno",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;


    @Column(name="fechaModificacion",table="Alumno")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;


    @OneToMany(targetEntity=SesionAlumno.class,mappedBy="alumno")
    private Collection<SesionAlumno> sesionAlumnoCollection;

    public Alumno(){

    }


   public Persona getPersonaId() {
        return this.personaId;
    }


  public void setPersonaId (Persona personaId) {
        this.personaId = personaId;
    }



   public int getCreadoPor() {
        return this.creadoPor;
    }


  public void setCreadoPor (int creadoPor) {
        this.creadoPor = creadoPor;
    }



   public Integer getModificadoPor() {
        return this.modificadoPor;
    }


  public void setModificadoPor (Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }



   public Integer getAlumnoId() {
        return this.alumnoId;
    }


  public void setAlumnoId (Integer alumnoId) {
        this.alumnoId = alumnoId;
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



   public Collection<SesionAlumno> getSesionAlumnoCollection() {
        return this.sesionAlumnoCollection;
    }


  public void setSesionAlumnoCollection (Collection<SesionAlumno> sesionAlumnoCollection) {
        this.sesionAlumnoCollection = sesionAlumnoCollection;
    }

}

