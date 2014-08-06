package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQuery(name = Perfil.PROFILE_ALL_QUERYNAME, query = "SELECT p FROM Perfil p")
@Entity
@Table(name = "Perfil")
public class Perfil
        implements Serializable
{
    private static final long serialVersionUID = 7915160426517813587L;

    public static final String PROFILE_ALL_QUERYNAME = "perfil.findAll";

    @Column(name = "nombre", table = "Perfil", nullable = false, length = 45)
    @Basic
    private String nombre;

    @OneToMany(targetEntity = UsuarioPerfil.class, mappedBy = "perfil")
    private Collection<UsuarioPerfil> usuarioPerfilCollection;

    @Column(name = "creadoPor", table = "Perfil", nullable = false)
    @Basic
    private int creadoPor;

    @Column(name = "perfilId", table = "Perfil", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer perfilId;

    @Column(name = "modificadoPor", table = "Perfil")
    @Basic
    private Integer modificadoPor;

    @Column(name = "fechaCreacion", table = "Perfil", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;

    @Column(name = "fechaModificacion", table = "Perfil")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    public Perfil()
    {

    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Collection<UsuarioPerfil> getUsuarioPerfilCollection()
    {
        return this.usuarioPerfilCollection;
    }

    public void setUsuarioPerfilCollection(
            Collection<UsuarioPerfil> usuarioPerfilCollection)
    {
        this.usuarioPerfilCollection = usuarioPerfilCollection;
    }

    public int getCreadoPor()
    {
        return this.creadoPor;
    }

    public void setCreadoPor(int creadoPor)
    {
        this.creadoPor = creadoPor;
    }

    public Integer getPerfilId()
    {
        return this.perfilId;
    }

    public void setPerfilId(Integer perfilId)
    {
        this.perfilId = perfilId;
    }

    public Integer getModificadoPor()
    {
        return this.modificadoPor;
    }

    public void setModificadoPor(Integer modificadoPor)
    {
        this.modificadoPor = modificadoPor;
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

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

}
