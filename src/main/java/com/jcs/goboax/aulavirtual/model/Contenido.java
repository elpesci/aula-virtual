package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Contenido")
public  class Contenido implements Serializable {


    @Column(name="nombre",table="Contenido",length=50)
    @Basic
    private String nombre;


    @Column(name="creadoPor",table="Contenido",nullable=false)
    @Basic
    private int creadoPor;


    @Column(name="archivoMaterial",table="Contenido")
    @Lob
    @Basic
    private byte [] archivoMaterial;


    @Column(name="modificadoPor",table="Contenido")
    @Basic
    private Integer modificadoPor;


    @Column(name="contenidoId",table="Contenido",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer contenidoId;


    @Column(name="descripcion",table="Contenido",length=50)
    @Basic
    private String descripcion;


    @ManyToOne(optional=false,targetEntity=Curso.class)
    @JoinColumn(name="cursoId",referencedColumnName="cursoId",insertable=true,nullable=true,unique=false,updatable=true)
    private Curso cursoId;


    @Column(name="fechaCreacion",table="Contenido",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;


    @ManyToOne(optional=false,targetEntity=TipoContenido.class)
    @JoinColumn(name="tipoContenidoId",referencedColumnName="tipoContenidoId",insertable=true,nullable=true,unique=false,updatable=true)
    private TipoContenido tipoContenidoId;


    @Column(name="fechaModificacion",table="Contenido",length=45)
    @Basic
    private String fechaModificacion;

    public Contenido(){

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



   public byte [] getArchivoMaterial() {
        return this.archivoMaterial;
    }


  public void setArchivoMaterial (byte [] archivoMaterial) {
        this.archivoMaterial = archivoMaterial;
    }



   public Integer getModificadoPor() {
        return this.modificadoPor;
    }


  public void setModificadoPor (Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }



   public Integer getContenidoId() {
        return this.contenidoId;
    }


  public void setContenidoId (Integer contenidoId) {
        this.contenidoId = contenidoId;
    }



   public String getDescripcion() {
        return this.descripcion;
    }


  public void setDescripcion (String descripcion) {
        this.descripcion = descripcion;
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



   public TipoContenido getTipoContenidoId() {
        return this.tipoContenidoId;
    }


  public void setTipoContenidoId (TipoContenido tipoContenidoId) {
        this.tipoContenidoId = tipoContenidoId;
    }



   public String getFechaModificacion() {
        return this.fechaModificacion;
    }


  public void setFechaModificacion (String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

}

