package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
 * The persistent class for the Pregunta database table.
 * 
 */
@Entity
@NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p")
@Table(name="Pregunta")
public class Pregunta
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int preguntaId;

    private int creadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    private int modificadoPor;

    private String textoPregunta;

    // bi-directional many-to-one association to Examen
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "examenId")
    private Examen examen;

    // bi-directional many-to-one association to Respuesta
    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas;

    public Pregunta()
    {
    }

    public int getPreguntaId()
    {
        return this.preguntaId;
    }

    public void setPreguntaId(int preguntaId)
    {
        this.preguntaId = preguntaId;
    }

    public int getCreadoPor()
    {
        return this.creadoPor;
    }

    public void setCreadoPor(int creadoPor)
    {
        this.creadoPor = creadoPor;
    }

    public Date getFecha()
    {
        return this.fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public Date getFechaCreacion()
    {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion)
    {
        this.fechaCreacion = fechaCreacion;
    }

    public int getModificadoPor()
    {
        return this.modificadoPor;
    }

    public void setModificadoPor(int modificadoPor)
    {
        this.modificadoPor = modificadoPor;
    }

    public String getTextoPregunta()
    {
        return this.textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta)
    {
        this.textoPregunta = textoPregunta;
    }

    public Examen getExamen()
    {
        return this.examen;
    }

    public void setExamen(Examen examen)
    {
        this.examen = examen;
    }

    public List<Respuesta> getRespuestas()
    {
        if (respuestas == null)
        {
            respuestas = new ArrayList<Respuesta>();
        }
        return this.respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas)
    {
        this.respuestas = respuestas;
    }

    public Respuesta addRespuesta(Respuesta respuesta)
    {
        getRespuestas().add(respuesta);
        respuesta.setPregunta(this);

        return respuesta;
    }

    public Respuesta removeRespuesta(Respuesta respuesta)
    {
        getRespuestas().remove(respuesta);
        respuesta.setPregunta(null);

        return respuesta;
    }

}