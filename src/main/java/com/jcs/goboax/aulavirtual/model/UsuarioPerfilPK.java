package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Embeddable
public class UsuarioPerfilPK
        implements Serializable {

    private static final long serialVersionUID = -5355696638680390946L;

    private int perfilId;
    private int usuarioId;

    public int getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(int perfilId) {
        this.perfilId = perfilId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }

        if (!(anObject instanceof UsuarioPerfilPK)) {
            return false;
        }

        UsuarioPerfilPK myUsuarioPerfilId = (UsuarioPerfilPK) anObject;

        return new EqualsBuilder()
                .append(getUsuarioId(), myUsuarioPerfilId.getUsuarioId())
                .append(getPerfilId(), myUsuarioPerfilId.getPerfilId())
                .isEquals();

    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getUsuarioId())
                .append(getPerfilId()).toHashCode();
    }

}
