package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.api.RespuestaDao;
import com.jcs.goboax.aulavirtual.model.Respuesta;

import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RespuestaDaoImpl 
    extends BaseDaoImpl<Integer, Respuesta>
    implements RespuestaDao
{
    
}
