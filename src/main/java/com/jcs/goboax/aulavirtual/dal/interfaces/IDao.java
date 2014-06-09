/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcs.goboax.aulavirtual.dal.interfaces;

/**
 *
 * @author julio
 * @param <K>: Type to use as the Key
 * @param <E>: Type of the Entity
 */
public interface IDao<K, E> {
    void persist(E entity);
    void remove(E entity);
    E findByKey(K entityId);
}
