<?php session_start();

include 'classes/db.class.php';
include 'classes/interf.class.php';
$interface = new interf();
	
	echo '<!DOCTYPE HTML>
<html lang="en-GB">
	<head>
		<link rel="stylesheet" type="text/css" href="css/normalize.css"/>
		<link rel="stylesheet" type="text/css" href="css/foundation.css"/>
		<link rel="stylesheet" type="text/css" href="css/new.css"/>
		<meta charset="UTF-8">
		<title>Navigators</title>
		<div id="wrapper">';

	echo '</head>
		<body>'; // Body is closed by the footer.php file
		
		if(isset($_GET["e"])){ // Error codes
			$e = $_GET["e"];
			$error = "<div class=\"row\" id=\"errorcode\"><somecode><h4>Error code $e: ";
			
			if($e == 1){
				$error .= "Invalid login credentials";
			} else if($e == 2){
				$error .= "The passwords you entered for registration did not match";
			} else if($e == 3){
				$error .= "Your account has not yet been verified";
			} else if($e == 4){
				$error .= "You must fill in all registration fields";
			} else if($e == 5){
				$error .= "That user name has already been taken";
			} else if($e == 6){
				$error .= "There is already a user registered with that email address";
			}
			
			$error .= "</h4></somecode></div>";
			echo $error;
		}
		
		if(isset($_GET["s"])){ // Success codes
			$s = $_GET["s"];
			$success = "<somecode>Success code $s: ";
			if($s == 1){
				$success .= "You successfully registered! Check your emails for account verification instructions";
			}
			$success .= "</somecode>";
			echo $success;
		}
	
?>