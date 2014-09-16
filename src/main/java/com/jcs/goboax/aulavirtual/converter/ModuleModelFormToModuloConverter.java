package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.dao.api.CursoDao;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.viewmodel.ModuleModelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class ModuleModelFormToModuloConverter
        implements Converter<ModuleModelForm, Modulo>
{
    @Autowired
    CursoDao cursoDao;

    @Override
    public Modulo convert(ModuleModelForm aModuleModelForm)
    {
        Modulo myModulo = new Modulo();
        myModulo.setNombre(aModuleModelForm.getName());
        myModulo.setObjetivoGeneral(aModuleModelForm.getGeneralGoal());
        myModulo.setObjetivoEspecifico(aModuleModelForm.getSpecificGoal());
        myModulo.setTemario(aModuleModelForm.getSylabus());

        Curso myCurso = cursoDao.findByKey(aModuleModelForm.getCourseId());
        myModulo.setCurso(myCurso);

        return myModulo;
    }
}
