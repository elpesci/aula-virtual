<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fliud">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <i class="fa fa-leanpub"></i>
                        <spring:message javaScriptEscape="true" code="testEngine.settings.heading.label"/>
                    </h3>
                </div>
                <div class="panel-body">
                    <div class="well well-sm">
                        <spring:message javaScriptEscape="true" code="testEngine.settings.info1.label" />
                        <<ul>
                            <li><spring:message javaScriptEscape="true" code="testEngine.settings.info.li1.label" /></li>
                            <li><spring:message javaScriptEscape="true" code="testEngine.settings.info.li2.label" /></li>
                            <li><spring:message javaScriptEscape="true" code="testEngine.settings.info.li3.label" /></li>
                            <li><spring:message javaScriptEscape="true" code="testEngine.settings.info.li4.label" /></li>
                        </ul>
                        <spring:message javaScriptEscape="true" code="testEngine.settings.info2.label" />
                    </div>
                    <!-- Aqui va la tabla de examenes configurados -->
                </div>
            </div>
        </div>
    </div>
</div>