package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModel;
import org.springframework.core.convert.converter.Converter;

public class ContenidoToContentModelConverter
    implements Converter<Contenido, ContentModel>
{
    @Override
    public ContentModel convert(Contenido aContenido)
    {
        ContentModel myContentModel = new ContentModel();
        myContentModel.setId(aContenido.getContenidoId());
        myContentModel.setName(aContenido.getNombre());
        return myContentModel;
    }
}
