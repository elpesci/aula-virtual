package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.ExamenDao;
import com.jcs.goboax.aulavirtual.dao.api.PreguntaDao;
import com.jcs.goboax.aulavirtual.dao.api.RespuestaDao;
import com.jcs.goboax.aulavirtual.dao.api.ValoracionDao;
import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.model.Respuesta;
import com.jcs.goboax.aulavirtual.model.Valoracion;
import com.jcs.goboax.aulavirtual.model.ValoracionPK;
import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.service.api.ExamenService;
import com.jcs.goboax.aulavirtual.service.api.ValoracionService;
import com.jcs.goboax.aulavirtual.viewmodel.AppraisalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

@Service
@Transactional
public class ValoracionServiceImpl
    implements ValoracionService
{
    @Autowired
    private ValoracionDao valoracionDao;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private RespuestaDao respuestaDao;

    @Autowired
    private ExamenService examenService;

    @Override
    public Valoracion reviewTest(AppraisalModel anAppraisalModel)
    {
        Valoracion myValoracion = new Valoracion();
        ValoracionPK myValoracionPK = new ValoracionPK();
        myValoracionPK.setExamenId(anAppraisalModel.getExamenId());
        myValoracionPK.setUsuarioId(authenticationService.getUsuario().getUsuarioId());
        myValoracion.setId(myValoracionPK);
        Examen myExamen = examenService.readExamById(anAppraisalModel.getExamenId());
        myValoracion.setPreguntasExamen(myExamen.getNumPreguntas());

        Integer myCorrectAnswers = 0;
        Map<Integer, Integer> myAnswers = anAppraisalModel.getRespuestas();
        for (Integer myQuestion : myAnswers.keySet()) {
            Respuesta myRespuesta = respuestaDao.respuestaCorrectaByPregunta(myQuestion);
            if (myRespuesta.getRespuestaId() == myAnswers.get(myQuestion)) {
                myCorrectAnswers++;
            }
        }
        myValoracion.setPreguntasCorrectas(myCorrectAnswers);
        myValoracion.setCreadoPor(authenticationService.getUsuario().getUsuarioId());
        myValoracion.setFechaCreacion(new Date());

        valoracionDao.persist(myValoracion);

        return myValoracion;
    }
}
