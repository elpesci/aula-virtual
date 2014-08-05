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
@Table(name="Pregunta")
public  class Pregunta implements Serializable {


    @Column(name="creadoPor",table="Pregunta",nullable=false)
    @Basic
    private int creadoPor;


    @Column(name="fecha",table="Pregunta")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fecha;


    @Column(name="modificadoPor",table="Pregunta")
    @Basic
    private Integer modificadoPor;


    @ManyToOne(optional=false,targetEntity=Examen.class)
    @JoinColumn(name="examenId",referencedColumnName="examenId",insertable=true,nullable=true,unique=false,updatable=true)
    private Examen examenId;


    @Column(name="preguntaId",table="Pregunta",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer preguntaId;


    @Column(name="fechaCreacion",table="Pregunta",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;


    @OneToMany(targetEntity=Respuesta.class,mappedBy="preguntaId")
    private Collection<Respuesta> respuestaCollection;


    @Column(name="textoPregunta",table="Pregunta",length=500)
    @Basic
    private String textoPregunta;

    public Pregunta(){

    }


   public int getCreadoPor() {
        return this.creadoPor;
    }


  public void setCreadoPor (int creadoPor) {
        this.creadoPor = creadoPor;
    }



   public Date getFecha() {
        return this.fecha;
    }


  public void setFecha (Date fecha) {
        this.fecha = fecha;
    }



   public Integer getModificadoPor() {
        return this.modificadoPor;
    }


  public void setModificadoPor (Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }



   public Examen getExamenId() {
        return this.examenId;
    }


  public void setExamenId (Examen examenId) {
        this.examenId = examenId;
    }



   public Integer getPreguntaId() {
        return this.preguntaId;
    }


  public void setPreguntaId (Integer preguntaId) {
        this.preguntaId = preguntaId;
    }



   public Date getFechaCreacion() {
        return this.fechaCreacion;
    }


  public void setFechaCreacion (Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }



   public Collection<Respuesta> getRespuestaCollection() {
        return this.respuestaCollection;
    }


  public void setRespuestaCollection (Collection<Respuesta> respuestaCollection) {
        this.respuestaCollection = respuestaCollection;
    }



   public String getTextoPregunta() {
        return this.textoPregunta;
    }


  public void setTextoPregunta (String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

}

