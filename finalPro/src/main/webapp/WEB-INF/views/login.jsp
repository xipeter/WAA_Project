<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Taobao Login</title>

<!-- Bootstrap Core CSS -->
<link href="<spring:url value='/bootstrap/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="<spring:url value='/bootstrap/vendor/metisMenu/metisMenu.min.css'/>" rel="stylesheet">
<!-- Custom CSS -->
<link href="<spring:url value='/bootstrap/dist/css/sb-admin-2.css'/>" rel="stylesheet">
<!-- Custom Fonts -->
<link href="<spring:url value='/bootstrap/front/vendor/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

<!-- jQuery -->
<script src="<spring:url value='/bootstrap/vendor/jquery/jquery.min.js'/>"></script>
<!-- Bootstrap Core JavaScript -->
<script src="<spring:url value='/bootstrap/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="<spring:url value='/bootstrap/vendor/metisMenu/metisMenu.min.js'/>"></script>
<!-- Custom Theme JavaScript -->
<script src="<spring:url value='/bootstrap/dist/js/sb-admin-2.js'/>"></script>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title"><spring:message code="login.title"/></h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
							</div>
						</c:if>
						<form action="<spring:url value="/postLogin"></spring:url>" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="<spring:message code="login.label.username"/>"
										name="username" type="text" autofocus />
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="<spring:message code="login.label.password"/>"
										name="password" type="password" value="" />
								</div>
								<div class="checkbox">
									<label> <input name="keepMe" type="checkbox" value="Remember Me"/><spring:message code="login.label.rememberMe"/>
									</label>
								</div>
								<!-- Change this to a button or input when using this as a form -->
								<input class="btn btn-lg btn-success btn-block" type="submit" value="<spring:message code="login.label.login"/>" />
							</fieldset>
							<security:csrfInput />
						</form>
					</div>
					<div class="text-right panel-footer">
						<a class="btn btn-outline btn-primary btn-sm" href="?language=ms_MY">Malayu (MY)</a>
						<a class="btn btn-outline btn-primary btn-sm" href="?language=en_US">English (US)</a>
						<a class="btn btn-outline btn-primary btn-sm" href="?language=zh_CN">Chinese (CH)</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
