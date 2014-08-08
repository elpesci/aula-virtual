package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({ @NamedQuery(name = Curso.CURSO_ALL_QUERYNAME, query = "SELECT c FROM Curso c") })
@Entity
@Table(name = "Curso")
public class Curso
        implements Serializable
{

    private static final long serialVersionUID = 1L;

    public final static String CURSO_ALL_QUERYNAME = "curso.all";

    @Id
    private int cursoId;

    private String audiencia;

    private int creadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private boolean habilitado;

    private int modificadoPor;

    private String nombre;

    private String objetivo;

    // bi-directional many-to-one association to Contenido
    @OneToMany(mappedBy = "curso")
    private List<Contenido> contenidos;

    // bi-directional many-to-one association to Examen
    @OneToMany(mappedBy = "curso")
    private List<Examen> examens;

    // bi-directional many-to-one association to Sesion
    @OneToMany(mappedBy = "curso")
    private List<Sesion> sesions;

    public Curso()
    {
    }

    public int getCursoId()
    {
        return this.cursoId;
    }

    public void setCursoId(int cursoId)
    {
        this.cursoId = cursoId;
    }

    public String getAudiencia()
    {
        return this.audiencia;
    }

    public void setAudiencia(String audiencia)
    {
        this.audiencia = audiencia;
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

    public boolean getHabilitado()
    {
        return this.habilitado;
    }

    public void setHabilitado(boolean habilitado)
    {
        this.habilitado = habilitado;
    }

    public int getModificadoPor()
    {
        return this.modificadoPor;
    }

    public void setModificadoPor(int modificadoPor)
    {
        this.modificadoPor = modificadoPor;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getObjetivo()
    {
        return this.objetivo;
    }

    public void setObjetivo(String objetivo)
    {
        this.objetivo = objetivo;
    }

    public List<Contenido> getContenidos()
    {
        return this.contenidos;
    }

    public void setContenidos(List<Contenido> contenidos)
    {
        this.contenidos = contenidos;
    }

    public Contenido addContenido(Contenido contenido)
    {
        getContenidos().add(contenido);
        contenido.setCurso(this);

        return contenido;
    }

    public Contenido removeContenido(Contenido contenido)
    {
        getContenidos().remove(contenido);
        contenido.setCurso(null);

        return contenido;
    }

    public List<Examen> getExamens()
    {
        return this.examens;
    }

    public void setExamens(List<Examen> examens)
    {
        this.examens = examens;
    }

    public Examen addExamen(Examen examen)
    {
        getExamens().add(examen);
        examen.setCurso(this);

        return examen;
    }

    public Examen removeExamen(Examen examen)
    {
        getExamens().remove(examen);
        examen.setCurso(null);

        return examen;
    }

    public List<Sesion> getSesions()
    {
        return this.sesions;
    }

    public void setSesions(List<Sesion> sesions)
    {
        this.sesions = sesions;
    }

    public Sesion addSesion(Sesion sesion)
    {
        getSesions().add(sesion);
        sesion.setCurso(this);

        return sesion;
    }

    public Sesion removeSesion(Sesion sesion)
    {
        getSesions().remove(sesion);
        sesion.setCurso(null);

        return sesion;
    }

}
