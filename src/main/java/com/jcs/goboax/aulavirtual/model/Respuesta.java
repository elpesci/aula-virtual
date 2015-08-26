package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the Respuesta database table.
 * 
 */
@Entity
@NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r")
@Table(name="Respuesta")
public class Respuesta
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int respuestaId;

    private int creadoPor;

    private boolean esRespuestaCorrecta;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;

    private String textoRespuesta;

    // bi-directional many-to-one association to Evaluacion
    @OneToMany(mappedBy = "respuesta")
    private List<Evaluacion> evaluacions;

    // bi-directional many-to-one association to Pregunta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "preguntaId")
    private Pregunta pregunta;

    public Respuesta()
    {
    }

    public int getRespuestaId()
    {
        return this.respuestaId;
    }

    public void setRespuestaId(int respuestaId)
    {
        this.respuestaId = respuestaId;
    }

    public int getCreadoPor()
    {
        return this.creadoPor;
    }

    public void setCreadoPor(int creadoPor)
    {
        this.creadoPor = creadoPor;
    }

    public boolean getEsRespuestaCorrecta()
    {
        return this.esRespuestaCorrecta;
    }

    public void setEsRespuestaCorrecta(boolean esRespuestaCorrecta)
    {
        this.esRespuestaCorrecta = esRespuestaCorrecta;
    }

    public Date getFechaCreacion()
    {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion)
    {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion()
    {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion)
    {
        this.fechaModificacion = fechaModificacion;
    }

    public int getModificadoPor()
    {
        return this.modificadoPor;
    }

    public void setModificadoPor(int modificadoPor)
    {
        this.modificadoPor = modificadoPor;
    }

    public String getTextoRespuesta()
    {
        return this.textoRespuesta;
    }

    public void setTextoRespuesta(String textoRespuesta)
    {
        this.textoRespuesta = textoRespuesta;
    }

    public List<Evaluacion> getEvaluacions()
    {
        return this.evaluacions;
    }

    public void setEvaluacions(List<Evaluacion> evaluacions)
    {
        this.evaluacions = evaluacions;
    }

    public Evaluacion addEvaluacion(Evaluacion evaluacion)
    {
        getEvaluacions().add(evaluacion);
        evaluacion.setRespuesta(this);

        return evaluacion;
    }

    public Evaluacion removeEvaluacion(Evaluacion evaluacion)
    {
        getEvaluacions().remove(evaluacion);
        evaluacion.setRespuesta(null);

        return evaluacion;
    }

    public Pregunta getPregunta()
    {
        return this.pregunta;
    }

    public void setPregunta(Pregunta pregunta)
    {
        this.pregunta = pregunta;
    }

}