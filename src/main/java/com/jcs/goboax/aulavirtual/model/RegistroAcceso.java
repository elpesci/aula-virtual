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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the RegistroAcceso database table.
 * 
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "RegistroAcceso.findAll", query = "SELECT r FROM RegistroAcceso r"),
        @NamedQuery(name = RegistroAcceso.REGISTRO_ACCESO_BY_SESSION,
                query = "SELECT r FROM RegistroAcceso r WHERE r.sessionId = :" + RegistroAcceso.REGISTRO_ACCESO_SESSION_PARAMETER )
})
@Table(name="RegistroAcceso")
public class RegistroAcceso
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    public static final String REGISTRO_ACCESO_BY_SESSION = "registroAcceso.bySessionId";

    public static final String REGISTRO_ACCESO_SESSION_PARAMETER = "sessionId";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registroAccesoId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date finAcceso;

    @Temporal(TemporalType.TIMESTAMP)
    private Date inicioAcceso;

    private String sessionId;

    // bi-directional many-to-one association to Usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    public RegistroAcceso()
    {
    }

    public int getRegistroAccesoId()
    {
        return this.registroAccesoId;
    }

    public void setRegistroAccesoId(int registroAccesoId)
    {
        this.registroAccesoId = registroAccesoId;
    }

    public Date getFinAcceso()
    {
        return this.finAcceso;
    }

    public void setFinAcceso(Date finAcceso)
    {
        this.finAcceso = finAcceso;
    }

    public Date getInicioAcceso()
    {
        return this.inicioAcceso;
    }

    public void setInicioAcceso(Date inicioAcceso)
    {
        this.inicioAcceso = inicioAcceso;
    }

    public String getSessionId()
    {
        return this.sessionId;
    }

    public void setSessionId(String sessionId)
    {
        this.sessionId = sessionId;
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