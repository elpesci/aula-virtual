package com.jcs.goboax.aulavirtual.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistent class for the Usuario database table.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Usuario.USUARIO_ALL_QUERYNAME, query = "SELECT u FROM Usuario u"),
        @NamedQuery(name = Usuario.USUARIO_BY_EMAIL, query = "SELECT u FROM Usuario u "
                + "WHERE u.username = :" + Usuario.USUARIO_EMAIL_PARAMETER),
        @NamedQuery(name = Usuario.USUARIO_NOT_SUPERADMIN, query = "SELECT u FROM Usuario u "
                + "JOIN u.usuarioPerfils up JOIN up.perfil p WHERE p.codigo <> 'SUPER_ADMIN'")
})
@Table(name = "Usuario")
public class Usuario
        implements UserDetails, Serializable
{
    public enum UsuarioStatus
    {
        ACTIVE, VERIFICATION_PENDING, CHANGE_PASSWORD, DISABLED, REMOVED
    };

    public static final String USUARIO_ALL_QUERYNAME = "usuario.findAll";
    public static final String USUARIO_BY_EMAIL = "usuario.findByEmail";
    public static final String USUARIO_NOT_SUPERADMIN = "usuario.notsuperAdmin";

    public static final String USUARIO_EMAIL_PARAMETER = "email";

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioId;

    private int creadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;

    private String password;

    private String username;

    private String verificationKey;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UsuarioStatus status;

    // bi-directional many-to-one association to RegistroAcceso
    @OneToMany(mappedBy = "usuario")
    private List<RegistroAcceso> registroAccesos;

    // bi-directional many-to-one association to Persona
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personaId")
    private Persona persona;

    // bi-directional many-to-one association to UsuarioPerfil
    @OneToMany(mappedBy = "usuario")
    private Set<UsuarioPerfil> usuarioPerfils;

    public Usuario()
    {
    }

    public int getUsuarioId()
    {
        return this.usuarioId;
    }

    public void setUsuarioId(int usuarioId)
    {
        this.usuarioId = usuarioId;
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

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public List<RegistroAcceso> getRegistroAccesos()
    {
        return this.registroAccesos;
    }

    public void setRegistroAccesos(List<RegistroAcceso> registroAccesos)
    {
        this.registroAccesos = registroAccesos;
    }

    public RegistroAcceso addRegistroAcceso(RegistroAcceso registroAcceso)
    {
        getRegistroAccesos().add(registroAcceso);
        registroAcceso.setUsuario(this);

        return registroAcceso;
    }

    public RegistroAcceso removeRegistroAcceso(RegistroAcceso registroAcceso)
    {
        getRegistroAccesos().remove(registroAcceso);
        registroAcceso.setUsuario(null);

        return registroAcceso;
    }

    public Persona getPersona()
    {
        return this.persona;
    }

    public void setPersona(Persona persona)
    {
        this.persona = persona;
    }

    public Set<UsuarioPerfil> getUsuarioPerfils()
    {
        return this.usuarioPerfils;
    }

    public UsuarioStatus getStatus()
    {
        return status;
    }

    public void setStatus(UsuarioStatus status)
    {
        this.status = status;
    }

    public void setUsuarioPerfils(Set<UsuarioPerfil> usuarioPerfils)
    {
        this.usuarioPerfils = usuarioPerfils;
    }

    public UsuarioPerfil addUsuarioPerfil(UsuarioPerfil usuarioPerfil)
    {
        getUsuarioPerfils().add(usuarioPerfil);
        usuarioPerfil.setUsuario(this);

        return usuarioPerfil;
    }

    public UsuarioPerfil removeUsuarioPerfil(UsuarioPerfil usuarioPerfil)
    {
        getUsuarioPerfils().remove(usuarioPerfil);
        usuarioPerfil.setUsuario(null);

        return usuarioPerfil;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (UsuarioPerfil myUsuarioPerfil : usuarioPerfils) 
        {
            authorities.add(new SimpleGrantedAuthority(myUsuarioPerfil.getPerfil().getCodigo()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return UsuarioStatus.ACTIVE.equals(status);
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return !UsuarioStatus.VERIFICATION_PENDING.equals(status);
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return !UsuarioStatus.CHANGE_PASSWORD.equals(status);
    }

    @Override
    public boolean isEnabled()
    {
        return !UsuarioStatus.DISABLED.equals(status);
    }

    public boolean isChangePassword()
    {
        return status != null && UsuarioStatus.CHANGE_PASSWORD.equals(status);
    }

    public boolean isVerificationPending()
    {
        return status != null && UsuarioStatus.VERIFICATION_PENDING.equals(status);
    }

    public String getVerificationKey()
    {
        return verificationKey;
    }

    public void setVerificationKey(String verificationKey)
    {
        this.verificationKey = verificationKey;
    }
}