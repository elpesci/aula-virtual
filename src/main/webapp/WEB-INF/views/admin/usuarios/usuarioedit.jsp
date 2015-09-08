<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="panel panel-warning">
    <div class="panel panel-heading">
        <h1><spring:message javaScriptEscape="true" code="usuario.update.header"/></h1>
    </div>
    <div class="panel panel-body">
        <p class="info">
            <spring:message javaScriptEscape="true" code="usuario.update.info"/>
        </p>

        <form:form method="POST" action="/usuario/edit" commandName="usuarioUpdateModel" cssClass="form-horizontal">
            <div class="form-group">
                <form:label path="email" cssClass="col-sm-4 control-label">
                    <spring:message htmlEscape="true" javaScriptEscape="true" code="label.email"/>
                </form:label>
                <div class="col-sm-8">
                    <form:label path="email" cssClass="form-control-static">
                        <c:out value="${usuarioUpdateModel.email}" />
                    </form:label>
                    <form:hidden readonly="true" path="email" cssClass="form-control" cssErrorClass="fieldError"/>
                    <span class="error"><form:errors path="email"/></span>
                </div>
            </div>

            <div class="form-group">
                <form:label path="name" cssClass="col-sm-4 control-label">
                    <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.name.label"/>
                </form:label>
                <div class="col-sm-8">
                    <form:input path="name" cssClass="form-control" cssErrorClass="fieldError"/>
                    <span class="error"><form:errors path="name"/></span>
                </div>
            </div>

            <div class="form-group">
                <form:label path="lastName" cssClass="col-sm-4 control-label">
                    <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.lastName.label"/>
                </form:label>
                <div class="col-sm-8">
                    <form:input path="lastName" cssClass="form-control" cssErrorClass="fieldError"/>
                    <span class="error"><form:errors path="lastName"/></span>
                </div>
            </div>

            <div class="form-group">
                <form:label path="secondLastName" cssClass="col-sm-4 control-label">
                    <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.secondLastName.label"/>
                </form:label>
                <div class="col-sm-8">
                    <form:input path="secondLastName" cssClass="form-control" cssErrorClass="fieldError"/>
                    <span class="error"><form:errors path="secondLastName"/></span>
                </div>
            </div>

            <div class="form-group">
                <sec:authorize access="hasRole('SUPER_ADMIN')">
                    <form:label path="profile" cssClass="col-sm-4 control-label">
                        <spring:message javaScriptEscape="true" code="label.profile"/>:
                        <span class="error"><form:errors path="profile"/></span>
                    </form:label>
                    <div class="col-sm-8">
                        <form:select path="profile" cssClass="form-control">
                            <form:options items="${profiles}"/>
                        </form:select>
                    </div>
                </sec:authorize>
            </div>
                
            <sec:authorize access="hasRole('SUPER_ADMIN')">
                <div class="form-group">
                    <form:label path="habilitado" cssClass="col-sm-4 control-label">
                        <spring:message code="usuario.habilitado.label" />:
                        <span class="error"><form:errors path="habilitado"/></span>
                    </form:label>
                    <div class="col-sm-8">
                        <form:checkbox path="habilitado" />
                        <label for="habilitado" style="display: inline; font-weight: normal;">
                            <spring:message code="usuario.habilitado.help.label"/>
                        </label>
                    </div>
                </div>
            </sec:authorize>

            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-8">
                    <input type="submit" name="save" class="btn btn-primary"
                           value="<spring:message htmlEscape="true" javaScriptEscape="true" code="save"/>"/>
                    <sec:authorize access="hasRole('SUPER_ADMIN')">
                        <input type=button class="btn btn-danger"
                               value="<spring:message htmlEscape="true" javaScriptEscape="true" code="cancel"/>"
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
