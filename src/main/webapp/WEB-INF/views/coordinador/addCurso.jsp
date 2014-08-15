<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="registration_form">
    <form:form method="POST" action="${target}" commandName="courseModel">
        <fieldset>
            <form:label path="name">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="course.name.label"/>:
                <span class="error"><form:errors path="name"/></span>
            </form:label>
            <form:input path="name"/>

            <form:label path="goal">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="course.goal.label"/>:
                <span class="error"><form:errors path="goal"/></span>
            </form:label>
            <form:textarea path="goal"/>

            <form:label path="addressedTo">
                <spring:message htmlEscape="true" javaScriptEscape="true" code="course.addressedTo.label"/>:
                <span class="error"><form:errors path="addressedTo"/></span>
            </form:label>
            <form:textarea path="addressedTo"/>
            
			<c:if test="${action eq 'add'}">
            	<input type="submit" name="save" value="<spring:message htmlEscape="true" javaScriptEscape="true" code="save"/>"/>
            </c:if>
            <c:if test="${action eq 'edit'}">
            	<input type="submit" name="save" value="<spring:message htmlEscape="true" javaScriptEscape="true" code="edit"/>"/>
            </c:if>
            <input type="submit" name="cancel" value="<spring:message htmlEscape="true" javaScriptEscape="true" code="cancel"/>"/>
        </fieldset>
    </form:form>
</div>
