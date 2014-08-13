package com.jcs.goboax.aulavirtual.dao.api;

import com.jcs.goboax.aulavirtual.model.Usuario;

/**
 * Created by acardenas on 8/4/14.
 */
public interface UsuarioDao
    extends IDao<Integer, Usuario>
{
    Usuario findByEmail(String anEmail);

    Usuario getByCredentials(Integer aUserId, String aPassword);
    
}
