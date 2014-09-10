
package com.jcs.goboax.aulavirtual.model;


import java.io.Serializable;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Modulo")
@Table(name="Modulo")
public  class Modulo implements Serializable {


    @Column(name="creadoPor",table="Modulo",nullable=false)
    @Basic
    private int creadoPor;


    @Column(name="moduloId",table="Modulo",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer moduloId;


    @Column(name="modificadoPor",table="Modulo")
    @Basic
    private int modificadoPor;
    
    @Column(name="nombre", table="Modulo")
    @Basic
    private String nombre;


    @Column(name="temario",table="Modulo",length=2048)
    @Basic
    private String temario;


    @Column(name="objetivoEspecifico",columnDefinition="1024",table="Modulo",nullable=false)
    @Basic
    private String objetivoEspecifico;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cursoId")
    private Curso curso;


    @Column(name="fechaCreacion",table="Modulo",nullable=false)
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;


    @Column(name="fechaModificacion",table="Modulo")
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;


    @OneToMany(targetEntity=Contenido.class,mappedBy="moduloId")
    private List<Contenido> contenidos;


    @Column(name="objetivoGeneral",columnDefinition="1024",table="Modulo")
    @Basic
    private String objetivoGeneral;

    public Modulo(){

    }


   public int getCreadoPor() {
        return this.creadoPor;
    }


  public void setCreadoPor (int creadoPor) {
        this.creadoPor = creadoPor;
    }

  public Curso getCurso() {
      return this.curso;
  }
  
  public void setCurso(Curso curso) {
      this.curso = curso;
  }

   public Integer getModuloId() {
        return this.moduloId;
    }


  public void setModuloId (Integer moduloId) {
        this.moduloId = moduloId;
    }



   public int getModificadoPor() {
        return this.modificadoPor;
    }


  public void setModificadoPor (int modificadoPor) {
        this.modificadoPor = modificadoPor;
    }
  
  public String getNombre() {
      return this.nombre;
  }
  
  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

   public String getTemario() {
        return this.temario;
    }


  public void setTemario (String temario) {
        this.temario = temario;
    }



   public String getObjetivoEspecifico() {
        return this.objetivoEspecifico;
    }


  public void setObjetivoEspecifico (String objetivoEspecifico) {
        this.objetivoEspecifico = objetivoEspecifico;
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



   public List<Contenido> getContenidos() {
        return this.contenidos;
    }


  public void setContenidos (List<Contenido> contenidos) {
        this.contenidos = contenidos;
    }



   public String getObjetivoGeneral() {
        return this.objetivoGeneral;
    }


  public void setObjetivoGeneral (String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }
  
  

    public Contenido addContenido(Contenido contenido)
    {
        getContenidos().add(contenido);
        contenido.setModulo(this);

        return contenido;
    }

    public Contenido removeContenido(Contenido contenido)
    {
        getContenidos().remove(contenido);
        contenido.setModulo(null);

        return contenido;
    }

}

