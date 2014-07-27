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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="RegistroAcceso")
public  class RegistroAcceso implements Serializable {


    @Column(name="registroAccesoId",table="RegistroAcceso",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer registroAccesoId;


    @Column(name="sessionId",table="RegistroAcceso",length=45)
    @Basic
    private String sessionId;


    @Column(name="finAcceso",table="RegistroAcceso")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date finAcceso;


    @Column(name="inicioAcceso",table="RegistroAcceso")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date inicioAcceso;


    @ManyToOne(optional=false,targetEntity=Usuario.class)
    @JoinColumn(name="usuarioId",referencedColumnName="usuarioId",insertable=true,nullable=true,unique=false,updatable=true)
    private Usuario usuarioId;

    public RegistroAcceso(){

    }


   public Integer getRegistroAccesoId() {
        return this.registroAccesoId;
    }


  public void setRegistroAccesoId (Integer registroAccesoId) {
        this.registroAccesoId = registroAccesoId;
    }



   public String getSessionId() {
        return this.sessionId;
    }


  public void setSessionId (String sessionId) {
        this.sessionId = sessionId;
    }



   public Date getFinAcceso() {
        return this.finAcceso;
    }


  public void setFinAcceso (Date finAcceso) {
        this.finAcceso = finAcceso;
    }



   public Date getInicioAcceso() {
        return this.inicioAcceso;
    }


  public void setInicioAcceso (Date inicioAcceso) {
        this.inicioAcceso = inicioAcceso;
    }



   public Usuario getUsuarioId() {
        return this.usuarioId;
    }


  public void setUsuarioId (Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

}

