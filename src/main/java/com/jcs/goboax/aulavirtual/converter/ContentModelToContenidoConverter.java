package com.jcs.goboax.aulavirtual.converter;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.util.Constants;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModel;

public class ContentModelToContenidoConverter
    implements Converter<ContentModel, Contenido>
{

    @Override
    public Contenido convert(ContentModel aContentModel)
    {
        Contenido myContenido = new Contenido();
        myContenido.setCreadoPor(Constants.SUPER_USER_ID);
        myContenido.setArchivoMaterial(aContentModel.getContent().getBytes());
        myContenido.setNombre(aContentModel.getContent().getOriginalFilename());
//        myContenido.setDescripcion(aContentModel.getContent().getContentType());
        myContenido.setFechaCreacion(new Date());
        return myContenido;
    }

}
