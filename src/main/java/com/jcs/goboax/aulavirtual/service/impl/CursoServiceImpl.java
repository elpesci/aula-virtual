package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.ContenidoDao;
import com.jcs.goboax.aulavirtual.dao.api.CursoDao;
import com.jcs.goboax.aulavirtual.dao.api.TipoContenidoDao;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualPersistenceException;
import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.model.TipoContenido;
import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.service.api.CursoService;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModelForm;
import com.jcs.goboax.aulavirtual.viewmodel.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CursoServiceImpl
        implements CursoService
{
    @Autowired
    private CursoDao cursoDao;

    @Autowired
    private ContenidoDao contenidoDao;

    @Autowired
    private TipoContenidoDao tipoContenidoDao;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private AuthenticationService authenticationService;

    @Transactional(readOnly = true)
    @Override
    public List<Curso> readCourses()
    {
        return cursoDao.findWithNamedQuery(Curso.CURSO_ALL_QUERYNAME);
    }

    @Transactional(readOnly = true)
    @Override
    public Curso readCourseById(Integer anId)
    {
        return cursoDao.findByKey(anId);
    }

    @Transactional
    @Override
    public void createCourse(CourseModel aCourseModel)
    {
        Curso myCurso = conversionService.convert(aCourseModel, Curso.class);
        myCurso.setFechaCreacion(new Date());
        myCurso.setCreadoPor(authenticationService.getUsuario().getUsuarioId());
        cursoDao.persist(myCurso);
    }

    @Transactional
    @Override
    public CourseModel updateCourse(CourseModel aCourseModel)
    {
        Curso myCurso = conversionService.convert(aCourseModel, Curso.class);
        myCurso.setFechaModificacion(new Date());
        myCurso.setModificadoPor(authenticationService.getUsuario().getUsuarioId());
        cursoDao.update(myCurso);
        return aCourseModel;
    }

    @Transactional
    @Override
    public void createContent(ContentModelForm aContentModelForm, Integer aCourseId)
    {

        Contenido myContenido = conversionService.convert(aContentModelForm, Contenido.class);
        Curso myCurso = cursoDao.findByKey(aCourseId);
        myContenido.setCurso(myCurso);

        TipoContenido tipoContenido = tipoContenidoDao.findByKey(1);
        myContenido.setTipoContenido(tipoContenido);

        contenidoDao.persist(myContenido);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contenido> readContents(Integer aCourseId)
    {
        Curso myCurso = cursoDao.findByKey(aCourseId);
        if (myCurso == null)
        {
            throw new AulaVirtualPersistenceException("Course does not exists");
        }
        return readContents(myCurso);
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
    public Curso readCourseByContentId(Integer aContentId)
    {
        Contenido myContenido = contenidoDao.findByKey(aContentId);
        return myContenido.getCurso();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contenido> readContents(Curso aCourse)
    {

        return contenidoDao.readContentsByCourse(aCourse);
    }
}
