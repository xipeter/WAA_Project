<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>

<tiles:insertDefinition name="baseLayout">

	<tiles:putAttribute name="title">Notificationst</tiles:putAttribute>

	<tiles:putAttribute name="body">


		<div class="row">
			<div class="col-lg-12">
			
			                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Send Successfully ${emailSent.historys}
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="alert alert-success">
                            email has been send to
                            <c:forEach items="${emailSent.historys}" var="history">
                            	<a href="#" class="alert-link">${history.email} </a>. <br/>
                            </c:forEach>
                                  
                            </div>
							<a class="btn btn-danger" href="<spring:url value='/sendmailForm'/>">Back</a>
                        </div>
                        <!-- .panel-body -->
                        
                        
                    </div>

			</div>
		</div>






	</tiles:putAttribute>

</tiles:insertDefinition>