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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Sesion")
public  class Sesion implements Serializable {


    @ManyToOne(targetEntity=Instructor.class)
    @JoinColumn(name="instructorId",referencedColumnName="instructorId",insertable=true,nullable=true,unique=false,updatable=true)
    private Instructor instructorId;


    @Column(name="creadoPor",table="Sesion",nullable=false)
    @Basic
    private int creadoPor;


    @Column(name="sesionId",table="Sesion",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer sesionId;


    @Column(name="modificadoPor",table="Sesion")
    @Basic
    private Integer modificadoPor;


    @Column(name="temporal",table="Sesion",nullable=false)
    @Basic
    private boolean temporal;


    @Column(name="fechaFin",table="Sesion")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaFin;


    @ManyToOne(optional=false,targetEntity=Curso.class)
    @JoinColumn(name="cursoId",referencedColumnName="cursoId",insertable=true,nullable=true,unique=false,updatable=true)
    private Curso cursoId;


    @Column(name="fechaCreacion",table="Sesion",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;


    @Column(name="fechaModificacion",table="Sesion")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;


    @Column(name="ubicacion",table="Sesion",length=150)
    @Basic
    private String ubicacion;


    @Column(name="fechaInicio",table="Sesion")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaInicio;


    @OneToMany(targetEntity=SesionAlumno.class,mappedBy="sesion")
    private Collection<SesionAlumno> sesionAlumnoCollection;

    public Sesion(){

    }


   public Instructor getInstructorId() {
        return this.instructorId;
    }


  public void setInstructorId (Instructor instructorId) {
        this.instructorId = instructorId;
    }



   public int getCreadoPor() {
        return this.creadoPor;
    }


  public void setCreadoPor (int creadoPor) {
        this.creadoPor = creadoPor;
    }



   public Integer getSesionId() {
        return this.sesionId;
    }


  public void setSesionId (Integer sesionId) {
        this.sesionId = sesionId;
    }



   public Integer getModificadoPor() {
        return this.modificadoPor;
    }


  public void setModificadoPor (Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }



    public boolean isTemporal() {
        return this.temporal;
    }


  public void setTemporal (boolean temporal) {
        this.temporal = temporal;
    }



   public Date getFechaFin() {
        return this.fechaFin;
    }


  public void setFechaFin (Date fechaFin) {
        this.fechaFin = fechaFin;
    }



   public Curso getCursoId() {
        return this.cursoId;
    }


  public void setCursoId (Curso cursoId) {
        this.cursoId = cursoId;
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



   public String getUbicacion() {
        return this.ubicacion;
    }


  public void setUbicacion (String ubicacion) {
        this.ubicacion = ubicacion;
    }



   public Date getFechaInicio() {
        return this.fechaInicio;
    }


  public void setFechaInicio (Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }



   public Collection<SesionAlumno> getSesionAlumnoCollection() {
        return this.sesionAlumnoCollection;
    }


  public void setSesionAlumnoCollection (Collection<SesionAlumno> sesionAlumnoCollection) {
        this.sesionAlumnoCollection = sesionAlumnoCollection;
    }

}

