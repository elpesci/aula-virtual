<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="/WEB-INF/views/common/datatable_options.jsp" %>

<link rel="stylesheet" type="text/css"
      href="//cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.css">
<script type="text/javascript" src="//cdn.datatables.net/1.10.2/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.js"></script>

<script type="text/javascript">
    $(document).ready(function () {

        var dt = $("#examsTable").dataTable({
            "sDom": 'R<C><"#buttonPlaceholder">H<"clear"><"ui-toolbar ui-widget-header ui-corner-tl ui-corner-tr ui-helper-clearfix">lfrt<"ui-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix">ip',
            "oLanguage": espanol,
            "bProcessing": false,
            "bServerSide": false,
            "sort": "position",
            "sAjaxSource": "motorEval/list",
            "createdRow": function (row, data, index) {
                <sec:authorize access="hasRole('SUPER_ADMIN') || hasRole('COORDINADOR')">
                var settingsIcon = '<span class="fa-stack fa-lg"><i class="fa fa-square-o fa-stack-2x"></i><i class="fa fa-cog fa-stack-1x"></i></span>';

                var settingsLink = $('<a/>');
                myLink = "<c:url value='/motorEval/configEdit/" + data.id + "'/>";
                settingsLink.attr('href', myLink);
                settingsLink.attr('title', 'Configurar parámetros de examen');
                settingsLink.html(settingsIcon);

                $(row).find('.acciones-control').append(settingsLink);
                $(row).find('.acciones-control').append('&nbsp;&nbsp;');

                var questionsIcon = '<span class="fa-stack fa-lg"><i class="fa fa-square-o fa-stack-2x"></i><i class="fa fa-pencil fa-stack-1x"></i></span>';

                var questionsLink = $('<a/>');
                myLink = "<c:url value='/motorEval/preguntasEdit/" + data.id + "'/>";
                questionsLink.attr('href', myLink);
                questionsLink.attr('title', 'Agregar preguntas al examen');
                questionsLink.html(questionsIcon);

                $(row).find('.acciones-control').append(questionsLink);
                </sec:authorize>
            },
            "pagingType": "simple_numbers",
            "aoColumns": [
                { "mData": "courseName", "width": "30%" },
                { "mData": "moduleName", "width": "30%" },
                { "mData": "settings", "width": "30%", "orderable": false },
                { "mData": "id",
                    "mRender": function (id) {
                        return  '<div id="testLink_' + id + '"/>';
                    },
                    "class": "acciones-control",
                    "orderable": false,
                    "width": "10%"
                }
            ]
        });

        <sec:authorize access="hasRole('SUPER_ADMIN') || hasRole('COORDINADOR')">
        var buttonPlaceholder = $("#buttonPlaceholder").html("<a id='add'><span class='glyphicon glyphicon-plus'></span> Agregar examen</a>");
        $('#add').attr('href', '<c:url value='/motorEval/add'/>').attr('class', 'btn btn-primary btn-sm').attr('title', 'Haga click para agregar un nuevo examen');
        $("#buttonPlaceholder").attr('style', 'float:right; padding-left:10px;');
        </sec:authorize>
    });
</script>

<div class="container-fliud">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <i class="fa fa-check-square-o"></i>
                        <spring:message javaScriptEscape="true" code="testEngine.landing.heading.label"/>
                    </h3>
                </div>
                <div class="panel-body">
                    <div>
                        <form:form action="" method="GET">
                        <table id="examsTable" class="table table-striped table-bordered display" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th><spring:message javaScriptEscape="true" code="testEngine.landing.dataTable.col1Header.label"/></th>
                                <th><spring:message javaScriptEscape="true" code="testEngine.landing.dataTable.col2Header.label"/></th>
                                <th><spring:message javaScriptEscape="true" code="testEngine.landing.dataTable.col3Header.label"/></th>
                                <th><spring:message javaScriptEscape="true" code="testEngine.landing.dataTable.col4Header.label"/></th>
                            </tr>
                            </thead>
                        </table>
                    </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>