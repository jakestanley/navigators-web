<?php session_start();

include '../classes/db.class.php';
	
if((isset($_POST["user"]) && isset($_POST["pw"]))){

// || (isset($_COOKIE["animal-shelter-user-1992"]) && (isset($_COOKIE["animal-shelter-pass-1992"])))){ or if there are cookies set
	
	$username = $_POST["user"];
	$password = md5($_POST["pw"]);
	
	$db = new db();
	$sql = 'SELECT * FROM useraccounts WHERE Username = "'.$username.'" AND `Password` = "'.$password.'"';
	$rs = $db->dbQuery($sql);
	if($row = $rs->fetch_array()){
		$_SESSION["userID"] = $row["ID"];
		$_SESSION["username"] = $row["Username"];
		header("location: ../");
	} else {
		header("location: ./e=1");
	}
}	
?>
