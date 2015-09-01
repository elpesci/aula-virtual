package com.jcs.goboax.aulavirtual.dao.api;

import com.jcs.goboax.aulavirtual.model.Valoracion;
import com.jcs.goboax.aulavirtual.model.ValoracionPK;

import java.util.List;

public interface ValoracionDao
    extends IDao<ValoracionPK, Valoracion>
{
    List<Valoracion> retrieveValoracionByUser(Integer aUserId);
}
