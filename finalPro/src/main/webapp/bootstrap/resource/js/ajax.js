// pathname is contextRoot/path/path/ so we want to get [1] 
// that is where contextRoot is
// [0] has "" as a result of split 

$(function() {
	
	var contextRoot = "/" + window.location.pathname.split('/')[1];
	alert(contextRoot);
	$("button").click(function() {
        url =contextRoot+ $(this).val();
    	$.ajax({
    		type : 'post',
    		url : contextRoot+"/enable/1",
    		dataType : "json", // Accept header
    		contentType : 'application/json', // Sends - Content-type
    		success : function(response) {
    			alert(response.desc);
    			//Code here..
    		},
    		error : function(errorObject,textStatus,httpstatus) {
    			// error: function(jqXHR, textStatus, HTTPStatus ){
    			// jqXHR = jQuery XMLHttpRequest superset of XMLHttpRequest
    			// EXAMPLE values: error: function(jQuery XMLHttpRequest, "error",
    			// "Bad Request" ){
    			// see http://api.jquery.com/jquery.ajax/
    			
    			/*

    			if (errorObject.responseJSON.errorType == "ValidationError") {
    				$('#success').html("");
    				$('#errors').html("");
    				$("#errors").append('<H3 align="center"> Error(s)!! <H3>');
    				$("#result").append('<p>');

    				var errorList = errorObject.responseJSON.errors;
    				$.each(errorList, function(i, error) {
    					$("#errors").append(error.message + '<br>');
    				});
    				$("#errors").append('</p>');
    				$('#result').show();
    			} else {
    				alert(errorObject.responseJSON.errors(0)); // "non" Validation
    				// Error
    			}
    			*/
    			alert(textStatus);
    			alert(httpstatus);
    		}
    	});
        
    });
//	
});
