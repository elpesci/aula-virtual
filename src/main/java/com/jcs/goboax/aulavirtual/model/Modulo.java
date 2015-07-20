package com.jcs.goboax.aulavirtual.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Modulo database table.
 */
@Entity
@Table(name = "Modulo")
@NamedQueries({
        @NamedQuery(name = Modulo.MODULE_ALL, query = "SELECT m FROM Modulo m"),
        @NamedQuery(name = Modulo.MODULE_BY_COURSE,
            query = "SELECT m FROM Modulo m WHERE m.curso = :" + Modulo.MODULE_COURSE_PARAMETER),
        @NamedQuery(name = Modulo.MODULE_ACTIVE_BY_COURSE,
            query = "SELECT m FROM Modulo m WHERE m.curso = :" + Modulo.MODULE_COURSE_PARAMETER
                    + " AND m.habilitado = true")
})
public class Modulo implements Serializable
{
    public final static String MODULE_ALL = "modulo.findAll";
    public final static String MODULE_BY_COURSE = "modulo.byCourse";
    public final static String MODULE_ACTIVE_BY_COURSE = "modulo.activeByCourse";
    public final static String MODULE_COURSE_PARAMETER = "course";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int moduloId;

    private int creadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;

    private String nombre;

    private String objetivoEspecifico;

    private String objetivoGeneral;

    private String temario;
    
    private String tareas;

    private boolean habilitado;

    //bi-directional many-to-one association to Contenido
    @OneToMany(mappedBy = "modulo")
    private List<Contenido> contenidos;

    //bi-directional many-to-one association to Curso
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cursoId")
    private Curso curso;

    public Modulo()
    {
    }

    public int getModuloId()
    {
        return this.moduloId;
    }

    public void setModuloId(int moduloId)
    {
        this.moduloId = moduloId;
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

    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getObjetivoEspecifico()
    {
        return this.objetivoEspecifico;
    }

    public void setObjetivoEspecifico(String objetivoEspecifico)
    {
        this.objetivoEspecifico = objetivoEspecifico;
    }

    public String getObjetivoGeneral()
    {
        return this.objetivoGeneral;
    }

    public void setObjetivoGeneral(String objetivoGeneral)
    {
        this.objetivoGeneral = objetivoGeneral;
    }

    public String getTemario()
    {
        return this.temario;
    }

    public void setTemario(String temario)
    {
        this.temario = temario;
    }

    public boolean isHabilitado()
    {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado)
    {
        this.habilitado = habilitado;
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
        contenido.setModulo(this);

        return contenido;
    }

    public Contenido removeContenido(Contenido contenido)
    {
        getContenidos().remove(contenido);
        contenido.setModulo(null);

        return contenido;
    }

    public Curso getCurso()
    {
        return this.curso;
    }

    public void setCurso(Curso curso)
    {
        this.curso = curso;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

}