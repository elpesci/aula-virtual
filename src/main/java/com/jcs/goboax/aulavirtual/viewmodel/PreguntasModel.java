package com.jcs.goboax.aulavirtual.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class PreguntasModel
{
    private Integer preguntaId;
    private String textoPregunta;
    private List<RespuestasModel> respuestas;
    private String nuevaRespuesta;
    private Boolean esCorrecta;
    private Boolean esValida;
    private Boolean showSetRespuestaCorrecta;

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

    public Boolean getEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(Boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

    public Boolean getEsValida() {
        return esValida;
    }

    public void setEsValida(Boolean esValida) {
        this.esValida = esValida;
    }

    public Boolean getShowSetRespuestaCorrecta() {
        return showSetRespuestaCorrecta;
    }

    public void setShowSetRespuestaCorrecta(Boolean showSetRespuestaCorrecta) {
        this.showSetRespuestaCorrecta = showSetRespuestaCorrecta;
    }
}
