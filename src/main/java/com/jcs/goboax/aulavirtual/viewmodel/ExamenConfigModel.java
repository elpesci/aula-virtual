package com.jcs.goboax.aulavirtual.viewmodel;

import com.jcs.goboax.aulavirtual.model.Modulo;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ExamenConfigModel {
    
    private Integer examenId;
    
    private Integer moduloId;
    
    private Modulo modulo;
    
    @NotNull @Min(1)
    private Integer numPreguntas;
    
    @NotNull @Min(1)
    private Integer numRespuestasPregunta;

    /**
     * @return the examenId
     */
    public Integer getExamenId() {
        return examenId;
    }

    /**
     * @param examenId the examenId to set
     */
    public void setExamenId(Integer examenId) {
        this.examenId = examenId;
    }

    /**
     * @return the moduloId
     */
    public Integer getModuloId() {
        return moduloId;
    }

    /**
     * @param moduloId the moduloId to set
     */
    public void setModuloId(Integer moduloId) {
        this.moduloId = moduloId;
    }

    /**
     * @return the modulo
     */
    public Modulo getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    /**
     * @return the numPreguntas
     */
    public Integer getNumPreguntas() {
        return numPreguntas;
    }

    /**
     * @param numPreguntas the numPreguntas to set
     */
    public void setNumPreguntas(Integer numPreguntas) {
        this.numPreguntas = numPreguntas;
    }

    /**
     * @return the numRespuestasPregunta
     */
    public Integer getNumRespuestasPregunta() {
        return numRespuestasPregunta;
    }

    /**
     * @param numRespuestasPregunta the numRespuestasPregunta to set
     */
    public void setNumRespuestasPregunta(Integer numRespuestasPregunta) {
        this.numRespuestasPregunta = numRespuestasPregunta;
    }
}
