<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="<%=request.getContextPath()%>"></c:set>
<div class="centre">

    <form:form action="${path}/login">
    <tr>
        <form:label path="nombreUsuario">Usuario: </form:label>
            <form:input path="nombreUsuario" placeholder="Capture usuario"/>

        <form:label path="password">Contrase&ntilde;a: </form:label>
            <form:password path="password"/>
        <br>
        <input type="submit" value="Enviar" id="submitBtn"/>

        </form:form>

</div>