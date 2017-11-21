$(document).ready(function(){
	var getProfile = function (){
	   	var contextRoot = "/" + window.location.pathname.split( '/' )[1];
		$.ajax({
			type : 'GET',
			url : contextRoot + '/restaurantProfile',
			dataType : 'json',
			contentType : 'application/json',
			success: function(respond){
				console.log(respond);
				$("#id").val(respond.id);
				$("#restaurantName").val(respond.name);
				$("#firstName").val(respond.firstName);
				$("#lastName").val(respond.lastName);
				$("#address").val(respond.address);
				$("#email").val(respond.email);
				$("#note").val(respond.note);
			},
			error : function(error) {
				console.debug(error);
				console.log(error.responseJSON.errorType);
				if (error.responseJSON.errorType == "ValidationError") {
					var errors = error.responseJSON.errors;
					$.each(errors, function(i, error){
						$("#modalBody").append("<div class='alert alert-success alert-dismissable'>" +error+"</div>");
					});
				} else {
					alert(error.responseJSON.errors(0));
				}
			}
		}).then(function(){
			if(respond !== null){
				$("#myModal").modal();
			}
		});
	};
	
	var sendRequest = function(id){
		var contextRoot = "/" + window.location.pathname.split( '/' )[1];
		$.ajax({
			type : 'GET',
			url : contextRoot + '/restaurantProfile',
			dataType : 'json',
			contentType : 'application/json',
			success: function(respond){
				console.log(respond);
			},
			error : function(error) {
				console.debug(error);
				if (error.responseJSON.errorType == "ValidationError") {
					var errors = error.responseJSON.errors;
					$.each(errors, function(i, error){
						$("#modalBody").append("<div class='alert alert-success alert-dismissable'>" +error+"</div>");
					});
				} else {
					alert(error.responseJSON.errors(0));
				}
			}
		});
	};
	
	
	$("#profile").click(getProfile);
});
	