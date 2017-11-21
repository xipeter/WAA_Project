<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>

<tiles:insertDefinition name="baseLayout">

	<tiles:putAttribute name="title">Email Management</tiles:putAttribute>

	<tiles:putAttribute name="body">


		<div class="row">
			<div class="col-lg-6">
				<form:form  modelAttribute="emailobj" action = "sendmailForm" method="post">

					<div class="form-group">
						<label>Multiple User</label> 
						<form:select multiple = "true" class="form-control" path = "historys" items="${restaurants}" itemLabel="email"  itemValue="email" />
							
					</div>

					<div class="form-group">
						<label>Subject</label> <form:input class="form-control" path="subject" />
						<p class="help-block">please input your subject of email</p>
						<form:errors path="subject" cssStyle="color : red;"  />
					</div>
					<div class="form-group">
						<label>content</label> <form:input
							class="form-control" placeholder="Enter text" path = "content" />
					</div>
					<div class="form-group">
					
					<input type="submit" class="btn btn-info" value="send" />
					
					</div>
				</form:form>
			</div>
		</div>





		<script type="text/javascript"
			src="<spring:url value="/bootstrap/resource/js/ajax.js"/>"></script>

	</tiles:putAttribute>

</tiles:insertDefinition>