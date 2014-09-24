<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<div id="footer">
    <p>
        <b><a href="http://www.oaxaca.gob.mx">oaxaca.gob.mx</a></b><br />
        GOBIERNO DEL ESTADO DE OAXACA 2010-2016 <br /> Centro Administrativo
        del Poder Ejecutivo y Judicial &quot;General Porfirio D�az, Soldado de
        la Patria&quot; Edificio &quot;D&quot; Sa�l Mart�nez<br /> Avenida
        Gerardo Pandal Graff #1, Reyes Mantec�n, San Bartolo Coyotepec,
        Centro, Oaxaca. C.P. 71257<br /> Conmutador (951) 50 1 69 00
    </p>
    <p>
        Build number: ${buildNumber}
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