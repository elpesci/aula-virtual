<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="forgetpassword_div">
    <fieldset>
        <form:form method="POST" action="${target}" commandName="forgetPasswordForm">
            <form:label path="email">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="label.email"/>
                <span class="error"><form:errors path="email"/></span>
            </form:label>
            <form:input path="email" cssErrorClass="fieldError" size="45"/>

            <input type="submit" name="save" value="<spring:message htmlEscape="true" javaScriptEscape="true" code="send"/>"/>
            <input type="submit" name="cancel" value="<spring:message htmlEscape="true" javaScriptEscape="true" code="cancel"/>"/>

        </form:form>
    </fieldset>
</div>