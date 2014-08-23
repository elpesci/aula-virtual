<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.css">
<script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.js"></script>

<script type="text/javascript">
    var espanol = {"sProcessing": "Procesando...",
        "sLengthMenu": "Mostrar _MENU_ registros",
        "sZeroRecords": "No se encontraron resultados",
        "sInfo": "Mostrando desde _START_ hasta _END_ de _TOTAL_ registros",
        "sInfoEmpty": "No existen registros",
        "sInfoFiltered": "(filtrado de un total de _MAX_ líneas)",
        "sInfoPostFix": "",
        "sSearch": "Buscar:",
        "sUrl": "",
        "oPaginate": {
            "sFirst": "Primero",
            "sLast": "Ultimo",
            "sNext": "Siguiente",
            "sPrevious": "Anterior"
        }
    };

    $(document).ready(function () {

        var dt = $("#example").dataTable({
            "sDom": 'R<C><"#buttonPlaceholder">H<"clear"><"ui-toolbar ui-widget-header ui-corner-tl ui-corner-tr ui-helper-clearfix"lfr>t<"ui-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix"ip>',
            "oLanguage": espanol,
            "bProcessing": false,
            "bServerSide": false,
            "sort": "position",
            "sAjaxSource": "cursos/list",
            "createdRow": function (row, data, index) {
                var contentIcon = $('<i/>');
                contentIcon.attr('class', 'fa fa-file-text-o');

                var contentLink = $('<a/>');
                myLink = "<c:url value='/cursos/" + data.id + "/contents'/>";
                contentLink.attr('href', myLink);
                contentLink.html(contentIcon);
                contentLink.html('Contenido');
                $(row).find('.acciones-control').append(contentLink);

                <sec:authorize access="hasRole('SUPER_ADMIN')">
                var editIcon = $('<i/>');
                editIcon.attr('class', 'fa fa-pencil-square-o');

                var editLink = $('<a/>');
                myLink = "<c:url value='/cursos/" + data.id + "/edit'/>";
                editLink.attr('href', myLink);
                editLink.html(editIcon);
                editLink.html('Editar');
                $(row).find('.acciones-control').append(editLink);
                </sec:authorize>
            },
            "aoColumns": [
                { "mData": "name" },
                { "mData": "goal" },
                { "mData": "id",
                    "mRender": function (id) {
                        return  '<div id="contentLink_' + id + '"/>';
                    },
                    "class": "acciones-control",
                    "orderable": false
                }
            ]
        });

        <sec:authorize access="hasRole('SUPER_ADMIN')">
        var buttonPlaceholder = $("#buttonPlaceholder").html("<a id='add'><span class='glyphicon glyphicon-plus'></span> Agregar curso</a>");
        $('#add').attr('href', '<c:url value='/cursos/add'/>').attr('class', 'btn btn-primary btn-sm').attr('title','Haga click para agregar un nuevo curso');
        $("#buttonPlaceholder").attr('style', 'float:right; padding-left:10px;');
        </sec:authorize>
    });
</script>

<div class="container-fliud">
    <div class="row">
        <div class="col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <spring:message javaScriptEscape="true" code="course.heading.label"/>
                    </h3>
                </div>
                <div class="panel-body">
                    <form:form action="" method="GET">
                        <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th><spring:message javaScriptEscape="true" code="course.course.label"/></th>
                                <th><spring:message javaScriptEscape="true" code="course.goal.label"/></th>
                                <th><spring:message javaScriptEscape="true" code="course.actions.label"/></th>
                            </tr>
                            </thead>
                        </table>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>