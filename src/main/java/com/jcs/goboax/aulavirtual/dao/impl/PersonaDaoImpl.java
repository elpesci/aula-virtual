package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.BaseDao;
import com.jcs.goboax.aulavirtual.dao.api.PersonaDao;
import com.jcs.goboax.aulavirtual.model.Persona;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaDaoImpl
    extends BaseDao<Integer, Persona>
    implements PersonaDao
{
}
