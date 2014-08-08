package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ExtensionContenido database table.
 * 
 */
@Entity
@NamedQuery(name = "ExtensionContenido.findAll", query = "SELECT e FROM ExtensionContenido e")
public class ExtensionContenido
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private int extensionContenidoId;

    private int creadoPor;

    private String extension;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;

    // bi-directional many-to-one association to TipoContenido
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoContenidoId")
    private TipoContenido tipoContenido;

    public ExtensionContenido()
    {
    }

    public int getExtensionContenidoId()
    {
        return this.extensionContenidoId;
    }

    public void setExtensionContenidoId(int extensionContenidoId)
    {
        this.extensionContenidoId = extensionContenidoId;
    }

    public int getCreadoPor()
    {
        return this.creadoPor;
    }

    public void setCreadoPor(int creadoPor)
    {
        this.creadoPor = creadoPor;
    }

    public String getExtension()
    {
        return this.extension;
    }

    public void setExtension(String extension)
    {
        this.extension = extension;
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

    public TipoContenido getTipoContenido()
    {
        return this.tipoContenido;
    }

    public void setTipoContenido(TipoContenido tipoContenido)
    {
        this.tipoContenido = tipoContenido;
    }

}