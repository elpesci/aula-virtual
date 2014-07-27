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
@Table(name="Instructor")
public  class Instructor implements Serializable {


    @ManyToOne(optional=false,targetEntity=Persona.class)
    @JoinColumn(name="personaId",referencedColumnName="personaId",insertable=true,nullable=true,unique=false,updatable=true)
    private Persona personaId;


    @Column(name="creadoPor",table="Instructor",nullable=false)
    @Basic
    private int creadoPor;


    @Column(name="instructorId",table="Instructor",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer instructorId;


    @Column(name="modificadoPor",table="Instructor")
    @Basic
    private Integer modificadoPor;


    @Column(name="fechaCreacion",table="Instructor",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;


    @Column(name="fechaModificacion",table="Instructor")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;


    @OneToMany(targetEntity=Sesion.class,mappedBy="instructorId")
    private Collection<Sesion> sesionCollection;

    public Instructor(){

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



   public Integer getInstructorId() {
        return this.instructorId;
    }


  public void setInstructorId (Integer instructorId) {
        this.instructorId = instructorId;
    }



   public Integer getModificadoPor() {
        return this.modificadoPor;
    }


  public void setModificadoPor (Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
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



   public Collection<Sesion> getSesionCollection() {
        return this.sesionCollection;
    }


  public void setSesionCollection (Collection<Sesion> sesionCollection) {
        this.sesionCollection = sesionCollection;
    }

}

