package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the RegistroAcceso database table.
 * 
 */
@Entity
@NamedQuery(name = "RegistroAcceso.findAll", query = "SELECT r FROM RegistroAcceso r")
@Table(name="RegistroAcceso")
public class RegistroAcceso
        implements Serializable
{
    private static final long serialVersionUID = 1L;

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