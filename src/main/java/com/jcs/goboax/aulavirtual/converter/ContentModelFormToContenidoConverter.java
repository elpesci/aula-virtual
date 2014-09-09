package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.dao.api.ContenidoDao;
import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class ContentModelFormToContenidoConverter
    implements Converter<ContentModelForm, Contenido>
{
    @Autowired
    private ContenidoDao contenidoDao;

    @Override
    public Contenido convert(ContentModelForm aContentModelForm)
    {
        Contenido myContenido = new Contenido();
        if (aContentModelForm.getId() != null)
        {
            myContenido = contenidoDao.findByKey(aContentModelForm.getId());
            myContenido.setNombre(aContentModelForm.getName());
        }
        else
        {
            myContenido.setArchivoMaterial(aContentModelForm.getContent().getBytes());
            myContenido.setNombre(aContentModelForm.getContent().getOriginalFilename());
            myContenido.setContentType(aContentModelForm.getContent().getContentType());
        }

        myContenido.setDescripcion(aContentModelForm.getDescription());
        return myContenido;
    }

}
