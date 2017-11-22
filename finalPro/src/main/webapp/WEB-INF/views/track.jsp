<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
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
                         <form action="track" method="get">
                            <div class="input-group custom-search-form">
                           
                                <input type="text" class="form-control" placeholder="Track No i.e 123 xxx xxx" name="number">
                                <span class="input-group-btn">
	                                <button class="btn btn-default" type="submit">
	                                    <i class="fa fa-search"></i>
	                                </button>
	                                <!-- <a class="btn btn-default" type="submit" value="track">
	                                    <i class="fa fa-search">11</i>
	                                </a> -->
                            		</span>
                            </div>
                            </form>
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
                    <h1 class="page-header">Tracking Package</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <!-- /.row -->
		<div class="row">




			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-clock-o fa-fw"></i> Responsive Timeline
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<ul class="timeline">
						<li>
							<div class="timeline-badge">
								<i class="fa fa-check"></i>
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4 class="timeline-title">Order Created</h4>
									<p>
										<small class="text-muted"><i class="fa fa-clock-o"></i>
											1 hours ago via Taobao</small>
									</p>
								</div>
								<div class="timeline-body">
									<p>Initial the order.</p>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-badge warning">
								<i class="fa fa-credit-card"></i>
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4 class="alert alert-danger">
										New Status-

										<c:choose>
											<c:when test="${status.status.id==1}">
									NEW
									</c:when>
											<c:when test="${status.status.id==2}">
									RIDING
									</c:when>
											<c:when test="${status.status.id==3}">
									DONE
									</c:when>
										</c:choose>

									</h4>
								</div>
								<div class="timeline-body">

									<h4>Customer Name</h4>
									<blockquote>
										<small>${status.customerName} </small>

									</blockquote>
									<h4>Address</h4>
									<blockquote>
										<small>${status.address}</small>
									</blockquote>
									<h4>Delivery Guy</h4>
									<blockquote>
										<small>${rider.firstName } ${rider.lastName }-${rider.email }</small>
									</blockquote>
									

								</div>
							</div>
						</li>

					</ul>
				</div>
				<!-- /.panel-body -->
			</div>




		</div>
            
            

        </div>
        <!-- /#page-wrapper -->]

    </div>


</body>
</html>