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
@Table(name="Usuario")
public  class Usuario implements Serializable {


    @OneToMany(targetEntity=UsuarioPerfil.class,mappedBy="usuario")
    private Collection<UsuarioPerfil> usuarioPerfilCollection;


    @OneToMany(targetEntity=RegistroAcceso.class,mappedBy="usuarioId")
    private Collection<RegistroAcceso> registroAccesoCollection;


    @Column(name="username",table="Usuario",nullable=false,length=45)
    @Basic
    private String username;


    @ManyToOne(optional=false,targetEntity=Persona.class)
    @JoinColumn(name="personaId",referencedColumnName="personaId",insertable=true,nullable=true,unique=false,updatable=true)
    private Persona personaId;


    @Column(name="creadoPor",table="Usuario",nullable=false)
    @Basic
    private int creadoPor;


    @Column(name="habilitado",table="Usuario",nullable=false)
    @Basic
    private boolean habilitado;


    @Column(name="modificadoPor",table="Usuario")
    @Basic
    private Integer modificadoPor;


    @Column(name="fechaCreacion",table="Usuario",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;


    @Column(name="fechaModificacion",table="Usuario")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;


    @Column(name="usuarioId",table="Usuario",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer usuarioId;


    @Column(name="password",table="Usuario",nullable=false,length=25)
    @Basic
    private String password;

    public Usuario(){

    }


   public Collection<UsuarioPerfil> getUsuarioPerfilCollection() {
        return this.usuarioPerfilCollection;
    }


  public void setUsuarioPerfilCollection (Collection<UsuarioPerfil> usuarioPerfilCollection) {
        this.usuarioPerfilCollection = usuarioPerfilCollection;
    }



   public Collection<RegistroAcceso> getRegistroAccesoCollection() {
        return this.registroAccesoCollection;
    }


  public void setRegistroAccesoCollection (Collection<RegistroAcceso> registroAccesoCollection) {
        this.registroAccesoCollection = registroAccesoCollection;
    }



   public String getUsername() {
        return this.username;
    }


  public void setUsername (String username) {
        this.username = username;
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



    public boolean isHabilitado() {
        return this.habilitado;
    }


  public void setHabilitado (boolean habilitado) {
        this.habilitado = habilitado;
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



   public Integer getUsuarioId() {
        return this.usuarioId;
    }


  public void setUsuarioId (Integer usuarioId) {
        this.usuarioId = usuarioId;
    }



   public String getPassword() {
        return this.password;
    }


  public void setPassword (String password) {
        this.password = password;
    }

}

