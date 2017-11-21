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
		
		$("#orderDeliveryNumber").html("" + deliveryOrderId);
		$("#myModal").modal();
		
	}
	
	confirmOrder = function() {
		
		$("#emptyError").hide();
		
		if ($("#orderId").val() != "") {
			
			$("#emptyError").hide();
			
			var orderId = $("#orderDeliveryNumber").text();
			var orderTrackNumber = $("#orderId").val();
			
			$.ajax({
				type : 'post',
				url : contextRoot + '/completeOrderDelivery/' + orderId + '/' + orderTrackNumber,
				dataType : "json",
				contentType : 'application/json',
				success : function(response) {
					location.reload();
				},
				error : function(errorObject) {
					alert("error");
				}
			});
			
		} else {
			$("#emptyError").show();
		}

	}
	
});
	