package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.dao.api.ModuloDao;
import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.model.Pregunta;
import com.jcs.goboax.aulavirtual.model.Respuesta;
import com.jcs.goboax.aulavirtual.viewmodel.ExamenModel;
import com.jcs.goboax.aulavirtual.viewmodel.PreguntasModel;
import com.jcs.goboax.aulavirtual.viewmodel.RespuestasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class ExamenModelToExamenConverter
    implements Converter<ExamenModel, Examen>
{

    @Autowired
    private ModuloDao moduloDao;

    @Override
    public Examen convert(ExamenModel examenModel)
    {
        Examen myExamen = new Examen();
        myExamen.setExamenId(examenModel.getExamenId());
        myExamen.setModulo(moduloDao.findByKey(examenModel.getModuloId()));
        myExamen.setNumPreguntas(examenModel.getNumPreguntas());
        myExamen.setNumRespuestasPregunta(examenModel.getNumRespuestasPregunta());

        for (PreguntasModel myPreguntasModel : examenModel.getPreguntas())
        {
            Pregunta myPregunta = new Pregunta();
            if (myPreguntasModel.getPreguntaId() != null )
            {
                myPregunta.setPreguntaId(myPreguntasModel.getPreguntaId());
            }
            myPregunta.setExamen(myExamen);
            myPregunta.setTextoPregunta(myPreguntasModel.getTextoPregunta());
            for (RespuestasModel myRespuestasModel : myPreguntasModel.getRespuestas())
            {
                Respuesta myRespuesta = new Respuesta();
                if (myRespuestasModel.getRespuestaId() != null)
                {
                    myRespuesta.setRespuestaId(myRespuestasModel.getRespuestaId());
                }
                myRespuesta.setEsRespuestaCorrecta(myRespuestasModel.isEsRespuestaCorrecta());
                myRespuesta.setPregunta(myPregunta);
                myRespuesta.setTextoRespuesta(myRespuestasModel.getTextoRespuesta());
                myRespuesta.setFechaCreacion(new Date());
                myPregunta.addRespuesta(myRespuesta);
            }
            myPregunta.setFechaCreacion(new Date());
            myExamen.addPregunta(myPregunta);
        }

        return myExamen;
    }
}
