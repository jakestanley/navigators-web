<?php 
	include 'services/header.php'; 
	include 'classes/login.class.php';
	include 'classes/interf.class.php';
	
	if(isset($_SESSION["userID"]) && isset($_SESSION["username"])){
		// Do necessary checks against user ID and present them with the appropriate information -- basically, if logged in. need complex joins here to get appropriate data. can discover friends in systems, within range, etc
		$interface = new interf();
		echo '<div class="mainsection">';
		echo $interface->buildSubsystemsBar();
		echo $interface->buildSubsystems();
		echo $interface->buildActionBar();
		echo '</div>';
		echo '<div class="sidesection">';
		echo $interface->buildSideBar();
		echo '</div>';
	} else {
		$login = new login();
		echo $login->buildLogin();
	}

	include 'services/footer.php';
?>