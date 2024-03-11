<!DOCTYPE html>

<?php
include_once "connection.php";
?>

<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Wam-Bam - Sign Up</title>
</head>

<body bgcolor="black" text="white">
<?php

	$firstname = "";
	$lastname = "";
	$email = "";
	$password = "";
	$address = ""; 
	$zipcode = ""; 

	$firstname = $_POST["firstname"];
	$lastname = $_POST["lastname"];
	$email = $_POST["email"];
	$password = $_POST["password"];
	$address = $_POST["address"];
	$zipcode = $_POST["zipcode"];

?>

	<p align="center"><font size="6"><I> WAM-BAM Keyboards </font></I></p>
	<p align="center"><font size="4"><I> We use 'em and we love 'em! </font></I></p>
	<br>
	<div class="topnav">
		<table align="center" border="5" cellspacing="25" cellpadding="50">
			<tr>
			<th><a class="active" href="index.html">Home</a></th>
			<th><a href="assembled.html">Fully Assembled Keyboards</a></th>
			<th><a href="keyboard_components.html">Keyboard Components</a></th>
			<th><a href="login.html">Account</a></th>
			<th><a href="cart.html">Cart</a></th>
			</tr>
		</table>
		</div>
		<form method="POST" action="<?php $sql = "INSERT INTO users(firstname, lastname, email, password, address, zipcode) VALUES('$firstname', '$lastname', '$email', '$password', '$address', '$zipcode')"; 
		mysqli_query($con, $sql); ?> " >
		<?php
			if(isset($_POST['submit']))
			{
        		header('location:index.html');
        	}
		?>


			<p align="center"><label for="First Name:">First Name:</label></p>
			<p align="center"><input type="text" name="firstname" required></p>

			<p align="center"><label for="Last name">Last name:</label></p>
			<p align="center"><input type="text" name="lastname" required></p>

			<p align="center"><label for="Email">Email:</label></p>
			<p align="center"><input type="email" name="email" required></p>

			<p align="center"><label for="Password">Password:</label></p>
			<p align="center"><input type="Password" name="password" required></p>

			<p align="center"><label for="Adress">Adress:</label></p>
			<p align="center"><input type="text" name="address" required></p>

			<p align="center"><label for="Zip Code">Zip Code:</label></p>
			<p align="center"><input type="number" name="zipcode" required></p>

			<p align="center"><button a href="index.html" type="submit" name="submit"> Create </button>
			
		</form>
		<p style="text-align:center">
			<img src="snake.gif" height="600" width="1000">
		</p>
</body>
</html>