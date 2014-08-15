<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="registration_form">
    <fieldset>
        <form:form method="Post" action="/login/registration" commandName="registration">
            <form:label path="name">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.name.label"/>
                <span class="error"><form:errors path="name"/></span>
            </form:label>
            <form:input path="name" cssErrorClass="fieldError"/>

            <form:label path="lastName">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.lastName.label"/>
                <span class="error"><form:errors path="lastName"/></span>
            </form:label>
            <form:input path="lastName" cssErrorClass="fieldError"/>

            <form:label path="secondLastName">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="registration.secondLastName.label"/>
                <span class="error"><form:errors path="secondLastName"/></span>
            </form:label>
            <form:input path="secondLastName" cssErrorClass="fieldError"/>

            <form:label path="email">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="label.email"/>
                <span class="error"><form:errors path="email"/></span>
            </form:label>
            <form:input path="email" cssErrorClass="fieldError"/>

            <form:label path="password">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="label.password"/>
                <span class="error"><form:errors path="password"/></span>
            </form:label>
            <form:password path="password" autocomplete="off" cssErrorClass="fieldError"/>

            <form:label path="confirmPassword">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="label.confirmPassword"/>
                <span class="error"><form:errors path="confirmPassword"/></span>
            </form:label>
            <form:password path="confirmPassword" autocomplete="off" cssErrorClass="fieldError"/>
            
            <sec:authorize access="hasRole('SUPER_ADMIN')">
                <form:select path="profile" items="${profiles}"/>
            </sec:authorize>

            <input type="submit" name="save" value="<spring:message htmlEscape="true" javaScriptEscape="true" code="save"/>"/>
            <input type="submit" name="cancel" value="<spring:message htmlEscape="true" javaScriptEscape="true" code="cancel"/>"/>
            <span class="error">
                <spring:hasBindErrors name="registration">
                <c:forEach items="${errors.globalErrors}" var="errorMessage">
                    <div id="errors" class="errors">
                        <spring:message htmlEscape="true" code="${errorMessage.code}" />
                    </div>
                </c:forEach>
                </spring:hasBindErrors>
            </span>
        </form:form>
    </fieldset>
</div>