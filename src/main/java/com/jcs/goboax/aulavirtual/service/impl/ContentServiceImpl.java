package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.ContenidoDao;
import com.jcs.goboax.aulavirtual.dao.api.ModuloDao;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualPersistenceException;
import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.service.api.ContentService;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl
        implements ContentService
{
    @Autowired
    private ContenidoDao contenidoDao;

    @Autowired
    private ModuloDao moduloDao;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private AuthenticationService authenticationService;

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

    @Transactional
    @Override
    public void updateContent(ContentModelForm aContentModelForm)
    {
        Contenido myContenido = conversionService.convert(aContentModelForm, Contenido.class);
        myContenido.setModificadoPor(authenticationService.getUsuario().getUsuarioId());
        myContenido.setFechaModificacion(new Date());

        contenidoDao.update(myContenido);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contenido> readContentsByModule(Integer aModuleId)
    {
        Modulo myModulo = moduloDao.findByKey(aModuleId);
        if (myModulo == null)
        {
            throw new AulaVirtualPersistenceException("Module does not exists");
        }
        return readContentsByModule(myModulo);
    }

    @Override
    public Contenido readContentById(Integer aContentId)
    {
        return contenidoDao.findByKey(aContentId);
    }

    @Transactional
    @Override
    public void removeContent(Integer aContent)
    {
        contenidoDao.remove(aContent);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contenido> readContentsByModule(Modulo aModulo)
    {
        return contenidoDao.readContentsByModule(aModulo);
    }
}
