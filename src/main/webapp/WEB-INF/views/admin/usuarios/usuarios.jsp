<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="/WEB-INF/views/common/datatable_options.jsp" %>

<link rel="stylesheet" type="text/css"
      href="//cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.css">
<script type="text/javascript" src="//cdn.datatables.net/1.10.2/js/jquery.dataTables.js"></script>
<script type="text/javascript"
        src="//cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.js"></script>

<script type="text/javascript">
    $(document).ready(function () {

        var dt = $("#course_table").dataTable({
            "sDom": 'R<C><"#buttonPlaceholder">H<"clear"><"ui-toolbar ui-widget-header ui-corner-tl ui-corner-tr ui-helper-clearfix">lfrt<"ui-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix">ip',
            "oLanguage": espanol,
            "bProcessing": false,
            "bServerSide": false,
            "sort": "position",
            "sAjaxSource": "usuario/list",
            "createdRow": function (row, data, index) {
                <sec:authorize access="hasRole('SUPER_ADMIN')">
                var editIcon = '<span class="fa-stack fa-lg"><i class="fa fa-square-o fa-stack-2x"></i><i class="fa fa-pencil fa-stack-1x"></i></span>';

                var editLink = $('<a/>');
                myLink = "<c:url value='/usuario/edit/" + data.id + "'/>";
                editLink.attr('href', myLink);
                editLink.attr('title', 'Actualizar información del usuaio');
                editLink.html(editIcon);

                $(row).find('.acciones-control').append(editLink);
                $(row).find('.acciones-control').append('&nbsp;&nbsp;');
                </sec:authorize>
            },
            "pagingType": "simple_numbers",
            "aoColumns": [
                { "mData": "name" },
                { "mData": "username" },
                { "mData": "profile"},
                { "mData": "status"},
                { "mData": "accessGranted", 
                  "mRender": function(accessGranted) {
                      return (accessGranted === true) 
                        ? '<span><i class="fa fa fa-check streetLight_green"></i> Sí</span>' 
                        : '<span><i class="fa fa fa-ban streetLight_red"></i> No</span>';
                  },
                  "orderable": false,
                  "width": "10%"},
                { "mData": "id",
                    "mRender": function (id) {
                        return  '<div id="contentLink_' + id + '"/>';
                    },
                    "class": "acciones-control",
                    "orderable": false,
                    "width": "10%"
                }
            ]
        });

        var buttonPlaceholder = $("#buttonPlaceholder").html("<a id='add'><i class='fa fa-2x fa-user-plus'></i> Registrar Usuario</a>");
        $('#add').attr('href', '<c:url value='/login/registration'/>').attr('class', 'btn btn-primary btn-sm').attr('title', 'Haga click para registrar un nuevo usuario');
        $("#buttonPlaceholder").attr('style', 'float:right; padding-left:10px;');
    });
</script>

<div class="container-fliud">
    <div class="row">
        <div class="col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <i class="fa fa-users"></i>
                        <spring:message javaScriptEscape="true" code="usuario.heading.label"/>
                    </h3>
                </div>
                <div class="panel-body">
                    <form:form action="" method="GET">
                        <table id="course_table" class="table table-striped table-bordered display" cellspacing="0"
                               width="100%">
                            <thead>
                            <tr>
                                <th><spring:message javaScriptEscape="true" code="usuario.username.label"/></th>
                                <th><spring:message javaScriptEscape="true" code="usuario.fullName.label"/></th>
                                <th><spring:message javaScriptEscape="true" code="usuario.profile.label"/></th>
                                <th><spring:message javaScriptEscape="true" code="usuario.status.label"/></th>
                                <th><spring:message javaScriptEscape="true" code="usuario.accessGranted.label"/></th>
                                <th><spring:message javaScriptEscape="true" code="label.actions"/></th>
                            </tr>
                            </thead>
                        </table>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>