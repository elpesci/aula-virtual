package com.jcs.goboax.aulavirtual.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * The persistent class for the TipoContenido database table.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = TipoContenido.TIPO_CONTENIDO_ALL_QUERYNAME, query = "SELECT t FROM TipoContenido t")
})
@Table(name = "TipoContenido")
public class TipoContenido
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    public static final String TIPO_CONTENIDO_ALL_QUERYNAME = "tipoContenido.all";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoContenidoId;

    private int creadoPor;

    private String descripcion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;

    // bi-directional many-to-one association to Contenido
    @OneToMany(mappedBy = "tipoContenido")
    private List<Contenido> contenidos;

    // bi-directional many-to-one association to ExtensionContenido
    @OneToMany(mappedBy = "tipoContenido")
    private List<ExtensionContenido> extensionContenidos;

    public TipoContenido()
    {
    }

    public int getTipoContenidoId()
    {
        return this.tipoContenidoId;
    }

    public void setTipoContenidoId(int tipoContenidoId)
    {
        this.tipoContenidoId = tipoContenidoId;
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
        contenido.setTipoContenido(this);

        return contenido;
    }

    public Contenido removeContenido(Contenido contenido)
    {
        getContenidos().remove(contenido);
        contenido.setTipoContenido(null);

        return contenido;
    }

    public List<ExtensionContenido> getExtensionContenidos()
    {
        return this.extensionContenidos;
    }

    public void setExtensionContenidos(
            List<ExtensionContenido> extensionContenidos)
    {
        this.extensionContenidos = extensionContenidos;
    }

    public ExtensionContenido addExtensionContenido(
            ExtensionContenido extensionContenido)
    {
        getExtensionContenidos().add(extensionContenido);
        extensionContenido.setTipoContenido(this);

        return extensionContenido;
    }

    public ExtensionContenido removeExtensionContenido(
            ExtensionContenido extensionContenido)
    {
        getExtensionContenidos().remove(extensionContenido);
        extensionContenido.setTipoContenido(null);

        return extensionContenido;
    }

}