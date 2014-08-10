<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="registration_form">
    <fieldset>
        <form:form method="POST" action="${target}" commandName="forgetPasswordForm">
            <form:label path="email">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="forgetPassword.email.label"/>
                <span class="error"><form:errors path="email"/></span>
            </form:label>
            <form:input path="email"/>

            <input type="submit" name="save" value="<spring:message htmlEscape="true" javaScriptEscape="true" code="send"/>"/>

        </form:form>
    </fieldset>
</div>