package com.jcs.goboax.aulavirtual.viewmodel;

import com.jcs.goboax.aulavirtual.model.Pregunta;

import java.util.List;

public class AppraisalModel {
    
    private int examenId;
    private int moduloId;
    private int usuarioId;
    private int numPreguntas;
    private int numRespuestasPregunta;
    private List<Pregunta> preguntas;

    private String courseName;    
    private String moduleName;

    public int getExamenId() {
        return examenId;
    }

    public void setExamenId(int examenId) {
        this.examenId = examenId;
    }

    public int getModuloId() {
        return moduloId;
    }

    public void setModuloId(int moduloId) {
        this.moduloId = moduloId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getNumPreguntas() {
        return numPreguntas;
    }

    public void setNumPreguntas(int numPreguntas) {
        this.numPreguntas = numPreguntas;
    }

    public int getNumRespuestasPregunta() {
        return numRespuestasPregunta;
    }

    public void setNumRespuestasPregunta(int numRespuestasPregunta) {
        this.numRespuestasPregunta = numRespuestasPregunta;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
