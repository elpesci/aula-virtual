package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Embeddable
public class SesionAlumnoPK
        implements Serializable {

    private static final long serialVersionUID = 8805568274618481171L;

    @Column(name = "Sesion_sesionId", insertable = false, updatable = false)
    private int sesionsesionId;

    @Column(name = "Alumno_alumnoId", insertable = false, updatable = false)
    private int alumnoalumnoId;

    public int getSesionsesionId() {
        return sesionsesionId;
    }

    public void setSesionsesionId(int sesionsesionId) {
        this.sesionsesionId = sesionsesionId;
    }

    public int getAlumnoalumnoId() {
        return alumnoalumnoId;
    }

    public void setAlumnoalumnoId(int alumnoalumnoId) {
        this.alumnoalumnoId = alumnoalumnoId;
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }

        if (!(anObject instanceof SesionAlumnoPK)) {
            return false;
        }

        SesionAlumnoPK mySesionAlumnoId = (SesionAlumnoPK) anObject;

        return new EqualsBuilder()
                .append(getSesionsesionId(),
                        mySesionAlumnoId.getSesionsesionId())
                .append(getAlumnoalumnoId(),
                        mySesionAlumnoId.getAlumnoalumnoId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getSesionsesionId())
                .append(getAlumnoalumnoId()).toHashCode();
    }
}
