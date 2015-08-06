<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="panel panel-warning">
    <div class="panel-heading">
        <h3>
            <i class="fa fa-cogs fa-lg"></i>
            <spring:message javaScriptEscape="true" code="testEngine.addQuestionsAnswers.heading.label" />
        </h3>
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-sm-11 well well-sm centre">
                <span class="row">
                    <spring:message javaScriptEscape="true" code="testEngine.addQuestionsAnswers.info.label" />:
                </span>
                <span class="row">
                    <strong><spring:message javaScriptEscape="true" code="course.course.label" />: </strong>
                    ${exam.modulo.curso.nombre}
                </span>
                <span class="row">
                    <strong><spring:message javaScriptEscape="true" code="module.name.label" />: </strong>
                    ${exam.modulo.nombre}
                </span>
            </div>
        </div>
        <div class="row">
            <form:form method="POST" commandName="exam" action="${target}" class="form-horizontal">
                <form:hidden path="examenId" />
                <form:hidden path="modulo.moduloId" />
                <form:hidden path="numPreguntas" />
                <form:hidden path="numRespuestasPregunta" />
                
                    <div class="form-group">
                        <label class="col-sm-2 control-label">
                            <spring:message javaScriptEscape="true" code="testEngine.settings.questions.label"/>:
                        </label>
                        <div class="col-sm-10">
                            <div id="questionsPlaceholder" data-bind="foreach: preguntas, visible: preguntas().length > 0">                                      
                              <div class="row">
                                  <div class="col-sm-10">
                                      <textarea data-bind="value: textoPregunta" class="form-control exam-qa" rows="5"></textarea>
                                      <div id="answersPlaceholder" data-bind="foreach: respuestas, visible: respuestas().length > 0">
                                          <textarea data-bind="value: textoRespuesta" class="form-control exam-qa" rows="5"></textarea>
                                          <input type="radio" data-bind="attr: {name: folioPregunta, checked: esRespuestaCorrecta}" /> Respuesta correcta
                                      </div>
                                  </div>
                                  <div class="col-sm-2">
                                      <div class="btn-toolbar  btn-group-sm" role="toolbar" aria-label="...">
                                            <button type="button" data-bind="click: $root.removerPregunta" class="btn btn-danger btn-xs" title="Remover pregunta"><i class="fa fa-minus-square"></i></button>
                                            <button type="button" data-bind="click: agregarRespuesta" class="btn btn-success btn-xs" title="Agregar Respuesta"><i class="fa fa-check-circle-o"></i></button>
                                      </div>
                                  </div>
                              </div>
                            </div>
                            <div id="questionActions" class="btn-group" role="group" aria-label="...">
                                <button type="button" data-bind="click: agregarPregunta" class="btn btn-success"><i class="fa fa-plus-square"></i>&nbsp;Agregar Pregunta</button>
                            </div>
                        </div>
                    </div>
                
            </form:form>
        </div>
    </div>
</div>

<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/knockout/3.3.0/knockout-min.js"></script>

<script id="koObjects" type="text/javascript">
    function Respuesta(data) {
        var self = this;

        self.folioPregunta = data.folioPregunta;
        self.respuestaId = data.respuestaId;
        self.preguntaId = data.preguntaId;
        self.textoRespuesta = ko.observable(data.textoRespuesta);
        self.esRespuestaCorrecta = ko.observable(false);
    };

    function Pregunta(data) {
        var self = this;

        self.folio = data.folio;
        self.preguntaId = data.preguntaId;
        self.textoPregunta = ko.observable(data.textoPregunta);
        self.respuestas = ko.observableArray([]);

        self.agregarRespuesta = function(){
            var myRespuesta = new Respuesta({textoRespuesta: "", folioPregunta: self.folio});

            self.respuestas.push(myRespuesta);
        }

        self.removerRespuesta = function(respuesta) {
            self.respuestas.remove(respuesta);
        }
    };
</script>

<script id="koMVVM" type="text/javascript">
    function examMVVM () {
        var self = this;

        self.folio = ko.observable(0);
        self.moduloId = ko.observable(0);
        self.preguntas = ko.observableArray([]);

        self.agregarPregunta = function() {
            self.folio = self.folio()++;
            
            var myPregunta = new Pregunta({textoPregunta: "", folio: self.folio()});

            self.preguntas.push(myPregunta);
        };

        self.removerPregunta = function (pregunta) {
            self.preguntas.remove(pregunta);
        };
    }
</script>

<script type="text/javascript">
    $(document).ready(function () {
        var addExamMVVM = new examMVVM();
        ko.applyBindings(addExamMVVM);
    });
</script>