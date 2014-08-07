package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the Contenido database table.
 * 
 */
@Entity
@NamedQuery(name="Contenido.findAll", query="SELECT c FROM Contenido c")
@Table(name="Contenido")
public class Contenido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int contenidoId;

	@Lob
	@Basic(fetch=FetchType.LAZY)
	private byte[] archivoMaterial;

	private int creadoPor;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	private String fechaModificacion;

	private int modificadoPor;

	private String nombre;

	//bi-directional many-to-one association to Curso
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cursoId")
	private Curso curso;

	//bi-directional many-to-one association to TipoContenido
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipoContenidoId")
	private TipoContenido tipoContenido;

	public Contenido() {
	}

	public int getContenidoId() {
		return this.contenidoId;
	}

	public void setContenidoId(int contenidoId) {
		this.contenidoId = contenidoId;
	}

	public byte[] getArchivoMaterial() {
		return this.archivoMaterial;
	}

	public void setArchivoMaterial(byte[] archivoMaterial) {
		this.archivoMaterial = archivoMaterial;
	}

	public int getCreadoPor() {
		return this.creadoPor;
	}

	public void setCreadoPor(int creadoPor) {
		this.creadoPor = creadoPor;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public int getModificadoPor() {
		return this.modificadoPor;
	}

	public void setModificadoPor(int modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public TipoContenido getTipoContenido() {
		return this.tipoContenido;
	}

	public void setTipoContenido(TipoContenido tipoContenido) {
		this.tipoContenido = tipoContenido;
	}

}