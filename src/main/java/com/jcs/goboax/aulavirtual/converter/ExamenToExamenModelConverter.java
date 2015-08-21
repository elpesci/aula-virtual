package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.model.Pregunta;
import com.jcs.goboax.aulavirtual.model.Respuesta;
import com.jcs.goboax.aulavirtual.viewmodel.ExamenModel;
import com.jcs.goboax.aulavirtual.viewmodel.PreguntasModel;
import com.jcs.goboax.aulavirtual.viewmodel.RespuestasModel;
import org.springframework.core.convert.converter.Converter;

public class ExamenToExamenModelConverter
    implements Converter<Examen, ExamenModel>
{

    @Override
    public ExamenModel convert(Examen examen)
    {
        ExamenModel myExamenModel = new ExamenModel();
        myExamenModel.setExamenId(examen.getExamenId());
        myExamenModel.setModuloId(examen.getModulo().getModuloId());
        myExamenModel.setNumPreguntas(examen.getNumPreguntas());
        myExamenModel.setNumRespuestasPregunta(examen.getNumRespuestasPregunta());
        myExamenModel.setCanSave(null);
        for (Pregunta myPregunta : examen.getPreguntas())
        {
            PreguntasModel myPreguntasModel = new PreguntasModel();
            myPreguntasModel.setPreguntaId(myPregunta.getPreguntaId());
            myPreguntasModel.setTextoPregunta(myPregunta.getTextoPregunta());
            
            myPreguntasModel.setEsCorrecta(null);
            myPreguntasModel.setEsValida(null);
            myPreguntasModel.setShowSetRespuestaCorrecta(null);
            
            for (Respuesta myRespuesta : myPregunta.getRespuestas())
            {
                RespuestasModel myRespuestasModel = new RespuestasModel();
                myRespuestasModel.setEsRespuestaCorrecta(myRespuesta.getEsRespuestaCorrecta());
                myRespuestasModel.setRespuestaId(myRespuesta.getRespuestaId());
                myRespuestasModel.setTextoRespuesta(myRespuesta.getTextoRespuesta());
                myPreguntasModel.getRespuestas().add(myRespuestasModel);
            }
            myExamenModel.getPreguntas().add(myPreguntasModel);

        }
        return myExamenModel;
    }
}
