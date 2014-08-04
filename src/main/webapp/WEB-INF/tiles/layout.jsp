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
    <link href="<c:url value="/resources/css/estilo_general.css"/>" rel="stylesheet" type="text/css" media="screen" />
    <link href="<c:url value="/resources/css/SprayMenuBar.css"/>" rel="stylesheet" type="text/css" media="screen" />
    <link href="<c:url value="/resources/css/SpryCollapsiblePanel.css"/>" rel="stylesheet" type="text/css" media="screen" />
    <link href="<c:url value="/resources/css/aulavirtual.css"/>" rel="stylesheet" type="text/css" media="screen" />
    <!--Scripts-->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/SpryMenuBar.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/SpryCollapsiblePanel.js"/>" type="text/javascript"></script>

</head>

<body>

<div id="wrapper">
    <tiles:insertAttribute name="header" />
    
    <tiles:insertAttribute name="navigation" />
  
  <div id="page">
     <div id="MenuPrincipal">
      <div id="CollapsiblePanel1" class="CollapsiblePanel PanelFirst">
        <div class="CollapsiblePanelTab"> <img id="btnLink" src="<c:url value="/resources/img/hacordeon.png"/>" width="215" height="38" alt="" /> </div>
        <div class="CollapsiblePanelContent PanelColor"> 
        <br /><br /><br /><br /><br /><br />
        </div>
        <div class="expand"> <img src="<c:url value="/resources/img/expand.png"/>" width="97" alt="" /> </div>
      </div></div>
   
    <div id="content">
            <tiles:insertAttribute name="body"/>
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
