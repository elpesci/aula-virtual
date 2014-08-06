<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
<script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
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
            "oLanguage": espanol,
            "bProcessing": false,
            "bServerSide": false,
            "sort": "position",
            "sAjaxSource": "cursos/list",
            "aoColumns": [
                { "mData": "nombre" },
                { "mData": "objetivo" },
                { "mData": "cursoId",
                    "mRender": function (cursoId) {
                        return  '<a href="' + cursoId + '">' + cursoId + '</a>';
                    },
                    "class": "acciones-control",
                    "orderable": false
                }
            ]
        });
    });


</script>
<form:form action="" method="GET">
    <table width="100%" style="border: 3px;background: rgb(243, 244, 248);">
        <tr>
            <td>
                <table id="example" class="display" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th><spring:message htmlEscape="true" javaScriptEscape="true" code="paths.path.label"/></th>
                        <th><spring:message htmlEscape="true" javaScriptEscape="true" code="paths.goal.label"/></th>
                        <th><spring:message htmlEscape="true" javaScriptEscape="true" code="paths.actions.label"/></th>
                    </tr>
                    </thead>
                </table>
            </td>
        </tr>
    </table>
</form:form>