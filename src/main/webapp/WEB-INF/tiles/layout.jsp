<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>
        <tiles:insertAttribute name="title" ignore="true" />
    </title>
    
    <tiles:insertAttribute name="meta" />

    <!--estilos-->
    <link href="/resources/css/estilo_general.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="/resources/css/SprayMenuBar.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="/resources/css/SpryCollapsiblePanel.css" rel="stylesheet" type="text/css" media="screen" />
    <!--Scripts-->
    <script src="/resources/js/SpryMenuBar.js" type="text/javascript"></script>
    <script src="/resources/js/SpryCollapsiblePanel.js" type="text/javascript"></script>

</head>

<body>

<div id="wrapper">
    <tiles:insertAttribute name="header" />
    
    <tiles:insertAttribute name="navigation" />
  
  <div id="page">
     <div id="MenuPrincipal">
      <div id="CollapsiblePanel1" class="CollapsiblePanel PanelFirst">
        <div class="CollapsiblePanelTab"> <img id="btnLink" src="/resources/img/hacordeon.png" width="215" height="38" alt="" /> </div>
        <div class="CollapsiblePanelContent PanelColor"> 
        <br /><br /><br /><br /><br /><br />
        </div>
        <div class="expand"> <img src="/resources/img/expand.png" width="97" alt="" /> </div>
      </div></div>
   
    <div id="content">
      <div class="post">
        <h3 class="title">INICIO</h3>
        <p>&nbsp;</p>
        <p class="meta"><span class="date">
          <script type="text/javascript" src="../js/date.js"></script>
          </span></p>
        <div class="entry">
          <h3>Visión</h3>
          <p>Ser una secretaría que desarrolle altos estándares de calidad de la manera mas eficiente, dinámica y estratégica, lo cual lleve a la excelencia en la operatividad financiera d e la administración pública del Gobierno del Estado, con acciones de legalidad y disciplina en beneficio de la sociedad oaxaqueña. </p>
          <h3>Misión</h3>
          <p> Administrar, modernizar y regular de manera eficaz y transparente la política financiera fiscal y administrativa de la hacienda pública a fin de consolidarse como el eje rector de financiamiento para el logro del plan estatal de desarrollo del Gobierno del Estado.</p>
          <p class="links"><a href="#">Leer más..</a><span>|</span><a href="#">Comentarios</a></p>
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
