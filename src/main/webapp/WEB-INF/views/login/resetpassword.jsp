<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:hasBindErrors name="resetPasswordForm">
    <script>
        $(document).ready(function () {
            <c:forEach items="${errors.globalErrors}" var="errorMessage">
                $('#flashMessagesBox').html($('<p/>', { 'class': 'error center', html: "<c:out value="${errorMessage.defaultMessage}" />" }));
            </c:forEach>
        });
    </script>
</spring:hasBindErrors>

<div id="resetPasswordBox" class="formBox clearfix prefix-1">
    <form:form method="post" action="${target}"
               commandName="resetPasswordForm">
        <form:hidden path="usuario.usuarioId" />
        <form:hidden path="usuario.password" />
        <form:hidden path="sendConfirmationEmail" />
        <div>
            <form:label path="newPassword"><spring:message code="label.password"/></form:label>
            <form:password path="newPassword" autocomplete="off" cssErrorClass="fieldError" />
            <div class="error"><form:errors path="newPassword"/></div>
        </div>
        <div>
            <form:label path="confirmNewPassword"><spring:message code="label.confirmPassword"/></form:label>
            <form:password path="confirmNewPassword" autocomplete="off" cssErrorClass="fieldError" />
            <div class="error"><form:errors path="confirmNewPassword"/></div>
        </div>
        <div>
            <button type="submit" name="send"><spring:message code="send"/></button>
            <button type="submit" name="cancel"><spring:message code="cancel"/></button>
            <span class="clearfix"></span>
        </div>
    </form:form>

</div>
