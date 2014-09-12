package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.viewmodel.ModuleModelForm;
import org.springframework.core.convert.converter.Converter;

public class ModuloToModuleModelFormConverter
    implements Converter<Modulo, ModuleModelForm>
{
    @Override
    public ModuleModelForm convert(Modulo aModulo)
    {
        ModuleModelForm myModuleModelForm = new ModuleModelForm();
        myModuleModelForm.setId(aModulo.getModuloId());
        myModuleModelForm.setName(aModulo.getNombre());
        myModuleModelForm.setGeneralGoal(aModulo.getObjetivoGeneral());
        myModuleModelForm.setSpecificGoal(aModulo.getObjetivoEspecifico());
        myModuleModelForm.setSylabus(aModulo.getTemario());

        return myModuleModelForm;
    }
}
