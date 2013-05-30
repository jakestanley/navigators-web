<?php session_start();
	
	echo '	</div>
			<div id="bottom">
				<div class="row">
				<div class="large-12">
				<a href="about.php">About </a>
				<a href="contact.php">Contact </a>';
			
	if(isset($_SESSION["username"])){
		echo '<a href="services/logout.php">Logout </a>';
	}
				
	echo '	</div>
			</div>
			<div class="row">
<div class="large-12"></div>
				Jake Stanley, 2013
							</div>
			</div>
			</div>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="js/foundation.min.js"></script>
		<script language="javascript" type="text/javascript" src="js/app.js"></script>
	</body>
</html>'; // Footer simply closes the body, adds the footer and closes the html.
	
?>