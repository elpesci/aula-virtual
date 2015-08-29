package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.api.ExamenDao;
import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.model.Pregunta;
import com.jcs.goboax.aulavirtual.model.Respuesta;

import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ExamenDaoImpl
    extends BaseDaoImpl<Integer, Examen>
    implements ExamenDao
{
    @Override
    public Examen readByModule(Modulo aModule) {
        
        TypedQuery<Examen> myQuery = entityManager.createNamedQuery(
                Examen.EXAMEN_BY_MODULO_QUERYNAME, Examen.class);
        myQuery.setParameter(Examen.EXAMEN_MODULE_PARAMETER, aModule);
        
        return myQuery.getSingleResult();
    }
    
}
