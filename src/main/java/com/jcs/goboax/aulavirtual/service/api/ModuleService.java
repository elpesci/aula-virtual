package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.viewmodel.ModuleModelForm;

import java.util.List;

public interface ModuleService
{

    void createModule(ModuleModelForm aModuleModelForm);

    List<Modulo> readModulesByCourse(Integer aCourseId);

    Modulo readModuleById(Integer aModuleId);

}
