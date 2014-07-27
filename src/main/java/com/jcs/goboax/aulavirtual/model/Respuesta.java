package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;

import java.lang.Boolean;
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
@Table(name="Respuesta")
public  class Respuesta implements Serializable {


    @Column(name="creadoPor",table="Respuesta",nullable=false)
    @Basic
    private int creadoPor;


    @OneToMany(targetEntity=Evaluacion.class,mappedBy="respuesta")
    private Collection<Evaluacion> evaluacionCollection;


    @Column(name="modificadoPor",table="Respuesta")
    @Basic
    private Integer modificadoPor;


    @Column(name="respuestaId",table="Respuesta",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer respuestaId;


    @ManyToOne(optional=false,targetEntity=Pregunta.class)
    @JoinColumn(name="preguntaId",referencedColumnName="preguntaId",insertable=true,nullable=true,unique=false,updatable=true)
    private Pregunta preguntaId;


    @Column(name="fechaCreacion",table="Respuesta",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;


    @Column(name="fechaModificacion",table="Respuesta")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;


    @Column(name="esRespuestaCorrecta",table="Respuesta")
    @Basic
    private Boolean esRespuestaCorrecta;


    @Column(name="textoRespuesta",table="Respuesta",length=500)
    @Basic
    private String textoRespuesta;

    public Respuesta(){

    }


   public int getCreadoPor() {
        return this.creadoPor;
    }


  public void setCreadoPor (int creadoPor) {
        this.creadoPor = creadoPor;
    }



   public Collection<Evaluacion> getEvaluacionCollection() {
        return this.evaluacionCollection;
    }


  public void setEvaluacionCollection (Collection<Evaluacion> evaluacionCollection) {
        this.evaluacionCollection = evaluacionCollection;
    }



   public Integer getModificadoPor() {
        return this.modificadoPor;
    }


  public void setModificadoPor (Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }



   public Integer getRespuestaId() {
        return this.respuestaId;
    }


  public void setRespuestaId (Integer respuestaId) {
        this.respuestaId = respuestaId;
    }



   public Pregunta getPreguntaId() {
        return this.preguntaId;
    }


  public void setPreguntaId (Pregunta preguntaId) {
        this.preguntaId = preguntaId;
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



    public Boolean isEsRespuestaCorrecta() {
        return this.esRespuestaCorrecta;
    }


  public void setEsRespuestaCorrecta (Boolean esRespuestaCorrecta) {
        this.esRespuestaCorrecta = esRespuestaCorrecta;
    }



   public String getTextoRespuesta() {
        return this.textoRespuesta;
    }


  public void setTextoRespuesta (String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }

}

