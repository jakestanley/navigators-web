<?php session_start();
	
	// Echo this instead of accessing local script when online :) - possible to cache?
	// The lag in sorting the interface is because of lag getting jQuery from the google apis website
	//		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	
	echo '	</div>
			<div id="bottom">
				<div class="row">
					<div class="large-12"></div>
				<!--	<h5 class="subheader">Jake Stanley, 2013</h5> -->
					</div>
				</div>
			</div>
		<script src="js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="js/foundation.min.js"></script>
		<script language="javascript" type="text/javascript" src="js/app.js"></script>
		<script type="text/javascript" src="js/game.js"></script> 
		</body>
</html>'; // Footer simply closes the body, adds the footer and closes the html.
	
?>