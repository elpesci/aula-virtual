package com.jcs.goboax.aulavirtual.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExamenModelWrapper
{
    @JsonProperty(value = "Examen")
    private ExamenModel examen;

    public ExamenModel getExamen()
    {
        return examen;
    }

    public void setExamen(ExamenModel examen)
    {
        this.examen = examen;
    }
}
