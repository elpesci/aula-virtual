<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.2/css/jquery.dataTables.css">
<script type="text/javascript" src="//cdn.datatables.net/1.10.2/js/jquery.dataTables.js"></script>

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
            "sAjaxSource": "content/list",
            "createdRow": function (row, data, index) {
                var contentLink = $('<a/>');
                myLink = "<c:url value='/cursos/content/download/" + data.id + "'/>";
                contentLink.attr('href', myLink);
                contentLink.html('Descargar');
                $(row).find('.acciones-control').append(contentLink);
            },
            "aoColumns": [
                { "mData": "name" },
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
        var buttonPlaceholder = $("#buttonPlaceholder").html("<a id=add>Agregar</a>");
        myLink = "<c:url value='/cursos/" + ${courseId} + "/content/add' />";
        $('#add').attr('href', myLink);
        </sec:authorize>
    });


</script>
<form:form action="" method="GET">
    <table width="100%" style="border: 3px;background: rgb(243, 244, 248);">
        <tr>
            <td>
                <table id="example" class="display" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th><spring:message htmlEscape="true" javaScriptEscape="true" code="content.name.label"/></th>
                        <th><spring:message htmlEscape="true" javaScriptEscape="true"
                                            code="contentent.download.label"/></th>
                    </tr>
                    </thead>
                </table>
            </td>
        </tr>
    </table>
</form:form>