<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>
        <tiles:insertAttribute name="title" ignore="true"/>
    </title>

    <tiles:insertAttribute name="meta"/>

    <!--estilos-->
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel= "stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<c:url value="/resources/css/estilo_general.css"/>" rel="stylesheet" type="text/css" media="screen"/>
    <link href="<c:url value="/resources/css/SprayMenuBar.css"/>" rel="stylesheet" type="text/css" media="screen"/>
    <link href="<c:url value="/resources/css/SpryCollapsiblePanel.css"/>" rel="stylesheet" type="text/css"
          media="screen"/>
    <link href="<c:url value="/resources/css/aulavirtual.css"/>" rel="stylesheet" type="text/css" media="screen"/>
    <!--Scripts-->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" type="text/javascript"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="<c:url value="/resources/js/SpryMenuBar.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/SpryCollapsiblePanel.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/aulavirtual.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jquery.blockUI.js"/>" type="text/javascript"></script>

</head>

<body>

<div id="wrapper">

    <tiles:insertAttribute name="header"/>

    <sec:authorize access="isAuthenticated()">
        <tiles:insertAttribute name="navigation"/>
    </sec:authorize>

    <div id="page">
		<tiles:insertAttribute name="flashMessage"/>
        <div id="content">
            <tiles:insertAttribute name="body"/>
            <!-- end #content -->
        </div>
        <!-- end #page -->
    </div>
    <!-- end #wraper -->
    <tiles:insertAttribute name="footer"/>
</div>

</body>
</html>
