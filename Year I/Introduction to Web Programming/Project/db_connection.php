<?php
	function OpenCon()
	{
		$dbhost = "localhost";
		$dbuser = "root";
		$dbpass = "1234";
		$db = "shop";

		$conn = new mysqli($dbhost, $dbuser, $dbpass, $db) or die("Connect failed: %\n". $conn -> error);


		return $conn;
	}

	function CloseCon($conn)
	{
		$conn -> close();
	}
?>