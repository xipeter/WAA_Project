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
	
	
	$("#profile").click(getProfile);
});
	