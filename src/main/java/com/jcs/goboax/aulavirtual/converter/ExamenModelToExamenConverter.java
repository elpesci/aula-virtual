package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.dao.api.ExamenDao;
import com.jcs.goboax.aulavirtual.dao.api.ModuloDao;
import com.jcs.goboax.aulavirtual.dao.api.PreguntaDao;
import com.jcs.goboax.aulavirtual.dao.api.RespuestaDao;
import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.model.Pregunta;
import com.jcs.goboax.aulavirtual.model.Respuesta;
import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
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

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ExamenDao examenDao;

    @Autowired
    private PreguntaDao preguntaDao;

    @Autowired
    private RespuestaDao respuestaDao;

    @Override
    public Examen convert(ExamenModel examenModel)
    {
        Examen myExamen = new Examen();
        if (examenModel.getExamenId() != null)
        {
            myExamen = examenDao.findByKey(examenModel.getExamenId());
            myExamen.setFechaModificacion(new Date());
            myExamen.setModificadoPor(authenticationService.getUsuario().getUsuarioId());
        }
        else
        {
            myExamen.setCreadoPor(authenticationService.getUsuario().getUsuarioId());
            myExamen.setFechaCreacion(new Date());
        }
        myExamen.setModulo(moduloDao.findByKey(examenModel.getModuloId()));
        myExamen.setNumPreguntas(examenModel.getNumPreguntas());
        myExamen.setNumRespuestasPregunta(examenModel.getNumRespuestasPregunta());
        myExamen.setPreguntas(null);
        for (PreguntasModel myPreguntasModel : examenModel.getPreguntas())
        {
            Pregunta myPregunta = new Pregunta();
            if (myPreguntasModel.getPreguntaId() != null )
            {
                myPregunta = preguntaDao.findByKey(myPreguntasModel.getPreguntaId());
                myPregunta.setModificadoPor(authenticationService.getUsuario().getUsuarioId());
                myPregunta.setFecha(new Date());
            }
            else
            {
                myPregunta.setCreadoPor(authenticationService.getUsuario().getUsuarioId());
                myPregunta.setFechaCreacion(new Date());
            }
            myPregunta.setExamen(myExamen);
            myPregunta.setTextoPregunta(myPreguntasModel.getTextoPregunta());
            myPregunta.setRespuestas(null);
            for (RespuestasModel myRespuestasModel : myPreguntasModel.getRespuestas())
            {
                Respuesta myRespuesta = new Respuesta();
                if (myRespuestasModel.getRespuestaId() != null)
                {
                    myRespuesta = respuestaDao.findByKey(myRespuestasModel.getRespuestaId());
                    myRespuesta.setModificadoPor(authenticationService.getUsuario().getUsuarioId());
                    myRespuesta.setFechaModificacion(new Date());
                }
                else
                {
                    myRespuesta.setCreadoPor(authenticationService.getUsuario().getUsuarioId());
                    myRespuesta.setFechaCreacion(new Date());
                }
                myRespuesta.setEsRespuestaCorrecta(myRespuestasModel.isEsRespuestaCorrecta());
                myRespuesta.setPregunta(myPregunta);
                myRespuesta.setTextoRespuesta(myRespuestasModel.getTextoRespuesta());
                myPregunta.addRespuesta(myRespuesta);
            }
            myExamen.addPregunta(myPregunta);
        }

        return myExamen;
    }
}
