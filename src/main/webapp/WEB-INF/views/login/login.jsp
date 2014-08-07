<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="<%=request.getContextPath()%>"></c:set>
<div class="centre">

    <form name='loginForm'
          action="<c:url value='j_spring_security_check' />" method='POST'>
        <fieldset>
            <div><label path="username">Usuario: </label>
                <input name="username" placeholder="Capture usuario"/></div>

            <div><label path="password">Contrase&ntilde;a: </label>
                <input type="password" name="password"/></div>
        </fieldset>
        <div>
            <input type="submit" value="Enviar" id="submitBtn"/>
        </div>

    </form>
    <c:if test="${not empty param.error}">
        <span class="error"> Invalid user name or password, try again.</span>
    </c:if>
		<span class="error">${msg}</span>
	<c:if test="${not empty msg}">
		<span class="error">${msg}</span>
	</c:if>
</div>