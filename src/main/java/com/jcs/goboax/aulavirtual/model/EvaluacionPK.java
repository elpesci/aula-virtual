package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Embeddable
public class EvaluacionPK
        implements Serializable {

    private static final long serialVersionUID = 2870534513776390109L;

    private int sesionId;
    private int respuestaId;
    private int alumnoId;

    public int getSesionId() {
        return sesionId;
    }

    public void setSesionId(int sesionId) {
        this.sesionId = sesionId;
    }

    public int getRespuestaId() {
        return respuestaId;
    }

    public void setRespuestaId(int respuestaId) {
        this.respuestaId = respuestaId;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }

        if (!(anObject instanceof EvaluacionPK)) {
            return false;
        }

        EvaluacionPK myEvaluacionId = (EvaluacionPK) anObject;

        return new EqualsBuilder()
                .append(getSesionId(), myEvaluacionId.getSesionId())
                .append(getRespuestaId(), myEvaluacionId.getRespuestaId())
                .append(getAlumnoId(), myEvaluacionId.getAlumnoId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getSesionId())
                .append(getRespuestaId()).append(getAlumnoId()).toHashCode();
    }
}
