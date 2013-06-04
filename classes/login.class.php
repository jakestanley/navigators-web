<?php
	
class login {
	
	public function buildLogin(){
		
		$facebook = ''; // '<div class="large-6 columns"><a href="services/login.php?fb=1"><button class="link" id="facebook-login">Login with Facebook</button></a></div>';
		
		$html .= '<h1>Welcome to Navigators</h1>';
		
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
				<div class="large-12 columns">
					<button class="link" id="show-register">New to Navigators?</button>
				</div>'.$facebook.'
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
				<div class="large-12 columns">
					<button class="link" id="show-login">Already have an account?</button>
				</div>'.$facebook.'
			</div>';
			
		$html .= '
				
			</div>
		</div>';
		
		return $html;
		
	}
	
}
	
?>