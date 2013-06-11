$(document).ready(function(){
//	var game = require("game.js");
// 	if(game){
// 		console.log(game.loaded());
// 	} else {
// 		console.log("Couldn't load game stuff");
// 	}

	// ON LOAD

		// ALL PAGES
		
		
		if('WebSocket' in window){
			console.log("This browser supports WebSockets"); // need to display something accordingly if the browser doesn't support WS
		} else {
			console.log("This browser does not support WebSockets");
		}
		
		var hash = window.location.hash;
		
		$("div#content").hide().delay(50);
		$("div#content").fadeIn();
		$(".somecode").hide();
		
		setInterval(gameLoop, 50); // This does all the game stuff forever (or until it is stopped)
	
		// LOGIN PAGE
		
		if(hash){
			if (hash == '#register') { //if errorsd header("location: hgfdhgf/#register")
				$("#forms-register").show();
				$("#forms-login").hide();
			} else {
				$("#forms-login").show();
				$("#forms-register").hide();				
			}
		} else {
			$("#forms-login").show();
			$("#forms-register").hide();
		}
		
		$(".somecode").slideDown().delay(2500).slideUp();
	
	//	$("div#forms-register").hide(); // Need to work out a way to show this if an error code is thrown up for registration
										// Also need a way to put details back in to the form so users don't have to type them in again
									
		// INTERFACE PAGE

		showStatus(); // put this default action in CSS

	// FUNCTIONS

		// LOGIN PAGE

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
	
		// INTERFACE PAGE
	
		function showStatus(){ // put this default action in CSS
			$("div.subsystem").hide();
			$("div.subsystem#status").show();
		}
		
		function changeSectionHeights(){ // Works but not for child elements
			var sideSectionHeight = $('#sidesection').height();
			var mainSectionHeight = $('#mainsection').height();
			if(mainSectionHeight < sideSectionHeight){
				$('#mainsection').css('height', sideSectionHeight);
			} else if(mainSectionHeight > sideSectionHeight){
				$('#sidesection').css('height', mainSectionHeight);
			}
		}

	// MOUSE CLICKS
		
		// LOGIN
		
		$("button#show-register").click(function(){
			showRegister();
		});
	
		$("button#show-login").click(function(){
			showLogin();
		});
	
		// INTERFACE
		
		$(".subbar").click(function(){
			var target = $(this).attr('rel');
			$(".subsystem").hide();
			$('#'+target).show();
			//changeSectionHeights();
			
			//function to handle height
			
		});
		
		var sideSectionHeight = $('#sidesection').height();
		
		//$('#mainsection').css('height', sideSectionHeight);
		
		$(window).resize(function(){
			//console.log($('#mainsection').height());
			//function
			//which one is the tallest
			//change height accordingly
		});
	
});