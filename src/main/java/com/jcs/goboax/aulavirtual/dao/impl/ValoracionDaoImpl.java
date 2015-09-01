package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.api.ValoracionDao;
import com.jcs.goboax.aulavirtual.model.Valoracion;
import com.jcs.goboax.aulavirtual.model.ValoracionPK;
import org.springframework.stereotype.Repository;

@Repository
public class ValoracionDaoImpl
    extends BaseDaoImpl<ValoracionPK, Valoracion>
    implements ValoracionDao
{
}
