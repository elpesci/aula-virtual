<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<div id="footer">
    <p>
        <b><a href="http://www.oaxaca.gob.mx">oaxaca.gob.mx</a></b>
        <br />
        <spring:message javaScriptEscape="true" code="footer.goboax.main.label" />
        <br />
        <spring:message javaScriptEscape="true" code="footer.goboax.location.label"/>
        <br /> 
        <spring:message javaScriptEscape="true" code="footer.goboax.address1.label"/>
        <br />
        <spring:message javaScriptEscape="true" code="footer.goboax.phone.label"/>
    </p>
</div>

<div id=blockUI style="display: none;">
    <h1>
        <img src="<c:url value="/resources/img/busy.gif"/>" />
        <spring:message htmlEscape="true" javaScriptEscape="true"
            code="label.wait" />
    </h1>
</div>
<script type="text/javascript">
    var strings = new Array();
    strings['label.dismiss'] = "<spring:message code='label.dismiss' javaScriptEscape='true' />";

    $('form').submit(function(event) {
        $.blockUI({
            message : $('#blockUI')
        });
    });
</script>