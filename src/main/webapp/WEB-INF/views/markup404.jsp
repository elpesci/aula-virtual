<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12">
            <div class="jumbotron">
                <h1><i class="glyphicon glyphicon-exclamation-sign"></i> <spring:message javaScriptEscape="true" code="error.404.page.not.found.label"/> <small><font face="Tahoma" color="red">Error 404</font></small></h1>
                <br />
                <p><spring:message javaScriptEscape="true" code="error.404.info.message.1.label"/></p>
                <p><spring:message javaScriptEscape="true" htmlEscape="true" code="error.404.info.message.2.label"/>:</p>
                <a href="<c:url value="/"/>" class="btn btn-large btn-warning"><i class="glyphicon glyphicon-home"></i> <spring:message javaScriptEscape="true" code="error.404.home.label"/></a>
            </div>
        </div>
    </div>
</div>
