<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="panel panel-warning">
    <div class="panel-heading">
        <h3>
            <i class="fa fa-cogs fa-lg"></i>
            <spring:message javaScriptEscape="true" code="testEngine.addQuestionsAnswers.heading.label" />
        </h3>
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-sm-11 well well-sm centre">
                <span class="row">
                    <spring:message javaScriptEscape="true" code="testEngine.addQuestionsAnswers.info.label" />:
                </span>
                <span class="row">
                    <strong><spring:message javaScriptEscape="true" code="course.course.label" />: </strong>
                    ${exam.modulo.curso.nombre}
                </span>
                <span class="row">
                    <strong><spring:message javaScriptEscape="true" code="module.name.label" />: </strong>
                    ${exam.modulo.nombre}
                </span>
            </div>
        </div>
        <div class="row">
            <form:form method="POST" commandName="exam" action="${target}" class="form-horizontal">
                <form:hidden path="examenId" />
                <form:hidden path="modulo.moduloId" />
                <form:hidden path="numPreguntas" />
                <form:hidden path="numRespuestasPregunta" />
            </form:form>
        </div>
    </div>
</div>

