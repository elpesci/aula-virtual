package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ExtensionContenido")
public  class ExtensionContenido implements Serializable {


    @Column(name="extension",table="ExtensionContenido",nullable=false,length=45)
    @Basic
    private String extension;


    @Column(name="creadoPor",table="ExtensionContenido",nullable=false)
    @Basic
    private int creadoPor;


    @Column(name="modificadoPor",table="ExtensionContenido")
    @Basic
    private Integer modificadoPor;


    @Column(name="fechaCreacion",table="ExtensionContenido",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;


    @ManyToOne(optional=false,targetEntity=TipoContenido.class)
    @JoinColumn(name="tipoContenidoId",referencedColumnName="tipoContenidoId",insertable=true,nullable=true,unique=false,updatable=true)
    private TipoContenido tipoContenidoId;


    @Column(name="fechaModificacion",table="ExtensionContenido")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;


    @Column(name="extensionContenidoId",table="ExtensionContenido",nullable=false)
    @Id
    private Integer extensionContenidoId;

    public ExtensionContenido(){

    }


   public String getExtension() {
        return this.extension;
    }


  public void setExtension (String extension) {
        this.extension = extension;
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



   public Date getFechaModificacion() {
        return this.fechaModificacion;
    }


  public void setFechaModificacion (Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }



   public Integer getExtensionContenidoId() {
        return this.extensionContenidoId;
    }


  public void setExtensionContenidoId (Integer extensionContenidoId) {
        this.extensionContenidoId = extensionContenidoId;
    }

}

