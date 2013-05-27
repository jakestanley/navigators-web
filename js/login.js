$(document).ready(function(){

	// ON LOAD

		// ALL PAGES

		showStatus();
		$("div#content").hide().next().delay(500);
		$("div#content").fadeIn();
	
		// LOGIN PAGE
	
		$("div#forms-register").hide(); // Need to work out a way to show this if an error code is thrown up for registration
										// Also need a way to put details back in to the form so users don't have to type them in again
									
		// INTERFACE PAGE

		

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
	
		function showStatus(){
			$("div.subsystem#status").show();
			$("div.subsystem#ls").hide();
			$("div.subsystem#nav").hide();
			$("div.subsystem#arms").hide();
			$("div.subsystem#crew").hide();
			$("div.subsystem#comms").hide();
			$("div.subsystem#energy").hide();
			$("div.subsystem#hardware").hide();
		}
	
		function showNavigation(){
			$("div.subsystem#status").hide();
			$("div.subsystem#ls").hide();
			$("div.subsystem#nav").show();
			$("div.subsystem#arms").hide();
			$("div.subsystem#crew").hide();
			$("div.subsystem#comms").hide();
			$("div.subsystem#energy").hide();
			$("div.subsystem#hardware").hide();
		}
	
		function showLifeSupport(){
			$("div.subsystem#status").hide();
			$("div.subsystem#ls").show();
			$("div.subsystem#nav").hide();
			$("div.subsystem#arms").hide();
			$("div.subsystem#crew").hide();
			$("div.subsystem#comms").hide();
			$("div.subsystem#energy").hide();
			$("div.subsystem#hardware").hide();
		}
	
		function showArmaments(){
			$("div.subsystem#status").hide();
			$("div.subsystem#ls").hide();
			$("div.subsystem#nav").hide();
			$("div.subsystem#arms").show();
			$("div.subsystem#crew").hide();
			$("div.subsystem#comms").hide();
			$("div.subsystem#energy").hide();
			$("div.subsystem#hardware").hide();
		}
	
		function showCrew(){
			$("div.subsystem#status").hide();
			$("div.subsystem#ls").hide();
			$("div.subsystem#nav").hide();
			$("div.subsystem#arms").hide();
			$("div.subsystem#crew").show();
			$("div.subsystem#comms").hide();
			$("div.subsystem#energy").hide();
			$("div.subsystem#hardware").hide();
		}
	
		function showCommunications(){
			$("div.subsystem#status").hide();
			$("div.subsystem#ls").hide();
			$("div.subsystem#nav").hide();
			$("div.subsystem#arms").hide();
			$("div.subsystem#crew").hide();
			$("div.subsystem#comms").show();
			$("div.subsystem#energy").hide();
			$("div.subsystem#hardware").hide();
		}
	
		function showEnergy(){
			$("div.subsystem#status").hide();
			$("div.subsystem#ls").hide();
			$("div.subsystem#nav").hide();
			$("div.subsystem#arms").hide();
			$("div.subsystem#crew").hide();
			$("div.subsystem#comms").hide();
			$("div.subsystem#energy").show();
			$("div.subsystem#hardware").hide();
		}
		
		function showHardware(){
			$("div.subsystem#status").hide();
			$("div.subsystem#ls").hide();
			$("div.subsystem#nav").hide();
			$("div.subsystem#arms").hide();
			$("div.subsystem#crew").hide();
			$("div.subsystem#comms").hide();
			$("div.subsystem#energy").hide();
			$("div.subsystem#hardware").show();
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
	
		$("button.subbar#status").click(function(){
			showStatus();
		});
		$("button.subbar#nav").click(function(){
			showNavigation();
		});
		$("button.subbar#ls").click(function(){
			showLifeSupport();
		});
		$("button.subbar#arms").click(function(){
			showArmaments();
		});
		$("button.subbar#crew").click(function(){
			showCrew();
		});
		$("button.subbar#comms").click(function(){
			showCommunications();
		});
		$("button.subbar#energy").click(function(){
			showEnergy();
		});
		$("button.subbar#hardware").click(function(){
			showHardware();
		});
	
});