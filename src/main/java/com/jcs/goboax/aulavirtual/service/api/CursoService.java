package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModel;
import com.jcs.goboax.aulavirtual.viewmodel.CourseModel;

import java.util.List;

public interface CursoService
{
    /**
     * Retrieve all courses available.
     *
     * @return
     */
    List<Curso> readCourses();

    /**
     * Save a given course.
     *
     * @param aCourseModel
     */
    void createCourse(CourseModel aCourseModel);

    /**
     * Update Course.
     *
     * @param aCourseModel
     * @return
     */
    CourseModel updateCourse(CourseModel aCourseModel);

    /**
     * Create new Content.
     *
     * @param aContentModel
     * @param aCourseId
     */
    void createContent(ContentModel aContentModel, Integer aCourseId);
}
