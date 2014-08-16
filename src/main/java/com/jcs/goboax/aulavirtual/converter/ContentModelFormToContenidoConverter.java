package com.jcs.goboax.aulavirtual.converter;

import java.util.Date;

import com.jcs.goboax.aulavirtual.viewmodel.ContentModelForm;
import org.springframework.core.convert.converter.Converter;

import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.util.Constants;

public class ContentModelFormToContenidoConverter
    implements Converter<ContentModelForm, Contenido>
{

    @Override
    public Contenido convert(ContentModelForm aContentModelForm)
    {
        Contenido myContenido = new Contenido();
        myContenido.setCreadoPor(Constants.SUPER_USER_ID);
        myContenido.setArchivoMaterial(aContentModelForm.getContent().getBytes());
        myContenido.setNombre(aContentModelForm.getContent().getOriginalFilename());
        myContenido.setContentType(aContentModelForm.getContent().getContentType());
        myContenido.setFechaCreacion(new Date());
        return myContenido;
    }

}
