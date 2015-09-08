<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-fliud">
    <div clas="row">

        <!-- Detalle de curso -->
        <div class="col-xs-9">
            <!-- <div class="thumbnail">-->
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title course-title">
                        <i class="fa fa-book"></i>
                        <c:out value="${course.nombre}"/>
                    </h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-xs-3 text-right">
                            <label><spring:message code="course.goal.label"/>:</label>
                        </div>
                        <div class="col-xs-9">${course.objetivo}</div>
                    </div>
                    <br/>

                    <div class="row">
                        <div class="col-xs-3 text-right">
                            <label><spring:message code="course.addressedTo.label"/>:</label>
                        </div>
                        <div class="col-xs-9">
                            <c:out value="${course.audiencia}"/>
                        </div>
                    </div>
                </div>
            </div>
            <!-- </div> -->
            <h3 class="syllabus-title"><spring:message code="module.sylabus.label"/></h3>

            <div id="accordion" class="panel-group">
                <c:forEach items="${course.modulos}" var="module">
                    <c:if test="${module.habilitado}">
                        <!-- Inicia Modulo -->                        
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <a href="#collapse_<c:out value="${module.moduloId}"/>" data-toggle="collapse" data-parent="#accordion">
                                    <c:out value="${module.nombre}"/>
                                    </a>
                                </h3>
                            </div>
                            <div id="collapse_<c:out value="${module.moduloId}"/>" class="panel-collapse collapse">
                            <div class="panel-body bg-warning">
                                <div class="row">
                                    <div class="col-xs-3 text-right">
                                        <label><spring:message code="module.goal.label"/>:</label>
                                    </div>
                                    <div class="col-xs-9">
                                        <c:out value="${module.objetivoGeneral}"/>
                                    </div>
                                </div>
                                <br/>

                                <div class="row">
                                    <div class="col-xs-3 text-right">
                                        <label><spring:message code="module.specificGoal.label"/>:</label>
                                    </div>
                                    <div class="col-xs-9">
                                        <c:out value="${module.objetivoEspecifico}"/>
                                    </div>
                                </div>
                                <br/>

                                <div class="row">
                                    <div class="col-xs-3 text-right">
                                        <label><spring:message code="module.sylabus.topics.label"/>:</label>
                                    </div>
                                    <div class="col-xs-9">
                                        <div class="syllabus">
                                            <c:out value="${module.temario}" escapeXml="false"/>
                                        </div>
                                    </div>
                                </div>
                                <br/>

                                <div class="row">
                                    <div class="col-xs-3 text-right">
                                        <label><spring:message code="module.tasks.label"/>:</label>
                                    </div>
                                    <div class="col-xs-9">
                                        <div class="tasks">
                                            <c:out value="${module.tareas}" escapeXml="false"/>
                                        </div>
                                    </div>
                                </div>
                                <br/>

                                <div class="row">
                                    <div class="col-xs-3 text-right">
                                        <label><spring:message code="module.supportItems.label"/>:</label>
                                    </div>
                                    <div class="col-xs-9">
                                        <ul class="temario">
                                            <c:forEach var="content" items="${module.contenidos}">
                                                <c:url var="linkDownload"
                                                       value="/modulo/content/download/${content.contenidoId}"/>
                                                <li><a href="${linkDownload}"
                                                       title="Descargar archivo de apoyo">
                                                    <i class="glyphicon glyphicon-cloud-download"></i>
                                                    <c:out value="${content.descripcion}"/>
                                                </a>
                                                    &nbsp;
                                                    (<c:out value="${content.nombre}"/>)
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                                <br/>
                                <c:if test="${not empty module.examen}">
                                    <c:set var="score" scope="request" value=""/>
                                    <c:forEach var="answered" items="${answeredExams}">
                                        <c:if test="${answered.id.examenId eq module.examen.examenId}">
                                            <fmt:formatNumber var="scoreFull" type="number" maxFractionDigits="1"
                                                              value="${answered.preguntasCorrectas * 100 / answered.preguntasExamen}"/>
                                            <c:set var="score" scope="request"
                                                   value="${scoreFull}"/>
                                        </c:if>
                                    </c:forEach>
                                    <div class="row">
                                        <div class="col-xs-3 text-right">
                                            <label><spring:message code="module.appraise.label"/>:</label>
                                        </div>
                                        <div class="col-xs-9">
                                            <c:if test="${not empty score}">
                                                <strong><c:out value="${score}"/></strong>
                                            </c:if>
                                            <c:if test="${empty score}">
                                                <a href='<c:url value="/motorEval/evalModulo/"/><c:out value="${module.moduloId}"/>'
                                                   class="btn btn-sm btn-warning cta"
                                                   title="<spring:message code="module.appraise.cta.label"/>">
                                                    <i class="fa fa-list-alt fa-2x pull-left"></i>
                                                    <spring:message code="module.appraise.cta.label"/>
                                                </a>
                                            </c:if>
                                        </div>
                                    </div>
                                    <br/>
                                </c:if>
                                <div class="row">
                                    <div class="col-xs-3 text-right">
                                        <label><spring:message code="module.advice.label"/>:</label>
                                    </div>
                                    <div class="col-xs-9">
                                        <div><spring:message code="module.advice.info.message.label"/></div>
                                        <a href='mailto:${adviceEmailAddress}?subject=<c:out value="${emailSubject}"/>'
                                           class="btn btn-sm btn-warning cta"
                                           title="<spring:message code="module.advice.cta.label"/>">
                                            <i class="fa fa-envelope-o fa-2x pull-left"></i>
                                            <spring:message code="module.advice.cta.label"/>
                                        </a>
                                    </div>
                                </div>
                                <br />
                                <div class="row">
                                    <div class="col-xs-3 text-right">
                                        <label><spring:message code="module.send.tasks.files.label"/>:</label>
                                    </div>
                                    <div class="col-xs-9">
                                        <div><spring:message code="module.send.tasks.files.message.label"/></div>
                                        <a href='mailto:${adviceEmailAddress}?subject=<c:out value="${sendDeliverablesSubject}"/>'
                                           class="btn btn-sm btn-warning cta"
                                           title="<spring:message code="module.send.tasks.files.cta.label"/>">
                                            <i class="fa fa-paperclip fa-2x pull-left"></i>
                                            <spring:message code="module.send.tasks.files.cta.label"/>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#menu_${course.cursoId}').addClass('active');
    });
</script>
