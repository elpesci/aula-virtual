<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="panel panel-warning">
  <div class="panel-heading">
      <h3>
            <i class="fa fa-cogs fa-lg"></i>
            <spring:message javaScriptEscape="true" code="testEngine.settings.heading.update.label" arguments="${examModel.modulo.curso.nombre}"/>
      </h3>
  </div>
  <div class="panel-body">
    <p class="info">
        <spring:message javaScriptEscape="true" code="testEngine.settings.info1.update.label" arguments="${examModel.modulo.curso.nombre}"/>
        <ul>
            <li><spring:message javaScriptEscape="true" code="testEngine.settings.info.li1.label" /></li>
            <li><spring:message javaScriptEscape="true" code="testEngine.settings.info.li2.label" /></li>
        </ul>
    </p>
    <div class="row">
        <div class="col-sm-12 well well-sm">
            <span class="row">
                <spring:message javaScriptEscape="true" code="testEngine.addQuestionsAnswers.info.label" />:
            </span>
            <span class="row">
                <strong><spring:message javaScriptEscape="true" code="course.course.label" />: </strong>
                ${examModel.modulo.curso.nombre}
            </span>
            <span class="row">
                <strong><spring:message javaScriptEscape="true" code="module.name.label" />: </strong>
                ${examModel.modulo.nombre}
            </span>
        </div>
    </div>
    <form:form method="POST" action="${target}" commandName="examModel" cssClass="form-horizontal">
        <form:hidden path="examenId"/>
        <form:hidden path="moduloId"/>
            <div class="panel panel-warning">
                <div class="panel-heading">
                    <spring:message javaScriptEscape="true" code="testEngine.settings.configParams.label" />
                </div>
                <div class="panel-body">
                    <div class="form-group">
                          <form:label path="numPreguntas" cssClass="col-sm-4 control-label">
                              <spring:message javaScriptEscape="true" code="testEngine.settings.numOfQuestions.label"/>:
                          </form:label>
                          <div class="col-sm-8">
                              <form:input type="number" path="numPreguntas" cssClass="form-control" cssErrorClass="fieldError" />
                              <span class="error"><form:errors path="numPreguntas"/></span>
                          </div>
                    </div>

                    <div class="form-group">
                          <form:label path="numRespuestasPregunta" cssClass="col-sm-4 control-label">
                              <spring:message javaScriptEscape="true" code="testEngine.settings.numOfAnswersPerQuestion.label"/>:
                          </form:label>
                          <div class="col-sm-8">
                              <form:input type="number" path="numRespuestasPregunta" cssClass="form-control" cssErrorClass="fieldError"/>
                              <span class="error"><form:errors path="numRespuestasPregunta"/></span>
                          </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-8">
                            <c:if test="${action eq 'edit'}">
                                <input type="submit" name="save" class="btn btn-primary"
                                       value="<spring:message javaScriptEscape="true" code="edit"/>"/>
                            </c:if>
                            <input type="submit" name="cancel" class="btn btn-danger"
                                   value="<spring:message javaScriptEscape="true" code="cancel"/>"/>
                        </div>
                    </div>
                </div>
            </div>
    </form:form>
  </div>
</div>
