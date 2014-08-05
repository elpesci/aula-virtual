<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="registration_form">
    <fieldset>
        <form:form method="Post" action="/login/registration" commandName="registration">
            <form:label path="name">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.name.label"/>
                <span class="error"><form:errors path="name"/></span>
            </form:label>
            <form:input path="name"/>

            <form:label path="email">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.email.label"/>
                <span class="error"><form:errors path="email"/></span>
            </form:label>
            <form:password path="email"/>

            <form:label path="password">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.password.label"/>
                <span class="error"><form:errors path="password"/></span>
            </form:label>
            <form:password path="password"/>

            <form:label path="confirmPassword">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.confirmPassword.label"/>
                <span class="error"><form:errors path="confirmPassword"/></span>
            </form:label>
            <form:password path="confirmPassword"/>

            <input type="submit" value="Submit"/>
        </form:form>
    </fieldset>
</div>