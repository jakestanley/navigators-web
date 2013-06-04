<?php session_start();

include '../classes/db.class.php';
	
if((isset($_POST["user"]) && isset($_POST["pw"])) && !isset($_GET["fb"])){

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
		header("location: ../?e=1");
	}
} else if(isset($_GET["fb"])){
	echo "Please wait while we connect with your Facebook account...<br>";
	require_once("../facebook/facebook.php");
    $config = array();
    $config['appId'] = '277474595729992'; // Set these with SQL statement or something
    $config['secret'] = 'ac2dede1f2a3ba233c5c63f600006cc3';
	$facebook = new Facebook($config);
	$user = $facebook->getUser();
	if($user){
		echo "We have a Facebook user!";
		try {
			$profile = $facebook->api('/me', 'GET');
			echo 'Name: '.$profile['name'];
		} catch(FacebookApiException $e) {
			error_log($e);
			$user = null;
		}
	} else {
		echo "We do not have a Facebook user! ";
		$login_url = $facebook->getLoginUrl();
		echo 'Please <a href="' . $login_url . '">login.</a>';
	}
}

?>
