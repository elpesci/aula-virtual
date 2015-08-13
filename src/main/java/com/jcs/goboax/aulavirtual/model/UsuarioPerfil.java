package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the UsuarioPerfil database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = UsuarioPerfil.USUARIOPERFIL_ALL, query = "SELECT u FROM UsuarioPerfil u"),
    @NamedQuery(name = UsuarioPerfil.USUARIOPERFIL_PERFIL_BY_USUER, 
            query = "SELECT p FROM UsuarioPerfil up JOIN up.perfil p WHERE up.usuario = : " + 
                    UsuarioPerfil.USUARIOPERFIL_USER_PARAMETER)
})
@Table(name = "UsuarioPerfil")
public class UsuarioPerfil
        implements Serializable
{
    public final static String USUARIOPERFIL_USER_PARAMETER = "user";
    
    public final static String USUARIOPERFIL_ALL = "UsuarioPerfil.findAll";
    public final static String USUARIOPERFIL_PERFIL_BY_USUER = "UsuarioPerfil.PerfilByUser";
    
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UsuarioPerfilPK id;

    private int creadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;

    // bi-directional many-to-one association to Perfil
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfilId")
    private Perfil perfil;

    // bi-directional many-to-one association to Usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    public UsuarioPerfil()
    {
    }

    public UsuarioPerfilPK getId()
    {
        return this.id;
    }

    public void setId(UsuarioPerfilPK id)
    {
        this.id = id;
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

    public Perfil getPerfil()
    {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil)
    {
        this.perfil = perfil;
    }

    public Usuario getUsuario()
    {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

}