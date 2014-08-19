<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div id="forgetpassword_div">
	<fieldset>
		<form:form method="POST" action="${target}"
			commandName="forgetPasswordForm">
			<div class="form-group">
				<form:label path="email" cssClass="col-sm-4 control-label">
					<spring:message htmlEscape="true" javaScriptEscape="true"
						code="label.email" />
					<span class="error"><form:errors path="email" /></span>
				</form:label>
				<div class="col-sm-8">
					<form:input path="email" cssClass="form-control"
						cssErrorClass="fieldError" size="45" />
				</div>
			</div>

			<div class="form-group">
				<input type="submit" name="save" class="btn btn-primary"
					value="<spring:message htmlEscape="true" javaScriptEscape="true" code="send"/>" />
				<input type="submit" name="cancel" class="btn btn-danger"
					value="<spring:message htmlEscape="true" javaScriptEscape="true" code="cancel"/>" />
			</div>
		</form:form>
	</fieldset>
</div>