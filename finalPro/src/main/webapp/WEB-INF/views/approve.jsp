<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<tiles:insertDefinition name="baseLayout">

	<tiles:putAttribute name="title">Approve</tiles:putAttribute>

	<tiles:putAttribute name="body">
	
	<script type="text/javascript"
	src="<spring:url value="/bootstrap/resource/js/ajax.js"/>"></script>

		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading" id="heading-test">Restaurant Approve</div>
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
								<c:forEach items="${restaurants}" var="restaurant">

									<tr>
										<td>${restaurant.id}</td>
										<td>${restaurant.firstName}</td>
										<td>${restaurant.lastName }</td>
										<c:if test="${restaurant.id==1}">
											<td><button value="/enable/${restaurant.id}">enable</button></td>
										</c:if>

										<c:if test="${restaurant.id==2}">
											<td><a
												href="<spring:url value='disable/${restaurant.id}'/>">disable</a></td>
										</c:if>

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
				<div class="panel-heading">Delivery Guy Approve</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Username</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>Mark</td>
									<td>Otto</td>
									<td>@mdo</td>
								</tr>
								<tr>
									<td>2</td>
									<td>Jacob</td>
									<td>Thornton</td>
									<td>@fat</td>
								</tr>
								<tr>
									<td>3</td>
									<td>Larry</td>
									<td>the Bird</td>
									<td>@twitter</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- /.table-responsive -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>


	</tiles:putAttribute>

</tiles:insertDefinition>