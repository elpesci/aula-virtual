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
@Table(name="Perfil")
public  class Perfil implements Serializable {


    @Column(name="nombre",table="Perfil",nullable=false,length=45)
    @Basic
    private String nombre;


    @OneToMany(targetEntity=UsuarioPerfil.class,mappedBy="perfil")
    private Collection<UsuarioPerfil> usuarioPerfilCollection;


    @Column(name="creadoPor",table="Perfil",nullable=false)
    @Basic
    private int creadoPor;


    @Column(name="perfilId",table="Perfil",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer perfilId;


    @Column(name="modificadoPor",table="Perfil")
    @Basic
    private Integer modificadoPor;


    @Column(name="fechaCreacion",table="Perfil",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;


    @Column(name="fechaModificacion",table="Perfil")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;

    public Perfil(){

    }


   public String getNombre() {
        return this.nombre;
    }


  public void setNombre (String nombre) {
        this.nombre = nombre;
    }



   public Collection<UsuarioPerfil> getUsuarioPerfilCollection() {
        return this.usuarioPerfilCollection;
    }


  public void setUsuarioPerfilCollection (Collection<UsuarioPerfil> usuarioPerfilCollection) {
        this.usuarioPerfilCollection = usuarioPerfilCollection;
    }



   public int getCreadoPor() {
        return this.creadoPor;
    }


  public void setCreadoPor (int creadoPor) {
        this.creadoPor = creadoPor;
    }



   public Integer getPerfilId() {
        return this.perfilId;
    }


  public void setPerfilId (Integer perfilId) {
        this.perfilId = perfilId;
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

}

