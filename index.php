<?php 
	include 'services/header.php'; 
	include 'classes/login.class.php';
	
	if(isset($_SESSION["userID"]) && isset($_SESSION["username"])){
		// Do necessary checks against user ID and present them with the appropriate information
		echo "You are logged in. <a href=\"services/logout.php\">Logout?</a>";
	} else {
		$login = new login();
		echo $login->buildLogin();
	}

	include 'services/footer.php';
?>