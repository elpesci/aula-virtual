/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcs.goboax.aulavirtual.dal;

import com.jcs.goboax.aulavirtual.model.Usuario;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julio
 */
@Repository
public class UsuarioDao extends BaseDao<Integer, Usuario> {
    
    public Usuario tryLogin(Usuario usr) {
        Query q;
        Usuario user;
        
        q = entityManager.createQuery(
                "SELECT e FROM " + entityClass.getName() + " e WHERE e.username = :_username AND e.password = :_password");
        q.setParameter("_username", usr.getUsername());
        q.setParameter("_password", usr.getPassword());
        
        user = this.getSingleResult(q);
        
        return user;
    }
}
