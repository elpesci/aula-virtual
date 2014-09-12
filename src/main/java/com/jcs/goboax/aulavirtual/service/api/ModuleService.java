package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Modulo;

import java.util.List;

public interface ModuleService
{

    List<Modulo> readModulesByCourse(Integer aCourseId);


}
