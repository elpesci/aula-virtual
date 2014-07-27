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
@Table(name="Examen")
public  class Examen implements Serializable {


    @OneToMany(targetEntity=Pregunta.class,mappedBy="examenId")
    private Collection<Pregunta> preguntaCollection;


    @Column(name="numPreguntas",table="Examen",nullable=false)
    @Basic
    private short numPreguntas;


    @Column(name="creadoPor",table="Examen",nullable=false)
    @Basic
    private int creadoPor;


    @Column(name="modificadoPor",table="Examen")
    @Basic
    private Integer modificadoPor;


    @Column(name="examenId",table="Examen",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer examenId;


    @ManyToOne(optional=false,targetEntity=Curso.class)
    @JoinColumn(name="cursoId",referencedColumnName="cursoId",insertable=true,nullable=true,unique=false,updatable=true)
    private Curso cursoId;


    @Column(name="fechaCreacion",table="Examen",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;


    @Column(name="fechaModificacion",table="Examen")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;


    @Column(name="numRespuestasPregunta",table="Examen",nullable=false)
    @Basic
    private short numRespuestasPregunta;

    public Examen(){

    }


   public Collection<Pregunta> getPreguntaCollection() {
        return this.preguntaCollection;
    }


  public void setPreguntaCollection (Collection<Pregunta> preguntaCollection) {
        this.preguntaCollection = preguntaCollection;
    }



   public short getNumPreguntas() {
        return this.numPreguntas;
    }


  public void setNumPreguntas (short numPreguntas) {
        this.numPreguntas = numPreguntas;
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



   public Integer getExamenId() {
        return this.examenId;
    }


  public void setExamenId (Integer examenId) {
        this.examenId = examenId;
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



   public short getNumRespuestasPregunta() {
        return this.numRespuestasPregunta;
    }


  public void setNumRespuestasPregunta (short numRespuestasPregunta) {
        this.numRespuestasPregunta = numRespuestasPregunta;
    }

}

