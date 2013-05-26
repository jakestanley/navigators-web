<?php 
	include 'services/header.php'; 
	include 'classes/login.class.php';
	
	if(isset($_SESSION["UserID"])){
		// Do necessary checks against user ID and present them with the appropriate information
	} else {
		$login = new login();
		echo $login->buildLogin();
	}

	include 'services/footer.php';
?>