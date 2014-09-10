package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.model.TipoContenido;
import com.jcs.goboax.aulavirtual.service.api.ContentService;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModelForm;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public class ContentServiceImpl
    implements ContentService
{
    @Transactional
    @Override
    public void createContent(ContentModelForm aContentModelForm, Integer aModuleId)
    {

//        Contenido myContenido = conversionService.convert(aContentModelForm, Contenido.class);
//        Curso myCurso = cursoDao.findByKey(aCourseId);
//        myContenido.setCurso(myCurso);
//        myContenido.setCreadoPor(authenticationService.getUsuario().getUsuarioId());
//        myContenido.setFechaCreacion(new Date());

        // TODO retrieve the correct tipo de contenido.
//        TipoContenido tipoContenido = tipoContenidoDao.findByKey(1);
//        myContenido.setTipoContenido(tipoContenido);

//        contenidoDao.persist(myContenido);
    }
}
