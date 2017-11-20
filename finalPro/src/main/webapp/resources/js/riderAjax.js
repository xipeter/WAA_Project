$(document).ready(function(){
	
	var contextRoot = "/" + window.location.pathname.split('/')[1];
	
	acceptOrder = function(deliveryOrderId) {
				
		$.ajax({
			type : 'post',
			url : contextRoot + '/acceptOrderDelivery/' + deliveryOrderId,
			dataType : "json",
			contentType : 'application/json',
			success : function(response) {
				alert("working great");
				
				location.reload();
				
			},
			error : function(errorObject) {
				alert("ouch");
			}
		});
	}
	
	completeOrder = function(deliveryOrderId) {
		
		$.ajax({
			type : 'post',
			url : contextRoot + '/completeOrderDelivery/' + deliveryOrderId,
			dataType : "json",
			contentType : 'application/json',
			success : function(response) {
				alert("Completed!");
				
				location.reload();
				
			},
			error : function(errorObject) {
				alert("ouch");
			}
		});
	}
	
});
	