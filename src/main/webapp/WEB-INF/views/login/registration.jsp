<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="/WEB-INF/views/login/recaptcha_options.jsp" %>


<spring:hasBindErrors name="registration">
    <script>
        $(document).ready(function () {
            <c:forEach items="${errors.globalErrors}" var="errorMessage">
            aulaVirtualController.addFlashMessage("<c:out value="${errorMessage.defaultMessage}" />");
            </c:forEach>
        });
    </script>
</spring:hasBindErrors>

<div class="panel panel-warning">
    <div class="panel panel-heading">
        <h1><spring:message javaScriptEscape="true" code="registration.header"/></h1>
    </div>
    <div class="panel panel-body">
        <p class="info">
            <spring:message javaScriptEscape="true" code="registration.info"/>
        </p>
        <form:form method="Post" action="/login/registration" commandName="registration" cssClass="form-horizontal">
            <div class="form-group">
                <form:label path="name" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="registration.name.label"/>
                    <span class="error"><form:errors path="name"/></span>
                </form:label>
                <div class="col-sm-8">
                    <form:input path="name" cssClass="form-control" cssErrorClass="form-control fieldError"/>
                </div>
            </div>

            <div class="form-group">
                <form:label path="lastName" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="registration.lastName.label"/>
                    <span class="error"><form:errors path="lastName"/></span>
                </form:label>
                <div class="col-sm-8">
                    <form:input path="lastName" cssClass="form-control" cssErrorClass="form-control fieldError"/>
                </div>
            </div>

            <div class="form-group">
                <form:label path="secondLastName" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="registration.secondLastName.label"/>
                    <span class="error"><form:errors path="secondLastName"/></span>
                </form:label>
                <div class="col-sm-8">
                    <form:input path="secondLastName" cssClass="form-control" cssErrorClass="form-control fieldError"/>
                </div>
            </div>

            <div class="form-group">
                <form:label path="email" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="label.email"/>
                    <span class="error"><form:errors path="email"/></span>
                </form:label>
                <div class="col-sm-8">
                    <form:input path="email" cssClass="form-control" cssErrorClass="form-control fieldError"/>
                </div>
            </div>

            <div class="form-group">
                <form:label path="password" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="label.password"/>
                    <span class="error"><form:errors path="password"/></span>
                </form:label>
                <div class="col-sm-8">
                    <form:password path="password" autocomplete="off" cssClass="form-control"
                                   cssErrorClass="form-control fieldError"/>
                </div>
            </div>

            <div class="form-group">
                <form:label path="confirmPassword" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="label.confirmPassword"/>
                    <span class="error"><form:errors path="confirmPassword"/></span>
                </form:label>
                <div class="col-sm-8">
                    <form:password path="confirmPassword" autocomplete="off" cssClass="form-control"
                                   cssErrorClass="form-control fieldError"/>
                </div>
            </div>

            <div class="form-group">
                <sec:authorize access="hasRole('SUPER_ADMIN')">
                    <form:label path="profile" cssClass="col-sm-4 control-label">
                        <spring:message javaScriptEscape="true" code="label.profile"/>:
                        <span class="error"><form:errors path="profile"/></span>
                    </form:label>
                    <form:select path="profile" cssClass="col-sm-offset-4 col-sm-8" items="${profiles}"/>
                </sec:authorize>
            </div>

            <div id="captcha_paragraph">
                <c:if test="${invalidRecaptcha == true}">
                    <span class="error_form_validation"><spring:message code="invalid.captcha"
                                                                        text="Invalid captcha please try again"/></span>
                </c:if>
                <c:out value="${recaptcha}" escapeXml="false"></c:out>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-8">
                    <input type="submit" name="save" class="btn btn-primary"
                           value="<spring:message htmlEscape="true" javaScriptEscape="true" code="save"/>"/>
                    <input type="submit" name="cancel" class="btn btn-danger"
                           value="<spring:message htmlEscape="true" javaScriptEscape="true" code="cancel"/>"/>
                </div>
            </div>
        </form:form>
    </div>
</div>
