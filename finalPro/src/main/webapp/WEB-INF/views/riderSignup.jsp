<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<spring:url value='/bootstrap/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
	<link href="<spring:url value='/bootstrap/vendor/metisMenu/metisMenu.min.css'/>" rel="stylesheet">
	<link href="<spring:url value='/bootstrap/dist/css/sb-admin-2.css'/>" rel="stylesheet">
	<link href="<spring:url value='/bootstrap/front/vendor/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">
	<script src="<spring:url value='/bootstrap/vendor/jquery/jquery.min.js'/>"></script>
	<script src="<spring:url value='/bootstrap/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
	<script src="<spring:url value='/bootstrap/vendor/metisMenu/metisMenu.min.js'/>"></script>
	<script src="<spring:url value='/bootstrap/dist/js/sb-admin-2.js'/>"></script>
<title>Rider registration</title>
</head>
<body>
	<div id="page-wrapper">
		<div class="row">
	    		<div class="col-lg-12">
	    			<h1 class="page-header">Become a Taobao Rider</h1>
	    		</div>
	    </div>
	    <div class="row">
		    <div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						Rider registration
					</div>
					<div class="panel-body">
						<form:form modelAttribute="newRider" action="processRider" method="post">
							<div class="form-group">
								<label>First name</label>
								<form:input path="firstName" class="form-control" />
								<div style="text-align: center;">
									<form:errors path="firstName" cssStyle="color : red;" />
								</div>
							</div>
							<div class="form-group">
								<label>Last name</label>
								<form:input path="lastName" class="form-control" />
								<div style="text-align: center;">
									<form:errors path="lastName" cssStyle="color : red;" />
								</div>
							</div>
							<div class="form-group">
								<label>Email</label>
								<form:input path="email" class="form-control" />
								<div style="text-align: center;">
									<form:errors path="email" cssStyle="color : red;" />
								</div>
							</div>
							<div class="form-group">
								<label>Password</label>
								<form:input path="userCredentials.password" class="form-control"
									type="password" />
								<div style="text-align: center;">
									<form:errors path="userCredentials.password" cssStyle="color : red;" />
								</div>
							</div>
							<div class="form-group">
								<label>Verify password</label>
								<form:input path="userCredentials.verifyPassword"
									class="form-control" type="password" />
								<div style="text-align: center;">
									<form:errors path="userCredentials.verifyPassword" cssStyle="color : red;" />
								</div>
							</div>
							<input id="submit" type="submit" tabindex="5" value="Create" />
						</form:form>
					</div>
				</div>
			</div>
	    </div>
	</div>
</body>
