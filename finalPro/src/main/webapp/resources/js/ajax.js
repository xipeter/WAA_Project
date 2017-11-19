function getProfile(){
   	var contextRoot = "/" + window.location.pathname.split( '/' )[1];
	$.ajax({
		type : 'GET',
		url : contextRoot + '/profile',
		dataType : "json",
		contentType : 'application/json',
		success: function(respond){
			console.log(respond);
		},
		error : function(error) {
			console.log(error.responseJSON.errorType);
			if (error.responseJSON.errorType == "ValidationError") {

			} else {
				alert(error.responseJSON.errors(0));
	
			}
		}
	});
};

function showModalProfile(){
	getProfile();
}