package com.jcs.goboax.aulavirtual.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class ExamenModel
{
    private Integer examenId;
    private int moduloId;
    private int numPreguntas;
    private int numRespuestasPregunta;
    private String postUrl;
    private String nuevaPregunta;
    private List<PreguntasModel> preguntas;
    
    private Boolean canSave;

    public Integer getExamenId()
    {
        return examenId;
    }

    public void setExamenId(Integer examenId)
    {
        this.examenId = examenId;
    }

    public int getModuloId()
    {
        return moduloId;
    }

    public void setModuloId(int moduloId)
    {
        this.moduloId = moduloId;
    }

    public int getNumPreguntas()
    {
        return numPreguntas;
    }

    public void setNumPreguntas(int numPreguntas)
    {
        this.numPreguntas = numPreguntas;
    }

    public int getNumRespuestasPregunta()
    {
        return numRespuestasPregunta;
    }

    public void setNumRespuestasPregunta(int numRespuestasPregunta)
    {
        this.numRespuestasPregunta = numRespuestasPregunta;
    }

    public String getNuevaPregunta()
    {
        return nuevaPregunta;
    }

    public void setNuevaPregunta(String nuevaPregunta)
    {
        this.nuevaPregunta = nuevaPregunta;
    }

    public List<PreguntasModel> getPreguntas()
    {
        if (preguntas == null)
        {
            preguntas = new ArrayList<PreguntasModel>();
        }
        return preguntas;
    }

    public void setPreguntas(List<PreguntasModel> preguntas)
    {
        this.preguntas = preguntas;
    }

    public String getPostUrl()
    {
        return postUrl;
    }

    public void setPostUrl(String postUrl)
    {
        this.postUrl = postUrl;
    }

    public Boolean getCanSave() {
        return canSave;
    }

    public void setCanSave(Boolean canSave) {
        this.canSave = canSave;
    }
}
