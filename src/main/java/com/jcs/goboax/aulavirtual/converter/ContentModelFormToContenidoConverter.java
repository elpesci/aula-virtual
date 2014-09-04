package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.util.Constants;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModelForm;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

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
        myContenido.setDescripcion(aContentModelForm.getDescription());
        myContenido.setFechaCreacion(new Date());
        return myContenido;
    }

}
