<?php session_start();
	
	echo '</body>
		<footer>';
		
	$logged = "";
	
	if(isset($_SESSION["username"])){
		$logged = '<a href="services/logout.php">Logout</a> ';
	}
	
	echo '<li><a href="about.php">About</a> <a href="contact.php">Contact</a> '.$logged.'
	</li><li>Jake Stanley, 2013</li>
		</footer>
	</div>
</html>'; // Footer simply closes the body, adds the footer and closes the html.
	
?>