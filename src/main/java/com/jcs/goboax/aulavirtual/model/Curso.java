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
@Table(name="Curso")
public  class Curso implements Serializable {


    @Column(name="nombre",table="Curso",nullable=false,length=100)
    @Basic
    private String nombre;


    @Column(name="creadoPor",table="Curso",nullable=false)
    @Basic
    private int creadoPor;


    @Column(name="habilitado",table="Curso",nullable=false)
    @Basic
    private boolean habilitado;


    @Column(name="objetivo",table="Curso",nullable=false,length=500)
    @Basic
    private String objetivo;


    @OneToMany(targetEntity=Examen.class,mappedBy="cursoId")
    private Collection<Examen> examenCollection;


    @Column(name="modificadoPor",table="Curso")
    @Basic
    private Integer modificadoPor;


    @Column(name="audiencia",table="Curso",nullable=false,length=500)
    @Basic
    private String audiencia;


    @Column(name="fechaCreacion",table="Curso",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;


    @Column(name="cursoId",table="Curso",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer cursoId;


    @Column(name="fechaModificacion",table="Curso")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;


    @OneToMany(targetEntity=Sesion.class,mappedBy="cursoId")
    private Collection<Sesion> sesionCollection;


    @OneToMany(targetEntity=Contenido.class,mappedBy="cursoId")
    private Collection<Contenido> contenidoCollection;

    public Curso(){

    }


   public String getNombre() {
        return this.nombre;
    }


  public void setNombre (String nombre) {
        this.nombre = nombre;
    }



   public int getCreadoPor() {
        return this.creadoPor;
    }


  public void setCreadoPor (int creadoPor) {
        this.creadoPor = creadoPor;
    }



    public boolean isHabilitado() {
        return this.habilitado;
    }


  public void setHabilitado (boolean habilitado) {
        this.habilitado = habilitado;
    }



   public String getObjetivo() {
        return this.objetivo;
    }


  public void setObjetivo (String objetivo) {
        this.objetivo = objetivo;
    }



   public Collection<Examen> getExamenCollection() {
        return this.examenCollection;
    }


  public void setExamenCollection (Collection<Examen> examenCollection) {
        this.examenCollection = examenCollection;
    }



   public Integer getModificadoPor() {
        return this.modificadoPor;
    }


  public void setModificadoPor (Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }



   public String getAudiencia() {
        return this.audiencia;
    }


  public void setAudiencia (String audiencia) {
        this.audiencia = audiencia;
    }



   public Date getFechaCreacion() {
        return this.fechaCreacion;
    }


  public void setFechaCreacion (Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }



   public Integer getCursoId() {
        return this.cursoId;
    }


  public void setCursoId (Integer cursoId) {
        this.cursoId = cursoId;
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



   public Collection<Contenido> getContenidoCollection() {
        return this.contenidoCollection;
    }


  public void setContenidoCollection (Collection<Contenido> contenidoCollection) {
        this.contenidoCollection = contenidoCollection;
    }

}

