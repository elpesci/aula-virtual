package com.jcs.goboax.aulavirtual.ViewPreparer;

import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.service.api.CursoService;
import com.jcs.goboax.aulavirtual.viewmodel.CourseModel;
import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseMenuViewPreparer
    implements ViewPreparer
{
    private static final Logger LOG = LoggerFactory.getLogger(CourseMenuViewPreparer.class);

    @Autowired
    private CursoService cursoService;

    @Autowired
    private ConversionService conversionService;

    @Override
    public void execute(Request tilesContext, AttributeContext attributeContext)
    {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        List<Curso> myCursos = new ArrayList<Curso>();
        if (request.isUserInRole("SUPER_ADMIN"))
        {
            myCursos = cursoService.readCourses();
        }
        else
        {
            myCursos = cursoService.readCoursesEnable();
        }

        @SuppressWarnings("unchecked")
        List<CourseModel> myCourseModels = (List<CourseModel>) conversionService.convert(
                myCursos,
                TypeDescriptor.collection(List.class,
                        TypeDescriptor.valueOf(Curso.class)),
                TypeDescriptor.collection(List.class,
                        TypeDescriptor.valueOf(CourseModel.class)));
        attributeContext.putAttribute("courses", new Attribute(myCourseModels), true);
    }
}
