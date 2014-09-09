<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12">
            <div class="jumbotron">
                <h1><i class="glyphicon glyphicon-fire"></i> <spring:message javaScriptEscape="true" code="error.500.server.error.label"/> <small><font face="Tahoma" color="red">Error 500</font></small></h1>
                <p class="lead"><spring:message javaScriptEscape="true" code="error.500.info.message.1.label"/>.</p>
                <a href="<c:url value="/"/>" class="btn btn-large btn-warning"><i class="glyphicon glyphicon-home"></i> <spring:message javaScriptEscape="true" code="error.404.home.label"/></a>
            </div>
        </div>
    </div>
</div>
