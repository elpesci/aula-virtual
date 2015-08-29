package com.jcs.goboax.aulavirtual.dao.api;

import com.jcs.goboax.aulavirtual.model.Examen;
import com.jcs.goboax.aulavirtual.model.Modulo;
import java.util.List;

public interface ExamenDao
    extends IDao<Integer, Examen>
{
    Examen readByModule(Modulo aModule);
}
