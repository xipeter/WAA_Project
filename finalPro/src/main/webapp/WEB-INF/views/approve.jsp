<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<tiles:insertDefinition name="baseLayout">

	<tiles:putAttribute name="title">Approve</tiles:putAttribute>

	<tiles:putAttribute name="body">


		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading" id="heading-test">Restaurant Enable</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Approve</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${restaurants_disabled}" var="restaurant">
									<tr>
										<td>${restaurant.id}</td>
										<td>${restaurant.firstName}</td>
										<td>${restaurant.lastName }</td>


							
											<td><button class="btn btn-primary"
												onclick="update('${restaurant.userCredentials.username}',1)">enable</button></td>
									

									</tr>

								</c:forEach>


							</tbody>
						</table>
					</div>
					<!-- /.table-responsive -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>



		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading" id="heading-test">Restaurant Disabled</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Disable</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${restaurants}" var="restaurant">
									<tr>
										<td>${restaurant.id}</td>
										<td>${restaurant.firstName}</td>
										<td>${restaurant.lastName }</td>


							
											<td><button class="btn btn-danger" onclick="update('${restaurant.userCredentials.username}',0)"
												>disable</button></td>
									

									</tr>

								</c:forEach>


							</tbody>
						</table>
					</div>
					<!-- /.table-responsive -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>


	<script type="text/javascript"
	src="<spring:url value="/bootstrap/resource/js/ajax.js"/>"></script>

	</tiles:putAttribute>

</tiles:insertDefinition>