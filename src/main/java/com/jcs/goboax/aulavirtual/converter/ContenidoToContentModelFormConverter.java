package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModelForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ContenidoToContentModelFormConverter
    implements Converter<Contenido, ContentModelForm>
{

    @Override
    public ContentModelForm convert(Contenido aContenido)
    {
        ContentModelForm myContentModelForm = new ContentModelForm();
        myContentModelForm.setName(aContenido.getNombre());

        return myContentModelForm;
    }
}
