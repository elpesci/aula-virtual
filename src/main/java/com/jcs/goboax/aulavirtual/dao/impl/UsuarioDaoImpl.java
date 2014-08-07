/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcs.goboax.aulavirtual.dao.impl;

import org.springframework.stereotype.Repository;

import com.jcs.goboax.aulavirtual.dao.BaseDao;
import com.jcs.goboax.aulavirtual.dao.api.UsuarioDao;
import com.jcs.goboax.aulavirtual.model.Usuario;

/**
 *
 * @author julio
 */
@Repository
public class UsuarioDaoImpl 
    extends BaseDao<Integer, Usuario>
    implements UsuarioDao
{
    
}
