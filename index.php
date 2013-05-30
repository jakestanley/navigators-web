<?php 
	include 'services/header.php'; 
	include 'classes/login.class.php';
	include 'classes/interf.class.php';
	
	if(isset($_SESSION["userID"]) && isset($_SESSION["username"])){
		// Do necessary checks against user ID and present them with the appropriate information -- basically, if logged in. need complex joins here to get appropriate data. can discover friends in systems, within range, etc
		$interface = new interf();
		
		echo $interface->buildTopSection();
		echo '<div class="row">';
		echo $interface->buildMainSection();
		echo $interface->buildSideSection();
		echo '</div>';
		echo $interface->buildBottomSection();
	} else {
		$login = new login();
		echo '<div class="row">';
		echo $login->buildLogin();
		echo '</div>';
	}

	include 'services/footer.php';
?>