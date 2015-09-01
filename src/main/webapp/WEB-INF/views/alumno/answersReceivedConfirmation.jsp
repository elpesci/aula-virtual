<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid theme-showcase" role="main">
    <div class="row">
        <div class="col-sm-12">
            <div class="jumbotron">
                <h1><i class="fa fa-2x fa-check-square-o"></i><spring:message code="testEngine.appraisal.receipt.heading.label" /></h1>
                <p class="info">
                    <spring:message code="testEngine.appraisal.receipt.info1.label" />
                </p>
                <p class="info">
                    <spring:message code="testEngine.appraisal.receipt.info2.label" />
                </p>
                <p class="info">
                    <spring:message code="label.thanks.so.much" />
                </p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <a href="<c:url value="/cursos" />" class="btn btn-warning">
                <i class="fa fa-home fa-2x"></i>
                <spring:message code="label.backToHomePage" />
            </a>
        </div>
    </div>
</div>