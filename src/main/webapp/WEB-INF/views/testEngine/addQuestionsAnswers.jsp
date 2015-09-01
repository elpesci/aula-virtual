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
        <p class="info-md">
            <spring:message javaScriptEscape="true" code="testEngine.settings.info2.label"/>
        </p>
        <div class="row">
            <div class="form-group">
                <label class="col-sm-2 control-label">
                    <spring:message javaScriptEscape="true" code="testEngine.writeQuestion.label"/>:
                </label>
                <div class="col-sm-10">
                    <textarea data-bind="value: nuevaPregunta" class="form-control exam-qa" rows="5"></textarea>
                    <button type="button" data-bind="click: agregarPregunta" class="btn btn-success">
                        <i class="fa fa-plus-square"></i>&nbsp;
                        <spring:message javaScriptEscape="true" code="testEngine.addQuestion.label"/>
                    </button>
                </div>
            </div>
        </div>
        
        <div class="row" data-bind="visible: preguntas().length > 0">
            <div class="col-sm-10 col-sm-offset-2">
                <div class="panel panel-warning">
                    <div class="panel-heading clearfix">
                        <div class="btn-group pull-right">
                            <button id="saveExam" data-bind="enable: $root.canSave, click: doSave" class="btn btn-sm btn-success  text-success" href="javascript:void(0);">
                                <i class="fa fa-download fa-2x pull-left"></i> <spring:message javaScriptEscape="true" code="save" />
                            </button>
                            <button id="cancel" class="btn btn-sm btn-danger text-danger" href="javascript:void(0);">
                                <i class="fa fa-ban fa-2x pull-left"></i> <spring:message javaScriptEscape="true" code="cancel"/>
                            </button>
                        </div>
                        <h5 class="panel-title">
                            <spring:message javaScriptEscape="true" code="testEngine.addQuestionsAnswers.heading2.label" />
                        </h5>
                    </div>
                        
                    <div class="panel-body">
                        <div id="questionsPlaceholder" data-bind="foreach: preguntas">
                            <div class="panel panel-default">
                                
                                <div class="panel-heading clearfix">
                                    <div class="btn-group pull-right">
                                        <button type="button" data-bind="click: $root.removerPregunta" class="btn btn-danger btn-sm" title="Eliminar pregunta"><i class="fa fa-2x fa-trash-o"></i></button>
                                    </div>
                                    <h6 class="panel-title" data-bind="text: textoPregunta"></h6>
                                </div>
                                
                                <div class="panel-body">
                                    
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            <spring:message javaScriptEscape="true" code="testEngine.writeAnswer.label"/>:
                                        </label>
                                        <div class="col-sm-10">
                                            <textarea data-bind="value: nuevaRespuesta" class="form-control exam-qa" cols="40" rows="3"></textarea>
                                            
                                            <label data-bind="visible: showSetRespuestaCorrecta">
                                                <input type="checkbox" data-bind="checked: esCorrecta" />
                                                <spring:message javaScriptEscape="true" code="testEngine.answer.isCorrect.label" />
                                            </label>
                                            
                                            <button type="button" data-bind="click: agregarRespuesta" class="btn btn-success">
                                                <i class="fa fa-plus-square"></i>&nbsp;
                                                <spring:message javaScriptEscape="true" code="testEngine.addAnswer.label"/>
                                            </button>
                                        </div>
                                    </div>
                                    
                                    <div id="answersPlaceholder" data-bind="visible: $data.respuestas().length > 0 ">
                                        <label class="col-sm-2 control-label">
                                            <spring:message javaScriptEscape="true" code="testEngine.answers.label" />:
                                        </label>
                                        <div class="col-sm-10">
                                            <ol data-bind="foreach: $data.respuestas" class="list-group">
                                                <li class="list-group-item">
                                                    <button type="button" data-bind="click: $parent.removerRespuesta" class="btn btn-danger btn-sm" title="Eliminar respuesta">
                                                        <i class="fa fa-trash-o"></i>
                                                    </button>
                                                    &nbsp;
                                                    <span data-bind="text: $data.textoRespuesta"></span>
                                                    <span data-bind="if: $data.esRespuestaCorrecta" class="bg-success">
                                                        <label class="text-success" style="display: inline-block;">
                                                            <i class="fa fa-check-circle-o"></i>
                                                            <spring:message javaScriptEscape="true" code="testEngine.settings.isCorrectAnswer.label" />
                                                        </label>
                                                    </span>
                                                </li>
                                            </ol>
                                        </div>
                                    </div>
                                
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
    function Respuesta(data) {
        var self = this;
        
        self.respuestaId = data.respuestaId;
        self.textoRespuesta = data.textoRespuesta;
        self.esRespuestaCorrecta = data.respuestaCorrecta;
    }
    
    function Pregunta(data) {
        var self = this;

        self.preguntaId = data.preguntaId;
        self.textoPregunta = data.textoPregunta;
        self.respuestas = ko.observableArray([]);
        
        self.nuevaRespuesta = ko.observable("");
        self.esCorrecta = ko.observable(false);

        
        self.agregarRespuesta = function(){
            var laRespuesta = self.nuevaRespuesta();
            var esLaCorrecta = self.esCorrecta();
            if(laRespuesta !== "") {
                var myRespuesta = new Respuesta({
                    respuestaId: '',
                    textoRespuesta: laRespuesta,
                    respuestaCorrecta: esLaCorrecta
                });

                self.respuestas.push(myRespuesta);
                
                self.nuevaRespuesta("");
                self.esCorrecta(false);
            }
        };
        
        self.removerRespuesta = function(respuesta) {
            self.respuestas.remove(respuesta);
        };
        
        self.esValida = ko.computed(function() {
          var hasRespuestaCorrecta = false;
          for(index = 0; index < self.respuestas().length; index++) {
                if(self.respuestas()[index].esRespuestaCorrecta) {
                    hasRespuestaCorrecta = true;
                    break;
                }
            }
          
          return hasRespuestaCorrecta && self.textoPregunta !== '';
        });
        
        self.showSetRespuestaCorrecta = ko.computed(function() {
            var show = true;
            for(index = 0; index < self.respuestas().length; index++) {
                if(self.respuestas()[index].esRespuestaCorrecta) {
                    show = false;
                    break;
                }
            }
            return show;
        });
        
    };
</script>

<script id="koMVVM" type="text/javascript">
    function examMVVM (data) {
        var self = this;
        
        self.examenId = data.examenId;
        self.moduloId = data.moduloId;
        self.numPreguntas = data.numPreguntas;
        self.numRespuestasPregunta = data.numRespuestasPregunta;
        self.postUrl = data.postUrl;

        self.nuevaPregunta = ko.observable("");
        self.preguntas = ko.observableArray([]);

        self.agregarPregunta = function() {
            var laPregunta = self.nuevaPregunta();
            if(laPregunta !== "") {
                var myPregunta = new Pregunta({preguntaId: '', textoPregunta: laPregunta});

                self.preguntas.push(myPregunta);
                self.preguntas.reverse();

                self.nuevaPregunta("");
            }
        };

        self.removerPregunta = function (pregunta) {
            self.preguntas.remove(pregunta);
        };
        
        
        self.canSave = ko.computed(function () {
            var result = true;
            
            result = self.preguntas().every(function(pregunta, index, array) {
                return pregunta.textoPregunta !== ''
                        &&
                       pregunta.respuestas().some(function (respuesta, idx, arr) {
                                                        return respuesta.esRespuestaCorrecta;
                                                  }); 
            });
            
            return result;
        });
        
        self.doSave = function () {
            var pleaseWait = $('#blockUI');
            var actionLink = $(".dismissFlash");
            var flashMsgBox = $("#flashMessagesBox");
            var flashMsgContainer = $(".remsg");
            var flashMsgContainerParagraph = $(".remsg p");
            
            if(flashMsgContainerParagraph.length === 0) { flashMsgContainer.append("<p></p>"); }
            
            pleaseWait.show();
            var  jqXHR = $.ajax({
                url: self.postUrl,
                type: "POST",
                data: ko.toJSON({"Examen" : self}),
                async: false,
                dataType: "json",
                contentType: "application/json"
              })
            .done(function(data, textStatus, xhrObj) {
                if(flashMsgContainer.hasClass("error")) { flashMsgContainer.removeClass("error") };
                if(!flashMsgContainer.hasClass("success")) { flashMsgContainer.addClass("success") };
                flashMsgContainer.text('<spring:message code="testEngine.addQA.success.label" />').append(' ').append(actionLink);
            })
            .fail(function(xhrObj, textStatus, errThrown) {
                if(flashMsgContainer.hasClass("success")) { flashMsgContainer.removeClass("success") };
                if(!flashMsgContainer.hasClass("error")) { flashMsgContainer.addClass("error") };
                flashMsgContainer.text('<spring:message code="testEngine.addQA.fail.label" />').append(' ').append(actionLink);
            })
            .always(function() {
               pleaseWait.hide();
               flashMsgBox.show();
            });
            
            jqXHR.then(function () {
                window.location.replace('<c:url value="/motorEval"/>');
            });
        }
    }
</script>

<script type="text/javascript">
    $(document).ready(function () {
        var Examen = new examMVVM({
            examenId: '',
            moduloId: ${exam.modulo.moduloId},
            numPreguntas: ${exam.numPreguntas},
            numRespuestasPregunta: ${exam.numRespuestasPregunta},
            postUrl: '<c:url value="/motorEval/saveExam"/>'
        });
        
        ko.applyBindings(Examen);
        
        $("#cancel").on('click', function () {
            window.location.replace('<c:url value="/motorEval"/>');
        });
    });
</script>