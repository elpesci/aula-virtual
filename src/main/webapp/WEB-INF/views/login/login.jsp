<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${error}">
    <script>
        $(document).ready(function () {
            $('#flashMessagesBox').html($('<p/>', { 'class': 'error center', html: "<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>" }));
        });
    </script>
</c:if>
                
<div class="container theme-showcase" role="main">
    <div class="row">
        <div class="col-xs-5">
            <div class="jumbotron">
                <h1>¡Bienvenido a Aula Virtual!</h1>
                <p class="info">Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                    Mauris lobortis dolor id turpis pulvinar rutrum. 
                    Interdum et malesuada fames ac ante ipsum primis in faucibus. 
                    Proin ultrices sit amet arcu quis tempus. 
                    Cras consectetur ultrices nibh, eleifend ullamcorper eros hendrerit blandit. 
                    Fusce id suscipit metus, ac dignissim leo. Ut ut condimentum orci, a ullamcorper enim. 
                    Sed convallis accumsan placerat. Quisque in hendrerit turpis. 
                    Maecenas consequat, turpis id sollicitudin ullamcorper, felis nibh faucibus ipsum, eu adipiscing nulla magna ut nisi. 
                    Suspendisse potenti.
                </p>
            </div>
        </div>
        <div class="col-xs-4">
                
            <div class="panel panel-warning">
                <div class="panel-heading">
                    <spring:message javaScriptEscape="true" code="login.login.label"/>
                </div>
                <div class="panel-body">
                    <c:out value="${sessionScope.LAST_USERNAME}" escapeXml="false"/>
                    <form name='loginForm' action="<c:url value='/j_spring_security_check'/>" method='POST' class="form-horizontal" role="form">
                        
                            <div class="form-group">
                                <label for="username" class="col-sm-4 control-label">
                                    <spring:message htmlEscape="true" javaScriptEscape="true" code="label.email"/>
                                </label>
                                <div class="col-sm-8">
                                    <input name="username" placeholder="Capture correo electr&oacute;nico" class="form-control"
                                       value="<c:out value="${sessionScope.LAST_USERNAME}" escapeXml="false" />"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="password" class="col-sm-4 control-label">
                                    <spring:message javaScriptEscape="true" code="label.password"/>
                                </label>
                                <div class="col-sm-8">
                                <input type="password" name="password" class="form-control"/>
                                </div>
                            </div>

                        <div class="form-group">
                                <div class="col-sm-offset-4 col-sm-8">
                                <input type="submit" class="btn btn-primary"
                                       value="<spring:message javaScriptEscape="true" code="send"/>"
                                       id="submitBtn"/>
                                </div>
                            </div>

                        <div>
                            <spring:message javaScriptEscape="true" code="login.forgetpassword.label"/>
                            <a href="<c:url value="/login/forgetPassword"/>">
                                <spring:message htmlEscape="true" javaScriptEscape="true" code="login.resetPassword.label"/>
                                <spring:message htmlEscape="true" javaScriptEscape="true" code="here"/>
                            </a>
                        </div>
                        <spring:message javaScriptEscape="true" code="login.newuser.label"/>
                        <a href="<c:url value="/login/registration"/>">
                            <spring:message javaScriptEscape="true" code="login.register.label"/>
                            <spring:message javaScriptEscape="true" code="here"/>
                        </a>

                    </form>
                </div>
            </div>
                
        </div>
    </div>
</div>




