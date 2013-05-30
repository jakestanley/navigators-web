<?php session_start();
	
	echo '<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="js/foundation.min.js"></script>
		<script language="javascript" type="text/javascript" src="js/app.js"></script>
		</body>
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