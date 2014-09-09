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

    /**
     *
     * @return
     */
    List<Curso> readCoursesEnable();

    /**
     *
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
     *
     * @param aCourseId
     */
    void disableCourse(Integer aCourseId);

    /**
     * Create new Content.
     *
     * @param aContentModelForm
     * @param aCourseId
     */
    void createContent(ContentModelForm aContentModelForm, Integer aCourseId);

    /**
     *
     * @param aContentModelForm
     */
    void updateContent(ContentModelForm aContentModelForm);

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
     * Read content by Id
     * @param aContentId
     * @return
     */
    Contenido readContentById(Integer aContentId);

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
