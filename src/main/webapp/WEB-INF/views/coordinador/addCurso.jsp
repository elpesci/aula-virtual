<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="registration_form">
    <form:form method="Post" action="/cursos/add" commandName="pathModel">
        <fieldset>
            <form:label path="name">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.name.label"/>
                <span class="error"><form:errors path="name"/></span>
            </form:label>
            <form:input path="name"/>

            <form:label path="goal">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.lastName.label"/>
                <span class="error"><form:errors path="goal"/></span>
            </form:label>
            <form:input path="goal"/>

            <form:label path="addressedTo">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.secondLastName.label"/>
                <span class="error"><form:errors path="addressedTo"/></span>
            </form:label>
            <form:input path="addressedTo"/>

            <input type="submit" value="Submit"/>
        </fieldset>
    </form:form>
</div>
