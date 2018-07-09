<?php
ob_start();
@session_start();

require('soap.php');
require('classSystem.php');

if($_SESSION){
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
		<a href="http://i2i-systems.com/" class="box col-2 col-sm-12 a-center"><img src="img/i2iLogo.png"/></a>
		<div class="box col-1 forDesktop"></div>
		<div class="col col-6 col-sm-12">
			<div class="row menu">
				<a href="" class="box col-2 a-center Btn" title="Mesajlarım"><img src="img/messageIcon.png"/></a>
				<a href="" class="box col-2 a-center Btn" title="Tarifelerim"><img src="img/tariffIcon.png"/></a>
				<a href="" class="col col-4 a-center logoBtn" title="Cell2i"><img src="img/cell2i-original.png"/></a>
				<a href="" class="box col-2 a-center Btn" title="Faturalarım"><img src="img/invoiceIcon.png"/></a>
				<a href="" class="box col-2 a-center Btn" title="Oturumu Kapat"><img src="img/logoutIcon.png"/></a>
			</div>
		</div>
		<div class="box col-1 forDesktop"></div>
	</div>
</div>
<div class="inner">
	<div class="box col-12">
		<div class="row">
			<div class="box col-3 forDesktop"></div>
		<form action="" method="POST">
			<div class="box col-6 col-sm-12 userBlock">
				<div class="row">
					<div class="box col-12 a-center">
						<span class="dInlineBlock">
							<span class="col"><img src="img/user.png"/></span>
							<span class="box fsize16 lineHeight22">Hasan UYANIK</span>
						</span>
					</div>
				</div>
				<div class="row">
					<div class="box col-12 a-center">
						<span class="dInlineBlock">
							<span class="col"><img src="img/smartphone.png"/></span>
							<span class="box fsize16 lineHeight22">538 XXX XX XX</span>
						</span>
					</div>
				</div>
				<div class="row">
					<div class="box col-12 a-center">
						<span class="dInlineBlock">
							<span class="col"><img src="img/tariffArticle.png"/></span>
							<span class="box fsize16 lineHeight22">Genç Tarife</span>
						</span>
					</div>
				</div>
				
			</div>
		
			<div class="box col-3 forDesktop"></div>
		</div>
	</div>
</div>

	</body>
</html>
	<?php
}else{
	header('Location:loginPage.php');
}

ob_end_flush();
?>