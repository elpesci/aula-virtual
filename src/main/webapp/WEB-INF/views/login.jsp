<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="<%=request.getContextPath()%>"></c:set>
<div class="centre">
        <form:form action="${path}/login">
        <div><form:label path="username">Usuario: </form:label>
            <form:input path="username" placeholder="Capture usuario"/></div>
        
        <div><form:label path="password">Contrase&ntilde;a: </form:label>
            <form:password path="password"/></div>
        
        <div>
        <input type="submit" value="Enviar" id="submitBtn"/>
        </div>

    </form:form>
</div>