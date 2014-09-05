<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="panel panel-warning">
    <div class="panel panel-heading">
        <h3><spring:message javaScriptEscape="true" code="content.add.heading.label" arguments="${course.nombre}"/></h3>
    </div>
    <div class="panel panel-body">
        <div class="row">
            <div class="col-xs-6">
                <p class="info left">
                <spring:message javaScriptEscape="true" code="content.add.heading.info.label"/>
                <ul>
                    <li>Nombre del archivo</li>
                    <li>Archivo de contenido</li>
                    <li>Descripción del contenido</li>
                </ul>
                </p>
            </div>
            <div class="col-xs-6">
                <p class="right">
                    <spring:message javaScriptEscape="true" code="content.common.allowed.types.label" />:
                    <ul>
                        <c:forEach var="contentTypeName" items="${contentTypeNames}">
                            <li>${contentTypeName}</li>
                        </c:forEach>
                    </ul>
                </p>                                   
            </div>
        </div>

        <form:form method="POST" commandName="contentModelForm" action="${target}" enctype="multipart/form-data" class="form-horizontal">
            <form:hidden path="id"/>
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
                <form:label path="description" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="content.description"/>
                </form:label>
                <div class="col-sm-8">
                    <form:input path="description" cssClass="form-control" cssErrorClass="fieldError"/>
                    <span class="error"><form:errors path="description"/></span>
                </div>
            </div>

            <c:if test="${action eq 'add'}">
                <div class="form-group">
                    <form:label path="content" class="col-sm-4 control-label">
                        <spring:message javaScriptEscape="true" code="content.content.label"/>
                    </form:label>
                    <div class="col-sm-8">
                        <form:input path="content" type="file" accept="${extensionContenido}" cssClass="form-control" cssErrorClass="fieldError"/>
                        <span class="error"><form:errors path="content"/></span>
                    </div>
                </div>
            </c:if>

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
