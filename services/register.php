<?php

include '../classes/db.class.php';

if(isset($_POST["user"]) && isset($_POST["pw"]) && isset($_POST["cpw"]) && isset($_POST["email"])){

$user = $_POST["user"];
$pw = $_POST["pw"];
$cpw = $_POST["cpw"];
$email = $_POST["email"];

if(!empty($user) && !empty($pw) && !empty($cpw) && !empty($email)){

	// if password is long enough -- might be able to stop this kind of stuff before it gets here with js
	// if email is a valid email -- might be able to stop this kind of stuff before it gets here with js
	// if username is of valid length -- might be able to stop this kind of stuff before it gets here with js
	
	if($pw == $cpw){
		$db = new db();
		$sql = 'SELECT * FROM useraccounts WHERE Username = "'.$user.'"';
		$rs = $db->dbQuery($sql);
		if($rs->num_rows < 1){
			$sql = 'SELECT * FROM useraccounts WHERE Email = "'.$email.'"';
			$rs = $db->dbQuery($sql);
			if($rs->num_rows < 1){
				$password = md5($pw); // I need a better hashing algorithm than just MD5 for stuff like this
				$sql = 'INSERT INTO useraccounts (Username, `Password`, Email) 
					VALUES ("'.$user.'", "'.$password.'", "'.$email.'")'; // need to set up verification code as well
					$db->dbQuery($sql);
					header("location: ../?s=1");
			} else {
				header("locations: ../?e=6");
			}
		} else {
			header("location: ../?e=5");
		}
	} else {
		header("location: ../?e=2"); // header("location: ../?e=2#register");
	}
	
	// $newdb = new dbcon();
// 	$login = new login();
// 	 
// 	$login->username = $_POST["user"];
// 	$login->password = md5($_POST["pw"]);
// 	
// 	if($login->register()){
// 		header("location: ../");
// 	} else {
// 		header("location: ../");		
// 	}
	
} else {
	header("location: ../?e=4"); // header("location: ../?e=4#register");
}

}
	
?>
