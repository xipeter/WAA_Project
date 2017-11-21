<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
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
	<script type="text/javascript" src="<spring:url value="/resources/js/riderAjax.js"/>"></script>
	<title>Rider home</title>
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
                <a class="navbar-brand" href="<spring:url value='/restaurant'/>">Restaurant</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">

                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a id="profile"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                        		<spring:url value="/dologout" var="logout_url" />
							<a href="${logout_url}"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-plus-circle fa-fw"></i> New Request</a>
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-list-ul fa-fw"></i> Request List</a>
                        </li>
                        <!-- <li>
                            <a href="index.html"><i class="fa fa-dashboard  fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Flot Charts</a>
                                </li>
                                <li>
                                    <a href="morris.html">Morris.js Charts</a>
                                </li>
                            </ul>
                            /.nav-second-level
                        </li> -->
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
	<div id="page-wrapper">
		<div class="row">
	    		<div class="col-lg-12">
	    			<h1 class="page-header">Rider home</h1>
	    		</div>
	    </div>
	    <div class="row">
        		<div class="col-lg-6">
            		<div class="panel panel-default">
                		<div class="panel-heading">
                     	Available Delivery orders
                 	</div>
                 	<div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Customer</th>
                                            <th>Restaurant</th>
                                            <th>Address</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	   <c:forEach var="order" items="${requestedOrders}">
                                    	   		<tr>
	                                            <td>${order.id}</td>
	                                            <td>${order.customerName}</td>
	                                            <td>${order.restaurant.name}</td>
	                                            <td>${order.address}</td>
	                                            <td>
	                                            		<button class="btn btn-primary" onclick="acceptOrder('${order.id}')">Accept</button>
	                                            </td>
                                        		</tr>		
                                    	   </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
            		</div>
        		</div>
        </div>
        
        <div class="row">
        		<div class="col-lg-6">
            		<div class="panel panel-default">
                		<div class="panel-heading">
                     	Current deliveries
                 	</div>
                 	<div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Customer</th>
                                            <th>Restaurant</th>
                                            <th>Address</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	   <c:forEach var="order" items="${currentOrders}">
                                    	   		<tr>
	                                            <td>${order.id}</td>
	                                            <td>${order.customerName}</td>
	                                            <td>${order.restaurant.name}</td>
	                                            <td>${order.address}</td>
	                                            <td>
	                                            		<button class="btn btn-primary" onclick="completeOrder('${order.id}')">Complete</button>
	                                            </td>
                                        		</tr>		
                                    	   </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
            		</div>
        		</div>
        </div>
	</div>
	</div>
	<!-- Modal -->
      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog">
              <div class="modal-content">
                  <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                      <h4 class="modal-title" id="myModalLabel">Delivery completion</h4>
                  </div>
                  <div class="modal-body" id="modalBody">
                  	<p>Confirm the delivery order #<span id="orderDeliveryNumber"></span> is complete.</p>
                  	<form action="">
                  		<div class="form-group">
                         	<label>Customer's order track number</label>
                             <input class="form-control" type="text" id="orderId">
                         </div>
                  	</form>
                  	<div class='alert alert-success alert-dismissable' id="emptyError" hidden> Enter a valid delivery order ID </div>
                  </div>
                  <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                      <button type="button" class="btn btn-primary" onclick="confirmOrder()">Finish</button>
                  </div>
              </div>
              <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
      </div>
     <!-- /.modal -->
</body>
</html>