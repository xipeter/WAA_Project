<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Tracking package</title>

<link
	href="<spring:url value='/bootstrap/vendor/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet">
<!-- MetisMenu CSS -->
<link
	href="<spring:url value='/bootstrap/vendor/metisMenu/metisMenu.min.css'/>"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="<spring:url value='/bootstrap/dist/css/sb-admin-2.css'/>"
	rel="stylesheet">
<!-- Custom Fonts -->
<link
	href="<spring:url value='/bootstrap/front/vendor/font-awesome/css/font-awesome.min.css'/>"
	rel="stylesheet" type="text/css">
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script
	src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

<!-- jQuery -->
<script
	src="<spring:url value='/bootstrap/vendor/jquery/jquery.min.js'/>"></script>
<!-- Bootstrap Core JavaScript -->
<script
	src="<spring:url value='/bootstrap/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
<!-- Metis Menu Plugin JavaScript -->
<script
	src="<spring:url value='/bootstrap/vendor/metisMenu/metisMenu.min.js'/>"></script>
<!-- Custom Theme JavaScript -->
<script src="<spring:url value='/bootstrap/dist/js/sb-admin-2.js'/>"></script>

</head>

<body>



	<div id="page-wrapper">

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Tracking Status</h1>
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
									<h4 class="timeline-title">Lorem ipsum dolor</h4>
									<p>
										<small class="text-muted"><i class="fa fa-clock-o"></i>
											11 hours ago via Twitter</small>
									</p>
								</div>
								<div class="timeline-body">
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit. Libero laboriosam dolor perspiciatis omnis
										exercitationem. Beatae, officia pariatur? Est cum veniam
										excepturi. Maiores praesentium, porro voluptas suscipit facere
										rem dicta, debitis.</p>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-badge warning">
								<i class="fa fa-credit-card"></i>
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4 class="timeline-title">Lorem ipsum dolor</h4>
								</div>
								<div class="timeline-body">
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit. Autem dolorem quibusdam, tenetur commodi provident
										cumque magni voluptatem libero, quis rerum. Fugiat esse
										debitis optio, tempore. Animi officiis alias, officia
										repellendus.</p>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit. Laudantium maiores odit qui est tempora eos, nostrum
										provident explicabo dignissimos debitis vel! Adipisci eius
										voluptates, ad aut recusandae minus eaque facere.</p>
								</div>
							</div>
						</li>
						
					</ul>
				</div>
				<!-- /.panel-body -->
			</div>




		</div>

	</div>
	<!-- /#page-wrapper -->






</body>
</html>
