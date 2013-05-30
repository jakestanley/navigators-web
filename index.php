<?php 
	include 'services/header.php'; 
	include 'classes/login.class.php';
	
	if(isset($_SESSION["userID"]) && isset($_SESSION["username"])){
		// Do necessary checks against user ID and present them with the appropriate information -- basically, if logged in. need complex joins here to get appropriate data. can discover friends in systems, within range, etc
		
		echo $interface->buildTopSection(1);
		echo $interface->buildActionBar();
		echo '<div class="row">';
		echo $interface->buildMainSection();
		echo $interface->buildSideSection();
		echo '</div>';
	} else {
		$login = new login();
		echo $interface->buildTopSection(0);
		echo '<div class="row">';
		echo $login->buildLogin();
		echo '</div>';
	}

	include 'services/footer.php';
?>