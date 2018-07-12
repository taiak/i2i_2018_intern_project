<?php
ob_start();
@session_start();

require('classSystem.php');

if($_SESSION){
	header('Location:index.php');
}else{
?>
<html>
	<head>
		<title>Cell2i Login Page</title>
<link rel="icon" type="image/png" sizes="16x16" href="img/favicon.png">
<meta name="theme-color" content="#ffffff">
		<link rel="stylesheet" href="css/standart.css"/>
		<link rel="stylesheet" href="css/global.css"/>
	</head>
	<body>
<div class="box col-12 line-bottom box-shadow1">
	<div class="row">
		<div class="col col-10 col-mr-1 col-ml-1">
			<div class="row">
				<a href="http://i2i-systems.com/" class="col col-sm-12 a-center"><img src="img/i2iLogo.png" class="LoginLogo"/></a>
			</div>
		</div>
	</div>
</div>
<div class="inner">
	<div class="box col-12">
		<div class="row">
			<div class="box col-3 forDesktop"></div>
		<form action="" method="POST">
			<div class="box col-6 col-sm-12">
				<div class="row">
					<div class="box col-12 a-center">
						<img src="img/cell2i-original.png" class="LoginLogo2"/>
					</div>
				</div>
				<div class="row">
					<div class="box col-11">
						
							<input type="text" name="MSISDN" placeholder="Enter your phone number" class="box col-sm-12 box-shadow1 border1 Segoe LoginInput" maxLength="10"/>
						
					</div>
				</div>
				<div class="row">
					<div class="box col-11">
						
							<input type="password" name="Password" placeholder="Enter your password" class="box col-sm-12 box-shadow1 border1 Segoe LoginInput"/>
						
					</div>
				</div>
				<div class="row">
					<div class="box col-11 p-top">
						
							<a href="changePassword.php" class="col col-sm-12 a-right fr line-under color4 Segoe fsize20 fw700">Forgot your password?</a>
						
					</div>
				</div>
				<div class="row">
					<div class="box col-11 color5 a-center Segoe fsize24 p-left p-right fw300 lineHeight30">
						<?php 
							if($_POST){
								$MSISDN = $_POST['MSISDN'];
								$Password = $_POST['Password'];		
								echo $cell2i->UserLogin($MSISDN,$Password);
							}
							?>
					</div>
				</div>
				<div class="row">
					<div class="box col-11">
						<div class="row">
							<div class="box col-4 col-sm-1"></div>
							<input type="submit" value="LOGIN" class="box col-sm-10 box-shadow1 border1 cPointer bg4 color1 fsize20 Segoe LoginBtn"/>
							<div class="box col-4 col-sm-1"></div>
						</div>
					</div>
				</div>
			</div>
		</form>
			<div class="box col-3 forDesktop"></div>
		</div>
	</div>
</div>

	</body>
</html>
<?php

}
ob_end_flush();
?>