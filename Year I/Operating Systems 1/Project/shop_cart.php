<?php
	$dbServername = "localhost";
	$dbUsername = "danut";
	$dbPassword = "luke";
	$dbName = "cart";
	$con = mysqli_connect($dbServername,$dbUsername,$dbPassword,$dbName);
	if(!$con)
	{
		echo "ok";
		exit();
	}
?>