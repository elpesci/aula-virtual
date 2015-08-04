<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="panel panel-warning">
    <div class="panel-heading">
        <h3>
            <i class="fa fa-cogs fa-lg"></i>
              Agregar Preguntas y Respuestas
        </h3>
    </div>
    <div class="panel-body">
        Preguntas y respuestas Placeholder....
        <div class="row">
            <form:form method="POST" commandName="exam" action="${target}" class="form-horizontal">
                <form:hidden path="exam.examenId" />
                <form:hidden path="exam.modulo.moduloId" />
                <form:hidden path="exam.numPreguntas" />
                <form:hidden path="exam.numRespuestasPregunta" />
                    
            </form:form>
        </div>
    </div>
</div>

