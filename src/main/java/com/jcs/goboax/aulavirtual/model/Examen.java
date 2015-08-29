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
import javax.persistence.OneToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the Examen database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Examen.EXAMEN_ALL_QUERYNAME, query = "SELECT e FROM Examen e"),
    @NamedQuery(name = Examen.EXAMEN_BY_MODULO_QUERYNAME,
            query="SELECT e FROM Examen e WHERE e.modulo = :" + Examen.EXAMEN_MODULE_PARAMETER)
})
@Table(name="Examen")
public class Examen
        implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public static final String EXAMEN_ALL_QUERYNAME = "Examen.findAll";
    public static final String EXAMEN_BY_MODULO_QUERYNAME = "Examen.findByModule";
    
    public final static String EXAMEN_MODULE_PARAMETER = "module";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examenId;

    private int creadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;

    private int numPreguntas;

    private int numRespuestasPregunta;

    /*
    // bi-directional many-to-one association to Curso
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cursoId")
    private Curso curso;
    */
    
    // bi-directional one-to-one association to Modulo
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moduloId")
    private Modulo modulo;

    // bi-directional many-to-one association to Pregunta
    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pregunta> preguntas;

    public Examen()
    {
    }

    public int getExamenId()
    {
        return this.examenId;
    }

    public void setExamenId(int examenId)
    {
        this.examenId = examenId;
    }

    public int getCreadoPor()
    {
        return this.creadoPor;
    }

    public void setCreadoPor(int creadoPor)
    {
        this.creadoPor = creadoPor;
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

    public int getNumPreguntas()
    {
        return this.numPreguntas;
    }

    public void setNumPreguntas(int numPreguntas)
    {
        this.numPreguntas = numPreguntas;
    }

    public int getNumRespuestasPregunta()
    {
        return this.numRespuestasPregunta;
    }

    public void setNumRespuestasPregunta(int numRespuestasPregunta)
    {
        this.numRespuestasPregunta = numRespuestasPregunta;
    }

    /*
    public Curso getCurso()
    {
        return this.curso;
    }

    public void setCurso(Curso curso)
    {
        this.curso = curso;
    }
    */

    public List<Pregunta> getPreguntas()
    {
        if (preguntas == null)
        {
            preguntas = new ArrayList<Pregunta>();
        }
        return this.preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas)
    {
        this.preguntas = preguntas;
    }

    public Pregunta addPregunta(Pregunta pregunta)
    {
        getPreguntas().add(pregunta);
        pregunta.setExamen(this);

        return pregunta;
    }

    public Pregunta removePregunta(Pregunta pregunta)
    {
        getPreguntas().remove(pregunta);
        pregunta.setExamen(null);

        return pregunta;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

}