/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcs.goboax.aulavirtual.bll;

import com.jcs.goboax.aulavirtual.dal.UsuarioDao;
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
    private UsuarioDao usuarioDao;
    
    public Usuario Login(Usuario user) {
        return usuarioDao.tryLogin(user);
    }
}
