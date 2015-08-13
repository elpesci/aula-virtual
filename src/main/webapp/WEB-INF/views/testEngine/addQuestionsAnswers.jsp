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
            <div class="col-sm-12 well well-sm">
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
                        <spring:message javaScriptEscape="true" code="testEngine.writeQuestionAnswers.label"/>:
                    </label>
                    <div class="col-sm-10">
                        <textarea data-bind="value: nuevaPregunta" class="form-control exam-qa" rows="5"></textarea>
                        <button type="button" data-bind="click: agregarPregunta" class="btn btn-success">
                            <i class="fa fa-plus-square"></i>&nbsp;
                            <spring:message javaScriptEscape="true" code="testEngine.addQuestion.label"/>
                        </button>
                    </div>
                </div>
            </form:form>
        </div>
        <div class="row" data-bind="visible: preguntas().length > 0">
            <div class="col-sm-10 col-sm-offset-2">
                <div class="panel panel-warning">
                    <div class="panel-heading">
                        <h5 class="panel-title">
                            <spring:message javaScriptEscape="true" code="testEngine.addQuestionsAnswers.heading2.label" />
                        </h5>
                    </div>
                    <div class="panel-body">
                        <div id="questionsPlaceholder" data-bind="foreach: preguntas">
                            <div class="panel panel-default">
                                <div class="panel-heading clearfix">
                                    <div class="btn-group pull-right">
                                        <button type="button" data-bind="click: agregarRespuesta" class="btn btn-success btn-xs" title="Agregar Respuesta"><i class="fa fa-check-circle-o"></i></button>
                                        <button type="button" data-bind="click: $root.removerPregunta" class="btn btn-danger btn-xs" title="Remover pregunta"><i class="fa fa-minus-square"></i></button>
                                    </div>
                                    <h6 class="panel-title" data-bind="text: textoPregunta"></h6>
                                </div>
                                <div class="panel-body">
                                  Answers Panel Body
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/knockout/3.3.0/knockout-min.js"></script>

<script id="koObjects" type="text/javascript">
    function Pregunta(data) {
        var self = this;

        self.folio = data.folio;
        self.preguntaId = data.preguntaId;
        self.textoPregunta = data.textoPregunta;
        self.respuestas = ko.observableArray([]);
        
        self.nuevaRespuesta = ko.observable("");

        
        self.agregarRespuesta = function(){
            var laRespuesta = self.nuevaRespuesta();
            if(laRespuesta !== "") {
                var myRespuesta = new Respuesta({
                    textoRespuesta: laRespuesta,
                    folioPregunta: self.folio
                });

                self.respuestas.push(myRespuesta);
            }
        };
        /*
        self.removerRespuesta = function(respuesta) {
            self.respuestas.remove(respuesta);
        };
        */
    };
</script>

<script id="koMVVM" type="text/javascript">
    function examMVVM (data) {
        var self = this;
        
        self.examenId = data.examenId;
        self.moduloId = data.moduloId;
        self.numPreguntas = data.numPreguntas;
        self.numRespuestasPregunta = data.numRespuestasPregunta;

        self.nuevaPregunta = ko.observable("");
        self.preguntas = ko.observableArray([]);
        
        self.folio = self.preguntas().length;

        self.agregarPregunta = function() {
            var laPregunta = self.nuevaPregunta();
            if(laPregunta !== "") {
                self.folio += 1;

                var myPregunta = new Pregunta({textoPregunta: laPregunta, folio: self.folio});

                self.preguntas.push(myPregunta);

                self.nuevaPregunta("");
            }
        };

        self.removerPregunta = function (pregunta) {
            self.preguntas.remove(pregunta);
        };
    }
</script>

<script type="text/javascript">
    $(document).ready(function () {
        var addExamMVVM = new examMVVM({
            examenId: ${exam.examenId},
            moduloId: ${exam.modulo.moduloId},
            numPreguntas: ${exam.numPreguntas},
            numRespuestasPregunta: ${exam.numRespuestasPregunta}
        });
        
        ko.applyBindings(addExamMVVM);
    });
</script>