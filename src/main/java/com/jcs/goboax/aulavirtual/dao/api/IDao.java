/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcs.goboax.aulavirtual.dao.api;

import javax.persistence.Query;
import java.util.List;

/**
 * @param <K>: Type to use as the Key
 * @param <E>: Type of the Entity
 * @author julio
 */
public interface IDao<K, E>
{
    void persist(E entity);

    void remove(E entity);

    E findByKey(K entityId);

    E getSingleResult(Query q);

    E update(E anEntity);

    /**
     * Returns the number of records with result limit
     *
     * @param queryName
     * @return List
     */
    public List<E> findWithNamedQuery(String queryName);

    /**
     * Returns the number of records with result limit
     *
     * @param queryName
     * @param resultLimit
     * @return List
     */
    public List<E> findWithNamedQuery(String queryName, int resultLimit);

    /**
     * Returns the number of records that will be used with lazy loading / pagination
     *
     * @param namedQueryName
     * @param start
     * @param end
     * @return List
     */
    List<E> findWithNamedQuery(String namedQueryName, int start, int end);
}
