<?php
	
class db {
	
	public $host = "localhost";
	public $user = "root"; // Don't use the root account on the actual website. Use a less privileged account
	public $pass = "";
	public $dbname = "navigator";
	private $conn;

	private function dbConnect(){
		$statusMessage = "";
		$this->conn = mysqli_connect($this->host, $this->user, $this->pass, $this->dbname);
		if(!$conn){
			$statusMessage .=  "Failed to connect to MySQL: ".mysqli_connect_error();
		}
		return $statusMessage;
	}

	public function dbQuery($query){
		$this->dbConnect();
		$result = mysqli_query($this->conn, $query);
		if($result){
			return $result;
		} else {
			echo $this->conn->error;
		}
	}
}
	
?>