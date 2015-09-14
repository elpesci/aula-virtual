<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="panel panel-warning">
  <div class="panel-heading">
      <h3>
          <i class="fa fa-cogs fa-lg"></i>
            <c:if test="${action eq 'add'}">
                <spring:message javaScriptEscape="true" code="testEngine.settings.heading.add.label"/>
            </c:if>
            <c:if test="${action eq 'edit'}">
                <spring:message javaScriptEscape="true" code="testEngine.settings.heading.update.label" arguments="${courseName}"/>
            </c:if>
      </h3>
  </div>
  <div class="panel-body">
    <p class="info">
        <c:if test="${action eq 'add'}">
            <spring:message javaScriptEscape="true" code="testEngine.settings.info1.add.label"/>
        </c:if>
        <c:if test="${action eq 'edit'}">
            <spring:message javaScriptEscape="true" code="testEngine.settings.info1.update.label" arguments="${courseName}"/>
        </c:if>
        <ul>
            <li><spring:message javaScriptEscape="true" code="testEngine.settings.info.li0.label" /></li>
            <li><spring:message javaScriptEscape="true" code="testEngine.settings.info.li1.label" /></li>
            <li><spring:message javaScriptEscape="true" code="testEngine.settings.info.li2.label" /></li>
            <li><spring:message javaScriptEscape="true" code="testEngine.settings.info.li3.label" /></li>
            <li><spring:message javaScriptEscape="true" code="testEngine.settings.info.li4.label" /></li>
        </ul>
    </p>
    <p class="info-md">
        <spring:message javaScriptEscape="true" code="testEngine.settings.info2.label"/>
    </p>
    <form:form method="POST" action="${target}" commandName="examModel" cssClass="form-horizontal">
        <form:hidden path="id"/>                
            <div class="panel panel-warning">
                <div class="panel-heading">
                    <spring:message javaScriptEscape="true" code="testEngine.settings.configParams.label" />
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <form:label path="courseName" cssClass="col-sm-4 control-label">
                            <spring:message javaScriptEscape="true" code="testEngine.settings.nameOfCourse.label"/>:
                        </form:label>
                        <div class="col-sm-8">
                            <form:select path="courseId" cssClass="form-control" cssErrorClass="fieldError" items="${courses}" />
                            <span class="error"><form:errors path="courseName"/></span>
                        </div>
                    </div>
                        
                    <div class="form-group">
                        <form:label path="moduleId" cssClass="col-sm-4 control-label">
                            <spring:message javaScriptEscape="true" code="testEngine.settings.nameOfModule.label"/>:
                        </form:label>
                        <div id="moduleDdl" class="col-sm-8"></div>
                    </div>
                        
                    <div class="form-group">
                          <form:label path="numOfQuestions" cssClass="col-sm-4 control-label">
                              <spring:message javaScriptEscape="true" code="testEngine.settings.numOfQuestions.label"/>:
                          </form:label>
                          <div class="col-sm-8">
                              <form:input type="number" path="numOfQuestions" cssClass="form-control" cssErrorClass="fieldError" />
                              <span class="error"><form:errors path="numOfQuestions"/></span>
                          </div>
                    </div>

                    <div class="form-group">
                          <form:label path="numAnswersPerQuestion" cssClass="col-sm-4 control-label">
                              <spring:message javaScriptEscape="true" code="testEngine.settings.numOfAnswersPerQuestion.label"/>:
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
                                       value="<spring:message javaScriptEscape="true" code="label.continue"/>"/>
                            </c:if>
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
    
    <script type="text/javascript" src="<c:url value="/resources/js/jsrender.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.observable.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.views.min.js"/>"></script>
    
    <script id="modulesDdlTmpl" type="text/x-jsrender">
        <select id='moduleId' name='moduleId' class="form-control">
            {{for modulos}}
            <option value='{{:id}}'>{{:description}}</option>
            {{/for}}
        </select>
    </script>
    
    <script id="viewFunctions" type="text/javascript">
        function populateModules(courseId) {
            var actionUrl = '../modulos/course/' + courseId;
            
            $.ajax({
                url : actionUrl,
                method: 'GET'
            })
            .done(function (data, textStatus, jqXHR) {
                var markUp = $.render.modulesSelector(data);
                $("#moduleDdl").html(markUp);
            })
            .fail(function (jqXHR, textStatus, errorThrown) {})
            .always(function () {});
        }
    </script>
    
    <script type="text/javascript">
        $(document).ready(function () {
            // Registering jsViews template
            $.templates("modulesSelector", "#modulesDdlTmpl");
        
            var cursoId = $("#courseId").val();
            populateModules(cursoId);
            
            $("#courseId").on("change", function (event, data) {
                var cursoId = $(this).val();
                populateModules(cursoId);
            });
        });
    </script>