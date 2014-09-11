<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container-fliud">
  <div clas="row">
      <!-- Listado de cursos -->
      <div class="col-xs-3">
        <p class="lead">Cursos</p>
        <div class="list-group">
            <a href="#" class="list-group-item active">Curso 1</a>
            <a href="#" class="list-group-item">Curso 2</a>
            <a href="#" class="list-group-item">Curso 3</a>
            <a href="#" class="list-group-item">Ejemplo de nombre de curso extenso</a>
        </div>
      </div>
      <!-- Detalle de curso -->
      <div class="col-xs-9">
        <!-- <div class="thumbnail">-->
            <div class="panel panel-default">
              <div class="panel-heading">
                  <h3 class="panel-title">
                      Titulo del Curso
                  </h3>
              </div>
              <div class="panel-body">
                  <div class="row">
                    <div class="col-xs-3 text-right">Objetivo:</div>
                    <div class="col-xs-9">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque mollis ipsum erat, in volutpat purus tempor ut. Aliquam leo leo, laoreet nullam</div>
                  </div>
                  <div class="row">
                    <div class="col-xs-3 text-right">Dirigido a:</div>
                    <div class="col-xs-9">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque mollis ipsum erat, in volutpat purus tempor ut. Aliquam leo leo, laoreet nullam</div></div>
              </div>
            </div>
        <!-- </div> -->
        <h3>Temario</h3>
        <div class="well">
          <!-- Inicia Modulo -->
          <div class="row">
            <h3>Nombre del modulo 1</h3>
            <div class="row">
              <div class="col-xs-3 text-right">Objetivo General:</div>
              <div class="col-xs-9">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque mollis ipsum erat, in volutpat purus tempor ut. Aliquam leo leo, laoreet nullam</div>
            </div>
            <div class="row">
              <div class="col-xs-3 text-right">Objetivo Específico:</div>
              <div class="col-xs-9">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque mollis ipsum erat, in volutpat purus tempor ut. Aliquam leo leo, laoreet nullam</div>
            </div>
            <div class="row">
              <div class="col-xs-3 text-right">Temas:</div>
              <div class="col-xs-9">
                <ol>
                  <li>Tema 1</li>
                  <li>Tema 2</li>
                  <li>Tema 3</li>
                </ol>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-3 text-right">Apoyos:</div>
              <div class="col-xs-9">
                <ul>
                  <li><a href="#" title="Descargar archivo de apoyo"><i class="glyphicon glyphicon-cloud-download"></i> Apoyo 1</a></li>
                  <li><a href="#" title="Descargar archivo de apoyo"><i class="glyphicon glyphicon-cloud-download"></i> Apoyo 2</a></li>
                  <li><a href="#" title="Descargar archivo de apoyo"><i class="glyphicon glyphicon-cloud-download"></i> Apoyo 3</a></li>
                </ul>
              </div>
            </div>
          </div>
          <hr>
          <!-- Inicia Modulo -->
          <div class="row">
            <h3>Nombre del modulo 2</h3>
            <div class="row">
              <div class="col-xs-3 text-right">Objetivo General:</div>
              <div class="col-xs-9">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque mollis ipsum erat, in volutpat purus tempor ut. Aliquam leo leo, laoreet nullam</div>
            </div>
            <div class="row">
              <div class="col-xs-3 text-right">Objetivo Específico:</div>
              <div class="col-xs-9">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque mollis ipsum erat, in volutpat purus tempor ut. Aliquam leo leo, laoreet nullam</div>
            </div>
            <div class="row">
              <div class="col-xs-3 text-right">Temas:</div>
              <div class="col-xs-9">
                <ol>
                  <li>Tema 1</li>
                </ol>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-3 text-right">Apoyos:</div>
              <div class="col-xs-9">
                <ul>
                  <li><a href="#" title="Descargar archivo de apoyo"><i class="glyphicon glyphicon-cloud-download"></i> Apoyo 1</a></li>
                </ul>
              </div>
            </div>
          </div>
          <hr>
          <!-- Inicia Modulo -->
          <div class="row">
            <h3>Nombre del modulo 3</h3>
            <div class="row">
              <div class="col-xs-3 text-right">Objetivo General:</div>
              <div class="col-xs-9">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque mollis ipsum erat, in volutpat purus tempor ut. Aliquam leo leo, laoreet nullam</div>
            </div>
            <div class="row">
              <div class="col-xs-3 text-right">Objetivo Específico:</div>
              <div class="col-xs-9">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque mollis ipsum erat, in volutpat purus tempor ut. Aliquam leo leo, laoreet nullam</div>
            </div>
            <div class="row">
              <div class="col-xs-3 text-right">Temas:</div>
              <div class="col-xs-9">
                <ol>
                  <li>Tema 1</li>
                  <li>Tema 2</li>
                  <li>Tema 3</li>
                </ol>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-3 text-right">Apoyos:</div>
              <div class="col-xs-9">
                <ul>
                  <li><a href="#" title="Descargar archivo de apoyo"><i class="glyphicon glyphicon-cloud-download"></i> Apoyo 1</a></li>
                  <li><a href="#" title="Descargar archivo de apoyo"><i class="glyphicon glyphicon-cloud-download"></i> Apoyo 2</a></li>
                  <li><a href="#" title="Descargar archivo de apoyo"><i class="glyphicon glyphicon-cloud-download"></i> Apoyo 3</a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
  </div>
</div>
