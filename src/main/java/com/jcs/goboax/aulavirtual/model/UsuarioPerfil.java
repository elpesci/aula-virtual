package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UsuarioPerfil")
public class UsuarioPerfil
        implements Serializable {

    private static final long serialVersionUID = 8673752823188472142L;

    @EmbeddedId
    private UsuarioPerfilPK id;

    @Column(name = "creadoPor", table = "UsuarioPerfil", nullable = false)
    @Basic
    private int creadoPor;

    @ManyToOne(optional = false, targetEntity = Usuario.class)
    @JoinColumn(name = "usuarioId", referencedColumnName = "usuarioId", insertable = false, nullable = true, unique = false, updatable = false)
    private Usuario usuario;

    @Column(name = "modificadoPor", table = "UsuarioPerfil")
    @Basic
    private Integer modificadoPor;

    @ManyToOne(optional = false, targetEntity = Perfil.class)
    @JoinColumn(name = "perfilId", referencedColumnName = "perfilId", insertable = false, nullable = true, unique = false, updatable = false)
    private Perfil perfil;

    @Column(name = "fechaCreacion", table = "UsuarioPerfil", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaCreacion;

    @Column(name = "fechaModificacion", table = "UsuarioPerfil")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaModificacion;

    public UsuarioPerfil() {

    }

    public int getCreadoPor() {
        return this.creadoPor;
    }

    public void setCreadoPor(int creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getModificadoPor() {
        return this.modificadoPor;
    }

    public void setModificadoPor(Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
