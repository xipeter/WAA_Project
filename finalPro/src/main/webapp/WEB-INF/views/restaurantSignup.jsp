<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to TaoBao</title>

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
	<div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<spring:url value='/' />">Welcome to Taobao Tracking System</a>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Track No i.e 123 xxx xxx">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="<spring:url value='/login' />"><i class="fa fa-sign-in fa-fw"></i> Login</a>
                        </li>
                        <li>
                            <a href="<spring:url value='/restaurantSignup' />"><i class="fa fa-users fa-fw"></i> Become our Partner</a>
                        </li>
                        <li>
                            <a href="<spring:url value='/riderSignup' />"><i class="fa fa-car  fa-fw" ></i> Become our Rider</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Restaurant Form</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Restaurant Detail
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form:form modelAttribute="restaurant" action="restaurantSignup" method="post">
                                    		<fieldset>
	                                        <div class="form-group col-lg-4">
	                                            <label>Restaurant Name</label>
	                                            <form:input class="form-control" placeholder="i.e Panda Chinese Food" path="name" type="text"/>
	                                            <form:errors path="name" cssStyle="color : red;" />
	                                        </div>
	                                        <div class="form-group col-lg-4">
	                                            <label>Restaurant Owner First Name</label>
	                                            <form:input class="form-control" placeholder="i.e A Ey" path="firstName"/>
	                                            <form:errors path="firstName" cssStyle="color : red;" />
	                                        </div>
	                                        <div class="form-group col-lg-4">
	                                            <label>Restaurant Owner Last Name</label>
	                                            <form:input class="form-control" placeholder="i.e Sun" path="lastName"/>
	                                            <form:errors path="lastName" cssStyle="color : red;" />
	                                        </div>
	                                        <div class="form-group col-lg-4">
	                                            <label>Restaurant Address</label>
	                                            <form:input class="form-control" placeholder="i.e 1000th 4th North Street, Fairfield, 52557,IA " path="address"/>
	                                            <form:errors path="address" cssStyle="color : red;" />
	                                        </div>
	                                        <div class="form-group col-lg-4">
	                                            <label>Email</label>
	                                            <form:input class="form-control" placeholder="i.e panda@gmail.com" path="email"/>
	                                            <form:errors path="email" cssStyle="color : red;" />
	                                        </div>
	                                        <div class="form-group col-lg-4">
	                                            <label>Phone</label>
	                                            <form:input class="form-control" placeholder="i.e 515770918" path="phone"/>
	                                            <form:errors path="phone" cssStyle="color : red;" />
	                                        </div>
	                                        <div class="form-group col-lg-4">
												<label>Password</label>
												<form:input path="userCredentials.password" class="form-control" type="password" />
												<form:errors path="userCredentials.password" cssStyle="color : red;" />
											</div>
											<div class="form-group col-lg-4">
												<label>Verify password</label>
												<form:input path="userCredentials.verifyPassword" class="form-control" type="password" />
												<form:errors path="userCredentials.verifyPassword" cssStyle="color : red;" />
											</div>
											<div class="form-group col-lg-8">
	                                            <label>Note</label>
	                                            <form:textarea class="form-control" rows="3" path="note"/>
	                                            <form:errors path="note" cssStyle="color : red;" />
	                                        </div>
	                                        <div class="form-group col-lg-12">
	                                            <input type="reset" class="btn btn-default" value="Reset"/>
	                                            <input type="submit" class="btn btn-default" value="Submit"/>
	                                        </div>
	                                    </fieldset>
                                        <security:csrfInput/>
                                    </form:form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->]

    </div>


</body>
</html>