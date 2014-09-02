package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.model.Curso;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModelForm;
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
     * Create new Content.
     *
     * @param aContentModelForm
     * @param aCourseId
     */
    void createContent(ContentModelForm aContentModelForm, Integer aCourseId);

    /**
     * @param aCourse
     * @return
     */
    List<Contenido> readContents(Curso aCourse);

    /**
     * @param aCourseId
     * @return
     */
    List<Contenido> readContents(Integer aCourseId);

    /**
     * Remove Content given an Id
     * @param aContent Content Id
     */
    void removeContent(Integer aContent);

    /**
     * Read Course from a content Id
     * @param aContentId
     * @return
     */
    Curso readCourseByContentId(Integer aContentId);
}
