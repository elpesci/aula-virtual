package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.api.RespuestaDao;
import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.model.Respuesta;

import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RespuestaDaoImpl 
    extends BaseDaoImpl<Integer, Respuesta>
    implements RespuestaDao
{

    @Override
    public Respuesta respuestaCorrectaByPregunta(Integer preguntaId)
    {
        TypedQuery<Respuesta> myQuery = entityManager.createNamedQuery(Respuesta.RESPUESTA_CORRECTA_BY_PREGUNTA,
                Respuesta.class);
        myQuery.setParameter(Respuesta.RESPUESTA_PREGUNTA_ID, preguntaId);

        return myQuery.getSingleResult();

    }
}
