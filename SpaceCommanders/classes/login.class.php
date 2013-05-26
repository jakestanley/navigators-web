<?php
	
class login {
	
	public function buildLogin(){
		
		$html = '<script language="javascript" type="text/javascript" src="js/login.js"></script>'; // include javascript for this page
		
		$html .= '
			<li><h1>Welcome to Navigators</h1></li>
			<div class="forms" id="forms-login">
				<form method="post" action="services/login.php">
					<li>Username</li>
					<li><input type="text" name="user" value=""></li>
					<li>Password</li>
					<li><input type="password" name="pw" value=""></li>
					<li><input type="submit" value="Login"></li>
				</form>
				<button class="link" id="show-register">New to Navigators?</li>
			</div>';
		
		$html .= '
			<div class="forms" id="forms-register">
				<form method="post" action="services/register.php">
					<li>Username</li>
					<li><input type="text" name="user" value=""></li>
					<li>Password</li>
					<li><input type="password" name="pw" value=""></li>
					<li>Confirm password</li>
					<li><input type="password" name="cpw" value=""></li>
					<li>Email</li>
					<li><input type="text" name="email" value=""></li>
					<li><input type="submit" value="Register"></form></li>
				</form>
				<button class="link" id="show-login">Already have an account?</li>
			</div>';
		
		return $html;
		
	}
	
}
	
?>