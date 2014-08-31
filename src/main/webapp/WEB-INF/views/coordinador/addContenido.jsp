<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="panel panel-warning">
    <div class="panel panel-heading">
        <h1><spring:message javaScriptEscape="true" code="content.add.heading.label"/> TODO: NombreDelCurso</h1>
    </div>
    <div class="panel panel-body">
        <p class="info">
            <spring:message javaScriptEscape="true" code="content.add.heading.info.label"/>
            <ul>
                <li>Tipo del archivo</li>
                <li>Nombre del archivo</li>
                <li>Archivo de contenito</li>
            </ul>
        </p>
        <form:form method="POST" commandName="contentModelForm" action="${target}" enctype="multipart/form-data" class="form-horizontal">
            <div class="form-group">
                <form:label path="contentTypeId" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="label.profile"/>:
                </form:label>
                <div class="col-sm-8">
                    <form:select path="contentTypeId" cssClass="form-control" items="${contentTypeNames}" cssErrorClass="form-control fieldError"/>
                    <span class="error"><form:errors path="contentTypeId"/></span>
                </div>
            </div>

            <div class="form-group">
                <c:if test="${action eq 'edit'}">
                    <form:label path="name" cssClass="col-sm-4 control-label">
                        <spring:message javaScriptEscape="true" code="content.name.label"/>
                    </form:label>
                    <div class="col-sm-8">
                        <form:input path="name" cssClass="form-control" cssErrorClass="fieldError"/>
                        <span class="error"><form:errors path="name"/></span>
                    </div>
                </c:if>
            </div>

            <div class="form-group">
                <form:label path="content" class="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="content.content.label"/>
                </form:label>
                <div class="col-sm-8">
                    <form:input path="content" type="file" accept=".doc" cssClass="form-control" cssErrorClass="fieldError"/>
                    <span class="error"><form:errors path="content"/></span>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-8">
                    <c:if test="${action eq 'add'}">
                        <input type="submit" name="save" class="btn btn-primary"
                               value="<spring:message javaScriptEscape="true" code="save"/>"/>
                    </c:if>
                    <c:if test="${action eq 'edit'}">
                        <input type="submit" name="save" class="btn btn-primary"
                               value="<spring:message javaScriptEscape="true" code="edit"/>"/>
                    </c:if>
                    <input type="submit" name="cancel" class="btn btn-danger"
                           value="<spring:message javaScriptEscape="true" code="cancel"/>"/>
                </div>
            </div>
        </form:form>
    </div>
</div>
