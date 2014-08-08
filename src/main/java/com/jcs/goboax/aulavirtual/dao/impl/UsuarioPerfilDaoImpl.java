package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.api.UsuarioPerfilDao;
import com.jcs.goboax.aulavirtual.model.UsuarioPerfil;
import com.jcs.goboax.aulavirtual.model.UsuarioPerfilPK;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioPerfilDaoImpl
    extends BaseDaoImpl<UsuarioPerfilPK, UsuarioPerfil>
    implements UsuarioPerfilDao
{
}
