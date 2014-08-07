/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcs.goboax.aulavirtual.dao;

import com.jcs.goboax.aulavirtual.dao.api.IDao;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

    /** {@inheritDoc} */
    @Override
    public List<E> findWithNamedQuery(String queryName)
    {
        return entityManager.createNamedQuery(queryName, entityClass).
                getResultList();
    }

    /** {@inheritDoc} */
    @Override
    public List<E> findWithNamedQuery(String queryName, int resultLimit)
    {
        return entityManager.createNamedQuery(queryName, entityClass).
                setMaxResults(resultLimit).
                getResultList();
    }

    /** {@inheritDoc} */
    @Override
    public List<E> findWithNamedQuery(String namedQueryName, int start, int end)
    {
        TypedQuery<E> query = entityManager.createNamedQuery(namedQueryName, entityClass);
        query.setMaxResults(end - start);
        query.setFirstResult(start);
        return query.getResultList();
    }
}
