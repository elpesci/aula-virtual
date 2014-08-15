<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>
        <tiles:insertAttribute name="title" ignore="true" />
    </title>
    
    <tiles:insertAttribute name="meta" />

    <!--estilos-->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<c:url value="/resources/css/estilo_general.css"/>" rel="stylesheet" type="text/css" media="screen" />
    <link href="<c:url value="/resources/css/SprayMenuBar.css"/>" rel="stylesheet" type="text/css" media="screen" />
    <link href="<c:url value="/resources/css/SpryCollapsiblePanel.css"/>" rel="stylesheet" type="text/css" media="screen" />
    <link href="<c:url value="/resources/css/aulavirtual.css"/>" rel="stylesheet" type="text/css" media="screen" />
    <!--Scripts-->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" type="text/javascript"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="<c:url value="/resources/js/SpryMenuBar.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/SpryCollapsiblePanel.js"/>" type="text/javascript"></script>

</head>

<body>

<div id="wrapper">
    <tiles:insertAttribute name="header" />
      
  <div id="page">
     
    <div id="content">
      <div class="post">
        <h3 class="title">Aula Virtual</h3>
        <p>&nbsp;</p>
        <p class="meta"><span class="date">
          <script type="text/javascript" src="../js/date.js"></script>
          </span></p>
        <div class="entry">
          <h3>Visión</h3>
          <p>Derivado del bajo impacto social de la inversión pública en el 
             Estado de Oaxaca, para el Gobierno es fundamental mejorar las 
             capacidades de la Administración Pública Estatal en la 
             identificación de las necesidades de inversión y eficientar la 
             planeación y análisis de alternativas que resuelvan adecuadamente 
             dichas necesidades, a través de proyectos pertinentes y de calidad; 
             así como fortalecer los procesos de toma de decisiones y de gestión.
          </p>
          <tiles:insertAttribute name="body"/>
        </div>
      </div>
    </div>
    
    <!-- end #content -->
  </div>
  <!-- end #page -->
  <ul class="MainFooter" style="height:100px;">
    <li><a href="#"></a></li>
    <li><a  href="#"></a></li>
    <li><a  href="#"></a></li>
  </ul>
  <ul class="MainFooterCh"  style="height:50px;">
     <li><a href="#"></a></li>
    <li><a  href="#"></a></li>
    <li><a  href="#"></a></li>
  </ul>
</div>
<!-- end #wraper -->
<tiles:insertAttribute name="footer" />
  <script type="text/javascript">  
	var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1");
	var CollapsiblePanel1 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel1", {contentIsOpen:false});
  </script>
</body>
</html>
