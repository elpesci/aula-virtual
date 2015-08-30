<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-fliud">
    <div clas="row">

        <!-- Examen de evaluación -->
        <div class="col-sm-9">
            
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <i class="fa fa-list-alt pull-left"></i>
                        <spring:message code="testEngine.appraisal.heading.label" />
                        <c:out value="${exam.moduleName}"/> - (<c:out value="${exam.courseName}"/>) 
                    </h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <spring:message code="testEngine.appraisal.info1.label" arguments="${exam.numPreguntas};${exam.numRespuestasPregunta}" argumentSeparator=";"/>
                        </div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="col-sm-12">
                            <spring:message code="testEngine.appraisal.info2.label" />
                        </div>
                    </div>
                </div>
            </div>
            
            <h3><spring:message code="testEngine.addQuestionsAnswers.heading2.label"/></h3>

            <div class="well">
                <form:form method="POST" action="${target}" commandName="exam" cssClass="form-horizontal">
                    <form:hidden path="examenId" />
                    <form:hidden path="moduloId" />
                    <c:forEach items="${exam.preguntas}" var="pregunta">
                        <div class="panel panel-warning">
                            <div class="panel-heading">
                                <div class="panel-title clearfix">
                                    <i class="fa fa-question fa-2x pull-right"></i>
                                    <c:out value="${pregunta.textoPregunta}"/>
                                </div>
                            </div>
                            <div class="panel panel-body">
                            <c:forEach items="${pregunta.respuestas}" var="respuesta">
                                <div class="row">
                                    <div class="col-sm-1" style="padding-left:30px;">
                                        <input type="radio" class="alveolo" name="preguntaId_<c:out value="${pregunta.preguntaId}"/>" value="<c:out value="${respuesta.respuestaId}" />" />
                                    </div>
                                    <div class="col-sm-11" style="padding-left:0;">
                                        <label><c:out value="${respuesta.textoRespuesta}"/></label>
                                    </div>
                                </div>
                            </c:forEach>
                            </div>
                        </div>
                    </c:forEach>
                </form:form>
            </div>
            <div class="pull-right btn-group" role="group" aria-label="...">
                <button  type="submit" form="exam" class="btn btn-success" name="save" >
                    <i class="fa fa-share-square-o fa-fw"></i>
                    <spring:message javaScriptEscape="true" code="testEngine.appraisal.sendAnswers.cta.label"/>
                </button>
                <button class="btn btn-danger actionCancel" href="javascript:void(0);">
                    <i class="fa fa-ban fa-fw pull-left"></i>
                    <spring:message javaScriptEscape="true" code="cancel"/>
                </button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#menu_${course.cursoId}').addClass('active');
        
        $('.actionCancel').on('click', function () {
            window.location.replace('<c:url value="/cursos/detail"/>');
        });
    });
</script>