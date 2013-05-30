<?php
	
class login {
	
	public function buildLogin(){
		
		$html = '<h1>Welcome to Navigators</h1>';
		
		$html .= '<div class="row">
					<div class="large-4 columns">';
		
		$html .= '
			<div class="forms" id="forms-login">
				<form method="post" action="services/login.php">
					<label>Username</label>
					<input type="text" name="user" value="">
					<label>Password</label>
					<input type="password" name="pw" value="">
					<input type="submit" value="Login">
				</form>
				<button class="link" id="show-register">New to Navigators?</li>
			</div>';
			
		$html .= '
			<div class="forms" id="forms-register">
				<form method="post" action="services/register.php">
					<label>Username</label>
					<input type="text" name="user" value="">
					<label>Password</label>
					<input type="password" name="pw" value="">
					<label>Confirm password</label>
					<input type="password" name="cpw" value="">
					<label>Email</label>
					<input type="text" name="email" value="">
					<input type="submit" value="Register"></form>
				</form>
				<button class="link" id="show-login">Already have an account?</li>
			</div>';
			
		$html .= '</div>
				</div>';
		
		return $html;
		
	}
	
}
	
?>