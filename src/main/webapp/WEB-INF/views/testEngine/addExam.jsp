<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="panel panel-warning">
  <div class="panel-heading">
      <h3>
            <c:if test="${action eq 'add'}">
                <!-- <spring:message javaScriptEscape="true" code="course.add.heading.label"/> -->
                Etiqueta Alta Examen
            </c:if>
            <c:if test="${action eq 'edit'}">
                <!-- <spring:message javaScriptEscape="true" code="course.edit.heading.label" arguments="${courseModel.name}"/> -->
                Etiqueta Actualizar examen de curso {0} 
            </c:if>
      </h3>
  </div>
  <div class="panel-body">
    <p class="info">
        <!-- <spring:message javaScriptEscape="true" code="course.add.info.row1.label"/> -->
        Alta Examen Info Row1
    </p>
    <p class="info">
        <!-- <spring:message javaScriptEscape="true" code="course.add.info.row2.label"/> -->
        Alta Examen Info Row2
    </p>
    <form:form method="POST" action="${target}" commandName="examModel" cssClass="form-horizontal">
        <form:hidden path="id"/>
            <div class="form-group">
                <form:label path="courses" cssClass="col-sm-4 control-label">
                    <spring:message javaScriptEscape="true" code="course.name.label"/>:
                </form:label>
                <div class="col-sm-8">
                    <form:select path="courses" cssClass="form-control" cssErrorClass="fieldError" items="${courses}"/>
                    <span class="error"><form:errors path="courses"/></span>
                </div>
            </div>
            
            <div class="form-group">
                <form:label path="numOfQuestions" cssClass="col-sm-4 control-label">
                    <!-- <spring:message javaScriptEscape="true" code="course.goal.label"/>: -->
                    Número de preguntas de las que constará el examen:
                </form:label>                    
                <div class="col-sm-8">
                    <form:input type="number" path="numOfQuestions" cssClass="form-control" cssErrorClass="fieldError" />
                    <span class="error"><form:errors path="numOfQuestions"/></span>
                </div>
            </div>
                
            <div class="form-group">
                <form:label path="numAnswersPerQuestion" cssClass="col-sm-4 control-label">
                    <!-- <spring:message javaScriptEscape="true" code="course.addressedTo.label"/>: -->
                    Número de posibles respuestas para cada pregunta:
                </form:label>
                <div class="col-sm-8">
                    <form:input type="number" path="numAnswersPerQuestion" cssClass="form-control" cssErrorClass="fieldError"/>
                    <span class="error"><form:errors path="numAnswersPerQuestion"/></span>
                </div>
            </div>
                
            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-8">
                    <c:if test="${action eq 'add'}">
                        <input type="submit" name="save" class="btn btn-primary"
                               value="<spring:message javaScriptEscape="true" code="save"/>"/>
                    </c:if>
                    <c:if test="${action eq 'edit'}">
                        <input type="submit" name="save" class="btn btn-primary"
                               value="<spring:message javaScriptEscape="true" code="edit"/>"/>
                    </c:if>
                    <input type="submit" name="cancel" class="btn btn-danger"
                           value="<spring:message javaScriptEscape="true" code="cancel"/>"/>
                </div>
            </div>
    </form:form>
  </div>
</div>