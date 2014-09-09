<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
            "pagingType": "simple_numbers",
            "aoColumns": [
                { "mData": "name" },
                { "mData": "username" },
                { "mData": "profile"}
            ]
        });

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
                        <table id="course_table" class="table table-striped table-bordered display" cellspacing="0"
                               width="100%">
                            <thead>
                            <tr>
                                <th><spring:message javaScriptEscape="true" code="usuario.username.label"/></th>
                                <th><spring:message javaScriptEscape="true" code="usuario.fullName.label"/></th>
                                <th><spring:message javaScriptEscape="true" code="usuario.profile.label"/></th>
                            </tr>
                            </thead>
                        </table>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>