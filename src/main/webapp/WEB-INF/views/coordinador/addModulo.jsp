<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="panel panel-warning">
    <div class="panel-heading">
        <h3>
            <c:if test="${action eq 'add'}">
                <spring:message javaScriptEscape="true" code="module.add.heading.label"
                                arguments="${course.nombre}" />
            </c:if>
            <c:if test="${action eq 'edit'}">
                <spring:message javaScriptEscape="true" code="course.edit.heading.label"
                                arguments="${course.nombre}"/>
            </c:if>
        </h3>
    </div>
    <div class="panel-body">
        <p class="info">
            <spring:message javaScriptEscape="true" code="module.add.heading.info.label"/>
        </p>

        <p class="info">
            <spring:message javaScriptEscape="true" code="module.add.heading.info.row2.label"/>
        </p>
        <form:form method="POST" action="${target}" commandName="moduleModelForm" cssClass="form-horizontal">
            <form:hidden path="id"/>
            <form:hidden path="courseId"/>
            <div class="form-group">
                <form:label path="name" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="module.name.label"/>:
                </form:label>
                <div class="col-sm-8">
                    <form:input path="name" cssClass="form-control" cssErrorClass="fieldError"/>
                    <span class="error"><form:errors path="name"/></span>
                </div>
            </div>

            <div class="form-group">
                <form:label path="generalGoal" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="module.goal.label"/>:
                </form:label>
                <div class="col-sm-8">
                    <form:textarea path="generalGoal" cssClass="form-control" cssErrorClass="form-control fieldError"/>
                    <span class="error"><form:errors path="generalGoal"/></span>
                </div>
            </div>

            <div class="form-group">
                <form:label path="specificGoal" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="module.specificGoal.label"/>:
                </form:label>
                <div class="col-sm-8">
                    <form:textarea path="specificGoal" cssClass="form-control" cssErrorClass="form-control fieldError"/>
                    <span class="error"><form:errors path="specificGoal"/></span>
                </div>
            </div>

            <div class="form-group">
                <form:label path="sylabus" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="module.sylabus.label"/>:
                </form:label>
                <div class="col-sm-8">
                    <form:textarea path="sylabus" cssClass="form-control" cssErrorClass="form-control fieldError"/>
                    <span class="error"><form:errors path="sylabus"/></span>
                </div>
            </div>

            <div class="form-group">
                <form:label path="active" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="course.active.label"/>:
                </form:label>
                <div class="col-sm-8">
                    <form:checkbox path="active" cssClass="form-control" cssErrorClass="fieldError"/>
                    <span class="error"><form:errors path="active"/></span>
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
