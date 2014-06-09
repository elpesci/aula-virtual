/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcs.goboax.aulavirtual.dal;

import com.jcs.goboax.aulavirtual.dal.interfaces.IDao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

/**
 *
 * @author julio
 * @param <K> Type to use as the key
 * @param <E> Type of the entity
 */
public abstract class BaseDao<K, E> implements IDao<K, E> {

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
}
