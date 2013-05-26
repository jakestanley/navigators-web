$(document).ready(function(){

	// ON LOAD

	$("div#forms-register").hide();
	$("div#content").hide().next().delay(500);
	$("div#content").fadeIn();
//	$("div#forms-new").hide();

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
	

	

	// $("li.about-line").mouseenter(function(){
	// 	$("desc.about").show();
	// });
	// $("li.resume-line").mouseenter(function(){
	// 	$("desc.resume").show();
	// });
	// $("li.projects-line").mouseenter(function(){
	// 	$("desc.projects").show();
	// });
	// $("li.contact-line").mouseenter(function(){
	// 	$("desc.contact").show();
	// });
	// $("li.blog-line").mouseenter(function(){
	// 	$("desc.blog").show();
	// });
	// $("li.reviews-line").mouseenter(function(){
	// 	$("desc.reviews").show();
	// });
	// $("li.repair-line").mouseenter(function(){
	// 	$("desc.repair").show();
	// })
	// 
	// // MOUSE LEAVES
	// 
	// $("li.about-line").mouseleave(function(){
	// 	$("desc.about").hide();
	// });
	// $("li.resume-line").mouseleave(function(){
	// 	$("desc.resume").hide();
	// });
	// $("li.projects-line").mouseleave(function(){
	// 	$("desc.projects").hide();
	// });
	// $("li.contact-line").mouseleave(function(){
	// 	$("desc.contact").hide();
	// });
	// $("li.blog-line").mouseleave(function(){
	// 	$("desc.blog").hide();
	// });
	// $("li.reviews-line").mouseleave(function(){
	// 	$("desc.reviews").hide();
	// });
	// $("li.repair-line").mouseleave(function(){
	// 	$("desc.repair").hide();
	// })
	// 
	// // MOUSE CLICKS
	// 
	// $("li.about-line").click(function(){
	// 	$("extend").hide();
	// 	$("extend.about-extend").show();
	// });
	// $("li.resume-line").click(function(){
	// 	$("extend").hide();
	// 	$("extend.resume-extend").show();
	// });
	// $("li.projects-line").click(function(){
	// 	$("extend").hide();
	// 	$("extend.projects-extend").show();
	// });
	// $("li.contact-line").click(function(){
	// 	$("extend").hide();
	// 	$("extend.contact-extend").show();
	// });
});