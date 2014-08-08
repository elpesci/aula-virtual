<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="registration_form">
    <form:form method="POST" commandName="contentModel" action="${target}" enctype="multipart/form-data">
        <fieldset>
            <form:label path="name">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="content.name.label"/>
                <span class="error"><form:errors path="name"/></span>
            </form:label>
            <form:input path="name"/>

            <form:label path="content">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="content.content.label"/>
                <span class="error"><form:errors path="content"/></span>
            </form:label>
            <form:input path="content" type="file"/>

            <input type="submit" value="Submit"/>
        </fieldset>
    </form:form>
</div>