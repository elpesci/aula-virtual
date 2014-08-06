package com.jcs.goboax.aulavirtual.dao.impl;

import org.springframework.stereotype.Repository;

import com.jcs.goboax.aulavirtual.dao.BaseDao;
import com.jcs.goboax.aulavirtual.dao.api.PerfilDao;
import com.jcs.goboax.aulavirtual.model.Perfil;

@Repository
public class PerfilDaoImpl
        extends BaseDao<Integer, Perfil>
        implements PerfilDao
{

}
