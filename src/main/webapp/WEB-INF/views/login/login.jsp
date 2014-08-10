<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="centre">

    <c:if test="${not empty param.error}">
        <span class="error"> Invalid user name or password, try again.</span>
    </c:if>
    <span class="error">${msg}</span>
    <c:if test="${not empty msg}">
        <span class="error">${msg}</span>
    </c:if>
    <form name='loginForm' action="<c:url value='/j_spring_security_check'/>" method='POST'>
        <fieldset>
            <label for="username">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="login.username.label"/>
            </label>
            <input name="username" placeholder="Capture usuario"/>

            <label for="password">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="login.password.label"/>
            </label>
            <input type="password" name="password"/>
        </fieldset>

        <div>
            <spring:message htmlEscape="true" javaScriptEscape="true" code="login.forgetpassword.label"/>
            <a href="login/forgetPassword">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="here"/>
            </a>
        </div>
        <div>
            <input type="submit"
                   value="<spring:message htmlEscape="true" javaScriptEscape="true" code="login.login.label"/>"
                   id="submitBtn"/>
        </div>
        <spring:message htmlEscape="true" javaScriptEscape="true" code="login.newuser.label"/>
        <a href="login/registration">
            <spring:message htmlEscape="true" javaScriptEscape="true" code="here"/>
        </a>

    </form>

</div>