/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcs.goboax.aulavirtual.bll;

import com.jcs.goboax.aulavirtual.dao.impl.RegistroAccesoDaoImpl;
import com.jcs.goboax.aulavirtual.dao.impl.UsuarioDaoImpl;
import com.jcs.goboax.aulavirtual.model.RegistroAcceso;
import com.jcs.goboax.aulavirtual.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julio
 */
@Service
public class Authenticate {
    
    @Autowired
    private UsuarioDaoImpl usuarioDao;
    
    @Autowired
    private RegistroAccesoDaoImpl registroAccesoDao;
    
    public Usuario Login(Usuario user, RegistroAcceso acceso) {
        Usuario usr = usuarioDao.tryLogin(user);
        
        if(usr != null) {
            acceso.setUsuarioId(usr);
            registroAccesoDao.insertar(acceso);
        }
        
        return usr;
    }
}
