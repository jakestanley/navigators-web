<?php

include '../classes/dbcon.class.php';
include '../classes/login.class.php';
	
if(isset($_POST["user"]) && isset($_POST["pw"])){
	
	$newdb = new dbcon();
	$login = new login();
	 
	$login->username = $_POST["user"];
	$login->password = md5($_POST["pw"]);
	
	if($login->register()){
		header("location: ../index.php?e=3");
	} else {
		header("location: ../index.php?e=2");		
	}
	
}
	
?>
