package com.jcs.goboax.aulavirtual.viewmodel;

public class RespuestasModel
{
    private Integer respuestaId;
    private String textoRespuesta;
    private boolean esRespuestaCorrecta;

    public Integer getRespuestaId()
    {
        return respuestaId;
    }

    public void setRespuestaId(Integer respuestaId)
    {
        this.respuestaId = respuestaId;
    }

    public String getTextoRespuesta()
    {
        return textoRespuesta;
    }

    public void setTextoRespuesta(String textoRespuesta)
    {
        this.textoRespuesta = textoRespuesta;
    }

    public boolean isEsRespuestaCorrecta()
    {
        return esRespuestaCorrecta;
    }

    public void setEsRespuestaCorrecta(boolean esRespuestaCorrecta)
    {
        this.esRespuestaCorrecta = esRespuestaCorrecta;
    }
}
