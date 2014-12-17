/**
 * 
 */
$(document).ready(function() {
	
	var cartId;
	
	checkAvailability = function(productId){
		    var username = $("#username").val();
		    if (username === '') {
		    	$('#availability').html("");
 		 		$('#availability').append("<span style='color: red;'>Invalid Username</span>");
 		 		return;
		    }
		    
		    $.ajax({
				url: '/kemosabe/login/check/' + username,
		 		type: 'GET',
		 		async: true,
			 	 success: function (message) {
			 		 	if (message === 'available'){
			 		 		$('#availability').html("");
			 		 		$('#availability').append("<span style='color: green;'>Name available</span>");
			 		 	} else {
			 		 		$('#availability').html("");
			 		 		$('#availability').append("<span style='color: red;'>Already Taken</span>");
			 		 	}
					},
					error: function(){	
						$('#availability').html("");
		 		 		$('#availability').append("<span style='color: red;'>Some error occured. :(</span>");
 			 	 } 
		   });
		}

});
