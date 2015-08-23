<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="panel panel-warning">
    <div class="panel-heading">
        <h3>
            <i class="fa fa-cogs fa-lg"></i>
            <spring:message javaScriptEscape="true" code="testEngine.editQuestionsAnswers.heading.label" />
        </h3>
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-sm-12 well well-sm">
                <span class="row">
                    <spring:message javaScriptEscape="true" code="testEngine.editQuestionsAnswers.info.label" />:
                </span>
                <span class="row">
                    <strong><spring:message javaScriptEscape="true" code="course.course.label" />: </strong>
                    ${cursoNombre}
                </span>
                <span class="row">
                    <strong><spring:message javaScriptEscape="true" code="module.name.label" />: </strong>
                    ${moduloNombre}
                </span>
                <span class="row">
                    <strong><spring:message javaScriptEscape="true" code="testEngine.settings.numOfQuestions.label"/>:</strong>
                    ${numPreguntas}
                </span>
                <span class="row">
                    <strong><spring:message javaScriptEscape="true" code="testEngine.settings.numOfAnswersPerQuestion.label"/>:</strong>
                    ${numRespuestasPregunta}
                </span>
            </div>
        </div>        
        <p class="info-md">
            <spring:message javaScriptEscape="true" code="testEngine.settings.info2.label"/>
        </p>
        
        <div class="row" data-bind="visible: preguntas().length > 0">
            <div class="col-sm-12">
                <div class="panel panel-warning">
                    
                    <div class="panel-heading clearfix">
                        <div class="btn-group pull-right">
                            <button id="newQuestionBtn" type="button" class="btn btn-success">
                                <i class="fa fa-check-square-o"></i>&nbsp;
                                <spring:message javaScriptEscape="true" code="testEngine.NewQuestion.label"/>
                            </button>
                        </div>
                        <h5 class="panel-title">
                            <spring:message javaScriptEscape="true" code="testEngine.addQuestionsAnswers.heading2.label" />
                        </h5>
                    </div>
                        
                    <div class="panel-body">
                        <div id="newQuestionPlaceholder" class="row" style="margin-bottom: 10px;">
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
                        <div id="questionsPlaceholder" data-bind="foreach: preguntas">
                            <div class="panel panel-default">
                                
                                <div class="panel-heading clearfix">
                                    <div class="btn-group pull-right">
                                        <button type="button" data-bind="click: $root.removerPregunta" class="btn btn-danger btn-sm" title="Remover pregunta"><i class="fa fa-minus-square"></i></button>
                                    </div>
                                    <h6 class="panel-title" data-bind="text: textoPregunta"></h6>
                                </div>
                                
                                <div class="panel-body">
                                    
                                    <!-- Add answers placeholder -->
                                    
                                    <div id="answersPlaceholder" data-bind="visible: $data.respuestas().length > 0 ">
                                        <label class="col-sm-2 control-label">
                                            <spring:message javaScriptEscape="true" code="testEngine.answers.label" />:
                                        </label>
                                        <div class="col-sm-10">
                                            <ol data-bind="foreach: $data.respuestas" class="list-group">
                                                <li class="list-group-item">
                                                    <button type="button" class="btn btn-danger btn-sm" title="Remover respuesta">
                                                        <i class="fa fa-minus-square"></i>
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
                                        
                    <div class="panel-footer clearfix">
                        <div class="btn-group pull-right">
                            <button id="saveExam" class="btn btn-sm btn-success  text-success" href="javascript:void(0);">
                                <i class="fa fa-download fa-2x pull-left"></i> <spring:message javaScriptEscape="true" code="save" />
                            </button>
                            <button id="cancel" class="btn btn-sm btn-danger text-danger" href="javascript:void(0);">
                                <i class="fa fa-ban fa-2x pull-left"></i> <spring:message javaScriptEscape="true" code="cancel"/>
                            </button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        
    </div>
</div>


<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/knockout/3.3.0/knockout-min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/ko.mapping.2.4.1.min.js" />"></script>

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
        }, self);
        
        self.showSetRespuestaCorrecta = ko.computed(function() {
            var show = true;
            for(index = 0; index < self.respuestas().length; index++) {
                if(self.respuestas()[index].esRespuestaCorrecta) {
                    show = false;
                    break;
                }
            }
            return show;
        }, self);
        
    };
    
</script>

<script type="text/javascript">
    function getFromServer(theUrl, theExamId) 
    {
        var observableObj;
        
        $.ajax({
            url : theUrl + '/' + theExamId,
            method: 'GET',
            dataType: 'JSON',
            async: false
        })
        .done(function (data, textStatus, jqXHR) {
            observableObj = ko.mapping.fromJS(data.Examen);
        })
        .fail(function (jqXHR, textStatus, errorThrown) {})
        .always(function () {});

        return observableObj;
    };
</script>

<script id="koObjectsEdit" type="text/javascript">
    function examWrapper(examFromServer) {
        self = this;
        
        self.examenId = examFromServer.examenId;
        self.moduloId = examFromServer.moduloId;
        self.numPreguntas = examFromServer.numPreguntas;
        self.numRespuestasPregunta = examFromServer.numRespuestasPregunta;
        self.preguntas = examFromServer.preguntas;

        self.nuevaPregunta = ko.observable("");

        self.agregarPregunta = function() {
            var laPregunta = self.nuevaPregunta();
            if(laPregunta !== "") {
                var myPregunta = new Pregunta({preguntaId: '', textoPregunta: laPregunta});

                self.preguntas.push(myPregunta);
                self.preguntas.reverse();

                self.nuevaPregunta("");
            }
            $("#newQuestionPlaceholder").hide();
        };

        self.removerPregunta = function (pregunta) {
            self.preguntas.remove(pregunta);
        };
    }
</script>

<script type="text/javascript">
    $(document).ready(function () {
        var saveUrl = '<c:url value="/motorEval/saveExam"/>';
        $("#newQuestionPlaceholder").hide();
        
        var mvvm = new examWrapper(getFromServer('<c:url value="/motorEval/examenJson"/>', ${examenId}));
        
        ko.applyBindings(mvvm);
        
        $("#cancel").on('click', function () {
            window.location.replace('<c:url value="/motorEval"/>');
        });
        
        $("#newQuestionBtn").on('click', function() {
            $("#newQuestionPlaceholder").show();
        });
    });
</script>