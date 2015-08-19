package com.jcs.goboax.aulavirtual.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class PreguntasModel
{
    private Integer preguntaId;
    private String textoPregunta;
    private List<RespuestasModel> respuestas;
    private String nuevaRespuesta;
    private boolean esCorrecta;
    private boolean esValida;
    private boolean showSetRespuestaCorrecta;

    public Integer getPreguntaId()
    {
        return preguntaId;
    }

    public void setPreguntaId(Integer preguntaId)
    {
        this.preguntaId = preguntaId;
    }

    public String getTextoPregunta()
    {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta)
    {
        this.textoPregunta = textoPregunta;
    }

    public List<RespuestasModel> getRespuestas()
    {
        if (respuestas == null)
        {
            respuestas = new ArrayList<RespuestasModel>();
        }
        return respuestas;
    }

    public void setRespuestas(List<RespuestasModel> respuestas)
    {
        this.respuestas = respuestas;
    }

    public String getNuevaRespuesta()
    {
        return nuevaRespuesta;
    }

    public void setNuevaRespuesta(String nuevaRespuesta)
    {
        this.nuevaRespuesta = nuevaRespuesta;
    }

    public boolean isEsCorrecta()
    {
        return esCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta)
    {
        this.esCorrecta = esCorrecta;
    }

    public boolean isShowSetRespuestaCorrecta()
    {
        return showSetRespuestaCorrecta;
    }

    public void setShowSetRespuestaCorrecta(boolean showSetRespuestaCorrecta)
    {
        this.showSetRespuestaCorrecta = showSetRespuestaCorrecta;
    }

    public boolean isEsValida() {
        return esValida;
    }
    
    public void setEsValida(boolean esValida) {
        this.esValida = esValida;
    }
}
