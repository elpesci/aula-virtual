package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.ContenidoDao;
import com.jcs.goboax.aulavirtual.dao.api.CursoDao;
import com.jcs.goboax.aulavirtual.dao.api.TipoContenidoDao;
import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.model.TipoContenido;
import com.jcs.goboax.aulavirtual.service.api.CursoService;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModel;
import com.jcs.goboax.aulavirtual.viewmodel.CourseModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    @Override
    public List<Curso> readCourses()
    {
        return cursoDao.findWithNamedQuery(Curso.CURSO_ALL_QUERYNAME);
    }

    @Transactional
    @Override
    public void createCourse(CourseModel aCourseModel)
    {
        Curso myCurso = conversionService.convert(aCourseModel, Curso.class);
        cursoDao.persist(myCurso);
    }

    @Transactional
    @Override
    public CourseModel updateCourse(CourseModel aCourseModel)
    {
        Curso myCurso = conversionService.convert(aCourseModel, Curso.class);
        cursoDao.persist(myCurso);
        return aCourseModel;
    }

    @Transactional
    @Override
    public void createContent(ContentModel aContentModel, Integer aCourseId)
    {
        
        Contenido myContenido = conversionService.convert(aContentModel, Contenido.class);
        Curso myCurso = cursoDao.findByKey(aCourseId);
        myContenido.setCurso(myCurso);
        
        TipoContenido tipoContenido = tipoContenidoDao.findByKey(1);
        myContenido.setTipoContenido(tipoContenido);
        
        contenidoDao.persist(myContenido);
    }
}
