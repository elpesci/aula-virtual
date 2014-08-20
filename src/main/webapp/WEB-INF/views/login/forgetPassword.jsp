<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="panel panel-warning">
    <div class="panel panel-heading">
        <h1>¡Recupera tu contrase&ntilde;a para entrar a Aula Virtual!</h1>
    </div>
    <div class="panel panel-body">
        <p class="info">
            ¿Olvidaste tu contrase&ntilde;a para entrar a Aula Virtual? ¡No te preocupes! Aqu&iacute;
            puedes restablecer una nueva contrase&ntilde;a para seguir gozando los beneficios de Aula Virtual.
        </p>

        <p>
            Por favor, captura tu correo electr&oacute;nico. A esa direcci&oacute;n te enviaremos una direcci&oacute;n
            en donde podr&aacute;s entrar y establecer una nueva contrase&ntilde;a.
        </p>
        <form:form method="POST" action="${target}" commandName="forgetPasswordForm" cssClass="form-horizontal">
            <div class="form-group">
                <form:label path="email" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="label.email"/>
                </form:label>
                <div class="col-sm-8">
                    <form:input path="email" cssClass="form-control" cssErrorClass="fieldError" size="45"/>
                    <span class="error"><form:errors path="email"/></span>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-8">
                    <input type="submit" name="save" class="btn btn-primary"
                           value="<spring:message htmlEscape="true" javaScriptEscape="true" code="send"/>"/>
                    <input type="submit" name="cancel" class="btn btn-danger"
                           value="<spring:message htmlEscape="true" javaScriptEscape="true" code="cancel"/>"/>
                </div>
            </div>

        </form:form>
    </div>
</div>