<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:hasBindErrors name="resetPasswordForm">
    <script>
        $(document).ready(function () {
            <c:forEach items="${errors.globalErrors}" var="errorMessage">
            	aulaVirtualController.addFlashMessage("<c:out value="${errorMessage.defaultMessage}" />");
            </c:forEach>
        });
    </script>
</spring:hasBindErrors>

<div class="panel panel-warning">
    <div class="panel panel-heading">
        <h1>¡Restablece tu contrase&ntilde;a para entrar a Aula Virtual!</h1>
    </div>
    <div class="panel panel-body">
        <p class="info">
            Por seguridad de tus datos, tu contrase&ntilde;a anterior ha sido inhabilitada. ¡No te preocupes! Aqu&iacute;
            puedes restablecer una nueva contrase&ntilde;a para seguir gozando los beneficios de Aula Virtual.
        </p>

        <p>
            Por favor, captura y confirma tu nueva contrase&ntilde;a.
        </p>
        <form:form method="post" action="${target}"
               commandName="resetPasswordForm" cssClass="form-horizontal">
        <form:hidden path="usuario.usuarioId" />
        <form:hidden path="usuario.password" />
        <form:hidden path="sendConfirmationEmail" />
        
        <div class="form-group">
            <form:label path="newPassword" cssClass="col-sm-4 control-label">
                <spring:message code="label.password"/>
            </form:label>
            <div class="col-sm-8">
                <form:password path="newPassword" autocomplete="off" cssClass="form-control" cssErrorClass="fieldError" />
                <div class="error"><form:errors path="newPassword"/></div>
            </div>
        </div>
        
        <div class="form-group">
            <form:label path="confirmNewPassword" cssClass="col-sm-4 control-label">
                <spring:message code="label.confirmPassword"/>
            </form:label>
            <div class="col-sm-8">
                <form:password path="confirmNewPassword" autocomplete="off" cssClass="form-control" cssErrorClass="fieldError" />
                <div class="error"><form:errors path="confirmNewPassword"/></div>
            </div>
        </div>
        
        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-8">
                <button type="submit" class="btn btn-primary" name="send"><spring:message code="send"/></button>
                <button type="submit" class="btn btn-danger" name="cancel"><spring:message code="cancel"/></button>
                <span class="clearfix"></span>
            </div>
        </div>
    </form:form>
    </div>
</div>
