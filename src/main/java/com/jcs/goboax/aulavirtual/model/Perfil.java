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

@NamedQueries({
        @NamedQuery(name = Perfil.PROFILE_ALL_QUERYNAME, query = "SELECT p FROM Perfil p WHERE p.codigo <> 'SUPER_ADMIN'"),
        @NamedQuery(name = Perfil.PROFILE_BY_CODE_QUERYNAME, query = "SELECT p FROM Perfil p WHERE p.codigo = :"
                + Perfil.PROFILE_BY_CODE_PARAMETER) })
@Entity
@Table(name = "Perfil")
public class Perfil
        implements Serializable
{
    public enum PerfilCodes
    {
        SUPER_ADMIN,
        COORDINADOR,
        INSTRUCTOR,
        ALUMNO
    };
    
    private static final long serialVersionUID = 7915160426517813587L;

    public static final String PROFILE_ALL_QUERYNAME = "perfil.findAll";
    public static final String PROFILE_BY_CODE_QUERYNAME = "perfil.byCode";

    public static final String PROFILE_BY_CODE_PARAMETER = "code";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int perfilId;

    private String codigo;

    private int creadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;

    private String nombre;

    // bi-directional many-to-one association to UsuarioPerfil
    @OneToMany(mappedBy = "perfil")
    private List<UsuarioPerfil> usuarioPerfils;

    public Perfil()
    {
    }

    public int getPerfilId()
    {
        return this.perfilId;
    }

    public void setPerfilId(int perfilId)
    {
        this.perfilId = perfilId;
    }

    public String getCodigo()
    {
        return this.codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
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

    public List<UsuarioPerfil> getUsuarioPerfils()
    {
        return this.usuarioPerfils;
    }

    public void setUsuarioPerfils(List<UsuarioPerfil> usuarioPerfils)
    {
        this.usuarioPerfils = usuarioPerfils;
    }

    public UsuarioPerfil addUsuarioPerfil(UsuarioPerfil usuarioPerfil)
    {
        getUsuarioPerfils().add(usuarioPerfil);
        usuarioPerfil.setPerfil(this);

        return usuarioPerfil;
    }

    public UsuarioPerfil removeUsuarioPerfil(UsuarioPerfil usuarioPerfil)
    {
        getUsuarioPerfils().remove(usuarioPerfil);
        usuarioPerfil.setPerfil(null);

        return usuarioPerfil;
    }
}
