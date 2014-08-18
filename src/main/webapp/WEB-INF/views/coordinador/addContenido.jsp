<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="registration_form">
    <form:form method="POST" commandName="contentModelForm" action="${target}" enctype="multipart/form-data">
        <fieldset>
            <c:if test="${action eq 'edit'}">
                <form:label path="name">
                    <spring:message javaScriptEscape="true" code="content.name.label"/>
                    <span class="error"><form:errors path="name"/></span>
                </form:label>
                <form:input path="name"/>
            </c:if>

            <form:label path="content">
                <spring:message javaScriptEscape="true" code="content.content.label"/>
                <span class="error"><form:errors path="content"/></span>
            </form:label>
            <form:input path="content" type="file" accept=".doc"/>

            <form:label path="contentTypeId" cssClass="col-sm-4 control-label">
                <spring:message javaScriptEscape="true" code="label.profile"/>:
                <span class="error"><form:errors path="contentTypeId"/></span>
            </form:label>
            <form:select path="contentTypeId" cssClass="col-sm-offset-4 col-sm-8" items="${contentTypeNames}"/>

            <input type="submit" value="Submit"/>
        </fieldset>
    </form:form>
</div>