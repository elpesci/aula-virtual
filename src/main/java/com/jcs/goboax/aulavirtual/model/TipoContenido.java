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
@Table(name="TipoContenido")
public  class TipoContenido implements Serializable {


    @Column(name="creadoPor",table="TipoContenido",nullable=false)
    @Basic
    private int creadoPor;


    @Column(name="modificadoPor",table="TipoContenido")
    @Basic
    private Integer modificadoPor;


    @Column(name="descripcion",table="TipoContenido",nullable=false,length=45)
    @Basic
    private String descripcion;


    @Column(name="fechaCreacion",table="TipoContenido",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;


    @Column(name="fechaModificacion",table="TipoContenido")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;


    @Column(name="tipoContenidoId",table="TipoContenido",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer tipoContenidoId;


    @OneToMany(targetEntity=ExtensionContenido.class,mappedBy="tipoContenidoId")
    private Collection<ExtensionContenido> extensionContenidoCollection;


    @OneToMany(targetEntity=Contenido.class,mappedBy="tipoContenidoId")
    private Collection<Contenido> contenidoCollection;

    public TipoContenido(){

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



   public String getDescripcion() {
        return this.descripcion;
    }


  public void setDescripcion (String descripcion) {
        this.descripcion = descripcion;
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



   public Integer getTipoContenidoId() {
        return this.tipoContenidoId;
    }


  public void setTipoContenidoId (Integer tipoContenidoId) {
        this.tipoContenidoId = tipoContenidoId;
    }



   public Collection<ExtensionContenido> getExtensionContenidoCollection() {
        return this.extensionContenidoCollection;
    }


  public void setExtensionContenidoCollection (Collection<ExtensionContenido> extensionContenidoCollection) {
        this.extensionContenidoCollection = extensionContenidoCollection;
    }



   public Collection<Contenido> getContenidoCollection() {
        return this.contenidoCollection;
    }


  public void setContenidoCollection (Collection<Contenido> contenidoCollection) {
        this.contenidoCollection = contenidoCollection;
    }

}

