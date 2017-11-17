<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>

	<div class="container">
		<security:authorize access="isAnonymous()">
			<a href="<spring:url value='/login' />"
				class="btn btn-default pull-right"> Login</a>
		</security:authorize>


		<a href="<spring:url value='/restaurant'/>" class="btn btn-default">
			<span class="glyphicon-hand-left glyphicon"></span> Restaurant
		</a> <a href="<spring:url value='/delivererHome'/>"
			class="btn btn-default"> <span
			class="glyphicon-hand-left glyphicon"></span> Deliver
		</a>
	</div>
	<div class="container">
		<security:authorize access="isAuthenticated()">
  					Welcome  <security:authentication property="principal.username" />
		</security:authorize>
		<spring:url value="/dologout" var="logout_url" />				
  		<form:form action="${logout_url}" class="form-horizontal" method="POST">
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd"
						class="btn btn-danger btn-mini  pull-right" value="Logout" />
				</div>
			</div>
		</form:form>
	</div>
	<div class="pull-left"> <h3>${intercepterMessage}</h3> </div>


</body>
</html>