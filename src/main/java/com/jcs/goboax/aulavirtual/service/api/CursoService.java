package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Curso;
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
     * @return
     */
    List<Curso> readCoursesEnable();

    /**
     * @param anId
     * @return
     */
    Curso readCourseById(Integer anId);

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
     * @param aCourseId
     */
    void disableCourse(Integer aCourseId);

    /**
     * Read Course from a content Id
     *
     * @param aContentId
     * @return
     */
    Curso readCourseByContentId(Integer aContentId);
}
