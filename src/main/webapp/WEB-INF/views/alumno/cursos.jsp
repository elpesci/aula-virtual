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
                    <div class="row">
                        <div class="col-xs-3 text-right">Dirigido a:</div>
                        <div class="col-xs-9">
                            <c:out value="${course.audiencia}"/>
                        </div>
                    </div>
                </div>
            </div>
            <!-- </div> -->
            <h3>Temario</h3>

            <div class="well">
                <c:forEach items="${course.modulos}" var="module">
                    <!-- Inicia Modulo -->
                    <div class="row">
                        <h3><c:out value="${module.nombre}"/></h3>

                        <div class="row">
                            <div class="col-xs-3 text-right">Objetivo General:</div>
                            <div class="col-xs-9">
                                <c:out value="${module.objetivoGeneral}"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-3 text-right">Objetivo Específico:</div>
                            <div class="col-xs-9">
                                <c:out value="${module.objetivoEspecifico}"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-3 text-right">Temas:</div>
                            <div class="col-xs-9">
                                <ol>
                                    <li>Tema 1</li>
                                    <li>Tema 2</li>
                                    <li>Tema 3</li>
                                </ol>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-3 text-right">Apoyos:</div>
                            <div class="col-xs-9">
                                <ul>
                                    <c:forEach var="content" items="${module.contenidos}">
                                        <c:url var="linkDownload"
                                               value="/modulo/content/download/${content.contenidoId}"/>
                                        <li><a href="${linkDownload}"
                                               title="Descargar archivo de apoyo">
                                            <i class="glyphicon glyphicon-cloud-download"></i>
                                            <c:out value="${content.nombre}"/>
                                        </a></li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <hr>
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