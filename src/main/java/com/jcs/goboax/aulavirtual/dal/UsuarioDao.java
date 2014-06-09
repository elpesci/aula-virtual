/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcs.goboax.aulavirtual.dal;

import com.jcs.goboax.aulavirtual.model.Usuario;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author julio
 */
@Service
public class UsuarioDao extends BaseDao<Integer, Usuario> {
    
    public Usuario tryLogin(String username, String password) {
        Query q;
        Usuario user;
        
        q = entityManager.createQuery(
                "SELECT e FROM " + entityClass.getName() + " e WHERE e.username = :_username AND e.password = :_password");
        q.setParameter("_username", username);
        q.setParameter("_password", password);
        
        user = (Usuario)q.getSingleResult();
        
        return user;
    }
}
