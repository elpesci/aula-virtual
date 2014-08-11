<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(document).ready(function() {
		$(".dismissFlash").click(function() 
		{
			$(this).parent().remove();
		});
	});
</script>

<div id="flashMessagesBox" class="grid_121 remsg"
	style="display: block;">
	<c:set value="${sessionScope['scopedTarget.flash']}" var="flash" />
	<c:if test="${flash.notEmpty}">
		<p class="center ${flash.type}">
			<spring:message code="${flash.message}"
				arguments="${flash.arguments}" />
			<a class="dismissFlash" href="javascript:void(0);"><spring:message
					code="label.dismiss" /> </a>
		</p>
	</c:if>
</div>

