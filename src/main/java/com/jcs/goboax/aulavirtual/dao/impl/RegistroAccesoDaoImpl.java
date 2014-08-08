/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.model.RegistroAcceso;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julio
 */
@Repository
public class RegistroAccesoDaoImpl extends BaseDaoImpl<Integer, RegistroAcceso>
{
    
    private final static Logger LOG = LoggerFactory.getLogger(BaseDaoImpl.class);
    
    public RegistroAcceso insertar(RegistroAcceso acceso){
        
        Integer accesoId = acceso.getRegistroAccesoId();
        if(accesoId != null) {
            RegistroAcceso entrada = this.findByKey(accesoId);

            if(entrada != null)
                return null;
        }

        this.persist(acceso);
        
        return acceso;
    }
    
    public RegistroAcceso actualizar(RegistroAcceso acceso){
        
        RegistroAcceso entradaActualizada;
        entradaActualizada = entityManager.merge(acceso);
        
        return entradaActualizada;
    }
    
    public RegistroAcceso getBySessionId(RegistroAcceso acceso){
        
        RegistroAcceso entrada;
        Query q = entityManager.createQuery(
                    "SELECT r FROM " + entityClass.getName() + " WHERE r.sessionId = :_sessionId");
        q.setParameter("_sessionId", acceso.getSessionId());
        
        entrada = this.getSingleResult(q);

        return entrada;
    }
}
