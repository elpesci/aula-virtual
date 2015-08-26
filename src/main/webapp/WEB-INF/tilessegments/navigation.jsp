<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- start #menu -->
    <ul id="MenuBar1" class="MenuBarHorizontal">
        <li><a href="<c:url value="/cursos"/>" title="Administrar cursos y sus contenidos"> <i class="fa fa-university"></i> Cursos</a></li>
        <sec:authorize access="hasAnyRole('SUPER_ADMIN','COORDINADOR')">
            <li>
                <a href="<c:url value="/motorEval"/>" title="Motor de exámenes"> <i class="fa fa-check-square-o"></i> Exámenes</a>
            </li>
            <li>
                <a href="<c:url value="/cursos/detail"/>" title="Visualizar cursos"> <i class="fa fa-university"></i> Ver Cursos</a>
            </li>
        </sec:authorize>
        <sec:authorize access="hasRole('SUPER_ADMIN')">
            <li><a href="<c:url value="/usuario" />" title="Administrar Usuarios"><span class="glyphicon glyphicon-user"></span> Usuarios</a></li>
        </sec:authorize>
        <li><a href="<c:url value="/j_spring_security_logout" />" title="Terminar sesi&oacute;n"><span class="glyphicon glyphicon-log-out"></span> Salir</a></li>
  </ul>
<!-- end #menu -->