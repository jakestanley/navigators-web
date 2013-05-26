$(document).ready(function(){

	// ON LOAD

	$("div#forms-register").hide(); // Need to work out a way to show this if an error code is thrown up for registration
									// Also need a way to put details back in to the form so users don't have to type them in again
	$("div#content").hide().next().delay(500);
	$("div#content").fadeIn();

	// FUNCTIONS

	function showLogin(){
		$("div#forms-register").fadeOut(function(){
			$("div#forms-login").fadeIn();
		});
	}
	
	function showRegister(){
		$("div#forms-login").fadeOut(function(){
			$("div#forms-register").fadeIn();			
		});
	}

	// MOUSE CLICKS
		
	$("button#show-register").click(function(){
		showRegister();
	});
	
	$("button#show-login").click(function(){
		showLogin();
	});
});