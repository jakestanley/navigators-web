<?php session_start();

include '../classes/dbcon.class.php';
include '../classes/login.class.php';
	
if((isset($_POST["user"]) && isset($_POST["pw"])) || 
(isset($_COOKIE["animal-shelter-user-1992"]) && (isset($_COOKIE["animal-shelter-pass-1992"])))){
	
	$newdb = new dbcon();
	$login = new login();
	
	if(isset($_POST["user"]) && isset($_POST["pw"])){
		$login->username = $_POST["user"];
		$login->password = md5($_POST["pw"]);
	} else {
		$login->username = $_COOKIE["animal-shelter-user-1992"];
		$login->password = md5($_COOKIE["animal-shelter-pass-1992"]);
	}
	
	if($login->login()){
		$_SESSION["userID"] = $login->userID;
		$_SESSION["setup"] = $login->setup;
		$_SESSION["userType"] = $login->userType;
		$_SESSION["username"] = $login->username;
		if(isset($_POST["remember"])){
			$un = $_POST["user"];
			$pw = $_POST["pw"];
			setcookie("animal-shelter-user-1992", "$un", time()+604800);
			setcookie("animal-shelter-pass-1992", "$pw", time()+604800);
		}
		header("location: ../index.php");
	} else {
		header("location: ../index.php?e=1");		
	}
	
} else {
	header("location: ../index.php");
}
	
?>
