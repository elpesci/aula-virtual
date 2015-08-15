package com.jcs.goboax.aulavirtual.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class ExamenModel
{
    private int examenId;
    private int moduloId;
    private int numPreguntas;
    private int numRespuestasPregunta;
    private String postUrl;
    private String nuevaPregunta;
    private List<PreguntasModel> preguntas;
    private boolean canSave;

    public int getExamenId()
    {
        return examenId;
    }

    public void setExamenId(int examenId)
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

    public boolean isCanSave()
    {
        return canSave;
    }

    public void setCanSave(boolean canSave)
    {
        this.canSave = canSave;
    }

    public String getPostUrl()
    {
        return postUrl;
    }

    public void setPostUrl(String postUrl)
    {
        this.postUrl = postUrl;
    }
}
