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

<div class="inner">
	<div class="box col-12">
		<div class="row">
			<div class="box col-3 forDesktop"></div>
		<form action="" method="POST">
			<div class="box col-6 col-sm-12">
				<div class="row">
					<div class="box col-12">
						<div class="box col-12 a-center">
							<img src="img/cell2i-original.png" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="box col-12">
						
							<input type="text" name="MSISDN" placeholder="Enter your phone number" class="box col-12 box-shadow1 border1 Segoe" maxLength="10"/>
						
					</div>
				</div>
				<div class="row">
					<div class="box col-12">
						<div class="row">
							<div class="box col-12">
								<input type="password" name="Password" placeholder="Enter your new password" class="box col-12 box-shadow1 border1 Segoe"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="box col-12">
						
							<input type="password" name="confirmPassword" placeholder="Confirm your password" class="box col-12 box-shadow1 border1 Segoe"/>
						
					</div>
				</div>
				<div class="row">
					<div class="col col-12 color5 a-center Segoe">
						<?php 
							if($_POST){
								$MSISDN = $_POST['MSISDN'];
								$Password = $_POST['Password'];	
								$confirmPassword = $_POST['confirmPassword'];
								echo $cell2i->changePassword($MSISDN,$Password,$confirmPassword);
							}
							?>
					</div>
				</div>
				<div class="row">
					<div class="box col-12">
						<div class="row">
							<div class="box col-12">
								<div class="row">
									<div class="box col-12">
										<input type="submit" value="DONE" class="box col-4 col-sm-10 box-shadow1 border1 cPointer bg4 color1 fsize16 Segoe fr"/>
									</div>
								</div>
							</div>
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