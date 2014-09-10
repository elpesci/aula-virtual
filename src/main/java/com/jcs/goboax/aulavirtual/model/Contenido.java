package com.jcs.goboax.aulavirtual.model;

/*

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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Contenido")
public  class Contenido implements Serializable {


    @Column(name="nombre",table="Contenido",length=50)
    @Basic
    private String nombre;


    @ManyToOne(optional=false,targetEntity=Modulo.class)
    @JoinColumn(name="moduloId",referencedColumnName="moduloId",table="Modulo",insertable=true,nullable=true,unique=false,updatable=true)
    private Modulo moduloId;


    @Column(name="creadoPor",table="Contenido",nullable=false)
    @Basic
    private int creadoPor;


    @Column(name="archivoMaterial",table="Contenido")
    @Lob
    @Basic
    private byte [] archivoMaterial;


    @Column(name="modificadoPor",table="Contenido")
    @Basic
    private Integer modificadoPor;


    @Column(name="contenidoId",table="Contenido",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer contenidoId;


    @Column(name="path",table="Contenido",length=127)
    @Basic
    private String path;


    @Column(name="descripcion",table="Contenido",length=50)
    @Basic
    private String descripcion;


    @Column(name="fechaCreacion",table="Contenido",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;


    @ManyToOne(optional=false,targetEntity=TipoContenido.class)
    @JoinColumn(name="tipoContenidoId",referencedColumnName="tipoContenidoId",insertable=true,nullable=true,unique=false,updatable=true)
    private TipoContenido tipoContenidoId;


    @Column(name="fechaModificacion",table="Contenido",length=45)
    @Basic
    private String fechaModificacion;


    @Column(name="contentType",table="Contenido",length=127)
    @Basic
    private String contentType;

    public Contenido(){

    }


   public String getNombre() {
        return this.nombre;
    }


  public void setNombre (String nombre) {
        this.nombre = nombre;
    }



   public Modulo getModuloId() {
        return this.moduloId;
    }


  public void setModuloId (Modulo moduloId) {
        this.moduloId = moduloId;
    }



   public int getCreadoPor() {
        return this.creadoPor;
    }


  public void setCreadoPor (int creadoPor) {
        this.creadoPor = creadoPor;
    }



   public byte [] getArchivoMaterial() {
        return this.archivoMaterial;
    }


  public void setArchivoMaterial (byte [] archivoMaterial) {
        this.archivoMaterial = archivoMaterial;
    }



   public Integer getModificadoPor() {
        return this.modificadoPor;
    }


  public void setModificadoPor (Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }



   public Integer getContenidoId() {
        return this.contenidoId;
    }


  public void setContenidoId (Integer contenidoId) {
        this.contenidoId = contenidoId;
    }



   public String getPath() {
        return this.path;
    }


  public void setPath (String path) {
        this.path = path;
    }



   public String getDescripcion() {
        return this.descripcion;
    }


  public void setDescripcion (String descripcion) {
        this.descripcion = descripcion;
    }



   public Date getFechaCreacion() {
        return this.fechaCreacion;
    }


  public void setFechaCreacion (Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }



   public TipoContenido getTipoContenidoId() {
        return this.tipoContenidoId;
    }


  public void setTipoContenidoId (TipoContenido tipoContenidoId) {
        this.tipoContenidoId = tipoContenidoId;
    }



   public String getFechaModificacion() {
        return this.fechaModificacion;
    }


  public void setFechaModificacion (String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }



   public String getContentType() {
        return this.contentType;
    }


  public void setContentType (String contentType) {
        this.contentType = contentType;
    }

}



*/



import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the Contenido database table.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Contenido.CONTENT_ALL_QUERYNAME, query = "SELECT c FROM Contenido c"),
        @NamedQuery(name = Contenido.CONTENT_BY_COURSE, query = "SELECT c FROM Contenido c "
                + "WHERE c.curso = :" + Contenido.CONTENT_COURSE_PARAMETER)
})
@Table(name = "Contenido")
public class Contenido implements Serializable
{
    public static final String CONTENT_ALL_QUERYNAME = "contenido.findAll";
    public static final String CONTENT_BY_COURSE = "contenido.findByCourse";

    public static final String CONTENT_COURSE_PARAMETER = "curso";

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contenidoId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] archivoMaterial;

    private int creadoPor;

    private String descripcion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;
    
    private String contentType;

    private String nombre;


    //bi-directional many-to-one association to Modulo
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moduloId")
    private Modulo modulo;

    //bi-directional many-to-one association to TipoContenido
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoContenidoId")
    private TipoContenido tipoContenido;

    public Contenido()
    {
    }

    public int getContenidoId()
    {
        return this.contenidoId;
    }

    public void setContenidoId(int contenidoId)
    {
        this.contenidoId = contenidoId;
    }

    public byte[] getArchivoMaterial()
    {
        return this.archivoMaterial;
    }

    public void setArchivoMaterial(byte[] archivoMaterial)
    {
        this.archivoMaterial = archivoMaterial;
    }

    public int getCreadoPor()
    {
        return this.creadoPor;
    }

    public void setCreadoPor(int creadoPor)
    {
        this.creadoPor = creadoPor;
    }

    public String getDescripcion()
    {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
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

    public Modulo getModulo()
    {
        return this.modulo;
    }

    public void setModulo(Modulo modulo)
    {
        this.modulo = modulo;
    }

    public TipoContenido getTipoContenido()
    {
        return this.tipoContenido;
    }

    public void setTipoContenido(TipoContenido tipoContenido)
    {
        this.tipoContenido = tipoContenido;
    }

    public String getContentType()
    {
        return contentType;
    }

    public void setContentType(String contenttype)
    {
        this.contentType = contenttype;
    }
}