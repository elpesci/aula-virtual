/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcs.goboax.aulavirtual.dal;

import com.jcs.goboax.aulavirtual.controller.LoginController;
import com.jcs.goboax.aulavirtual.dal.interfaces.IDao;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author julio
 * @param <K> Type to use as the key
 * @param <E> Type of the entity
 */
public abstract class BaseDao<K, E> implements IDao<K, E> {

    private final static Logger LOG = LoggerFactory.getLogger(BaseDao.class);
    
    protected Class<E> entityClass;
    
    @PersistenceContext
    protected EntityManager entityManager;

    public BaseDao() {
        ParameterizedType genericSuperclass;
        genericSuperclass = (ParameterizedType)getClass().getGenericSuperclass();
        
        this.entityClass = (Class<E>)genericSuperclass.getActualTypeArguments()[1];
    }
    
    /**
     *
     * @param entity
     */
    public void persist(E entity) {
        entityManager.persist(entity);
    }
    
    /**
     *
     * @param entity
     */
    public void remove(E entity) {
        entityManager.remove(entity);
    }
    
    /**
     *
     * @param entityId
     * @return Entity object
     */
    public E findByKey(K entityId) {
        return entityManager.find(entityClass, entityId);
    }
    
    /**
     * 
     * @param q Executable query
     * @return Entity object
     */
    public E getSingleResult(Query q) {
        try {
            return (E)q.getSingleResult();
        } catch (NoResultException noResult) {
            LOG.info("Ejecucion del query no produjo resultados.", q, noResult);
            return null;
        } catch (NonUniqueResultException multiResult) {
            LOG.info("Ejecucion del query produjo multiples resultados.", q, multiResult);
            return null;
        } catch (Exception exc) {
            LOG.error("Excepcion al ejecutar el query ", q, exc);
            return null;
        }
    }
}
