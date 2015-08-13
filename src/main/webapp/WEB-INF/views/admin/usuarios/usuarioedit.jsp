<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="panel panel-warning">
    <div class="panel panel-heading">
        <h1><spring:message javaScriptEscape="true" code="registration.admin.header"/></h1>
    </div>
    <div class="panel panel-body">
        <p class="info">
            <spring:message javaScriptEscape="true" code="registration.admin.info"/>
        </p>
        
        <form:form method="POST" action="${target}" commandName="user" cssClass="form-horizontal">
            <div class="form-group">
                <form:label path="persona.nombre" cssClass="col-sm-4 control-label">
                    <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.name.label"/>
                </form:label>
                <div class="col-sm-8">
                    <form:input path="persona.nombre" cssClass="form-control" cssErrorClass="fieldError"/>
                    <span class="error"><form:errors path="persona.nombre"/></span>
                </div>
            </div>

            <div class="form-group">
                <form:label path="persona.apellidoPaterno" cssClass="col-sm-4 control-label">
                    <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.lastName.label"/>
                </form:label>
                <div class="col-sm-8">
                    <form:input path="persona.apellidoPaterno" cssClass="form-control" cssErrorClass="fieldError"/>
                    <span class="error"><form:errors path="persona.apellidoPaterno"/></span>
                </div>
            </div>

            <div class="form-group">
                <form:label path="persona.apellidoMaterno" cssClass="col-sm-4 control-label">
                    <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.secondLastName.label"/>
                </form:label>
                <div class="col-sm-8">
                    <form:input path="persona.apellidoMaterno" cssClass="form-control" cssErrorClass="fieldError"/>
                    <span class="error"><form:errors path="persona.apellidoMaterno"/></span>
                </div>
            </div>

            <div class="form-group">
                <form:label path="persona.correoElectronico" cssClass="col-sm-4 control-label">
                    <spring:message htmlEscape="true" javaScriptEscape="true" code="label.email"/>
                </form:label>
                <div class="col-sm-8">
                    <form:input path="persona.correoElectronico" cssClass="form-control" cssErrorClass="fieldError"/>
                    <span class="error"><form:errors path="persona.correoElectronico"/></span>
                </div>
            </div>

            <div class="form-group">
                <sec:authorize access="hasRole('SUPER_ADMIN')">
                    <form:label path="status" cssClass="col-sm-4 control-label">
                        <spring:message javaScriptEscape="true" code="label.profile"/>:
                        <span class="error"><form:errors path="profile"/></span>
                    </form:label>
                    <div class="col-sm-8">
                        <form:select path="status" cssClass="form-control" items="${profiles}"/>
                    </div>
                </sec:authorize>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-8">
                    <input type="submit" name="save" class="btn btn-primary"
                           value="<spring:message htmlEscape="true" javaScriptEscape="true" code="save"/>"/>
                    <sec:authorize access="hasRole('SUPER_ADMIN')">
                        <input type=button class="btn btn-danger" value="<spring:message htmlEscape="true" javaScriptEscape="true" code="cancel"/>"
                         onCLick="history.back()">
                    </sec:authorize>
                    <sec:authorize access="!hasRole('SUPER_ADMIN')">
                        <input type="submit" name="cancel" class="btn btn-danger"
                               value="<spring:message htmlEscape="true" javaScriptEscape="true" code="cancel"/>"/>
                    </sec:authorize>
                </div>
            </div>
        </form:form>
        
    </div>
</div>
