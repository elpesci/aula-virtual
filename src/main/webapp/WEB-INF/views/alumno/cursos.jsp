<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container-fliud">
    <div clas="row">

        <!-- Detalle de curso -->
        <div class="col-xs-9">
            <!-- <div class="thumbnail">-->
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <c:out value="${course.nombre}"/>
                    </h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-xs-3 text-right"><spring:message code="course.goal.label"/>:</div>
                        <div class="col-xs-9">${course.objetivo}</div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="col-xs-3 text-right"><spring:message code="course.addressedTo.label"/>:</div>
                        <div class="col-xs-9">
                            <c:out value="${course.audiencia}"/>
                        </div>
                    </div>
                </div>
            </div>
            <!-- </div> -->
            <h3><spring:message code="module.sylabus.label"/></h3>

            <div class="well">
                <c:forEach items="${course.modulos}" var="module">
                    <c:if test="${module.habilitado}">
                    <!-- Inicia Modulo -->
                    <div class="row">
                        <h3><c:out value="${module.nombre}"/></h3>

                        <div class="row">
                            <div class="col-xs-3 text-right"><spring:message code="module.goal.label"/>:</div>
                            <div class="col-xs-9">
                                <c:out value="${module.objetivoGeneral}"/>
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-xs-3 text-right"><spring:message code="module.specificGoal.label"/>:</div>
                            <div class="col-xs-9">
                                <c:out value="${module.objetivoEspecifico}"/>
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-xs-3 text-right"><spring:message code="module.sylabus.topics.label"/>:</div>
                            <div class="col-xs-9">
                                <div class="syllabus">
                                <c:out value="${module.temario}" escapeXml="false"/>
                                </div>
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-xs-3 text-right"><spring:message code="module.tasks.label"/>:</div>
                            <div class="col-xs-9">
                                <div class="tasks">
                                <c:out value="${module.tareas}" escapeXml="false"/>
                                </div>
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-xs-3 text-right"><spring:message code="module.supportItems.label"/>:</div>
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
                        <div class="row">
                            <div class="col-xs-3 text-right"><spring:message code="module.appraise.label"/>:</div>
                            <div class="col-xs-9">
                                <a href='<c:url value="/motorEval/evalModulo/"/><c:out value="${module.moduloId}"/>' class="btn btn-sm btn-warning cta" title="<spring:message code="module.appraise.cta.label"/>">
                                    <i class="fa fa-list-alt fa-2x pull-left"></i>
                                    <spring:message code="module.appraise.cta.label"/>
                                </a>
                            </div>
                        </div>
                        <br/>
                        </c:if>
                        <div class="row">
                            <div class="col-xs-3 text-right"><spring:message code="module.advice.label"/>:</div>
                            <div class="col-xs-9">
                                <div><spring:message code="module.advice.info.message.label"/></div>
                                <a href='mailto:${adviceEmailAddress}?subject=<c:out value="${emailSubject}"/>' class="btn btn-sm btn-warning cta" title="<spring:message code="module.advice.cta.label"/>">
                                    <i class="fa fa-envelope-o fa-2x pull-left"></i>
                                    <spring:message code="module.advice.cta.label"/>
                                </a>
                            </div>
                        </div>
                    </div>
                    <hr>
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