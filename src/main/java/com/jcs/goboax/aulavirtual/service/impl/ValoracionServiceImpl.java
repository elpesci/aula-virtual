package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.RespuestaDao;
import com.jcs.goboax.aulavirtual.dao.api.ValoracionDao;
import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.model.Respuesta;
import com.jcs.goboax.aulavirtual.model.Valoracion;
import com.jcs.goboax.aulavirtual.model.ValoracionPK;
import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.service.api.EmailService;
import com.jcs.goboax.aulavirtual.service.api.ExamenService;
import com.jcs.goboax.aulavirtual.service.api.ValoracionService;
import com.jcs.goboax.aulavirtual.viewmodel.AppraisalModel;
import org.apache.commons.lang.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
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

    @Autowired
    private EmailService emailService;

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
        anAppraisalModel.setNumPreguntas(myExamen.getNumPreguntas());

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
        myValoracion.setExamen(SerializationUtils.serialize(anAppraisalModel));

        valoracionDao.persist(myValoracion);

        final double myScore = (myCorrectAnswers * 100) / anAppraisalModel.getNumPreguntas();
        emailService.sendScoreMail(authenticationService.getUsuario(),
                myScore, 
                myExamen.getModulo().getNombre(), 
                myExamen.getModulo().getCurso().getNombre(),
                myCorrectAnswers, 
                anAppraisalModel.getNumPreguntas()
        );

        return myValoracion;
    }

    @Override
    public List<Valoracion> retrieveAnsweredExams(int usuarioId)
    {
        return valoracionDao.retrieveValoracionByUser(usuarioId);
    }
}
