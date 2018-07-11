<?php
ob_start();
@session_start();

require('soap.php');
require('classSystem.php');

if($_SESSION){
	
	var_dump($cell2i->invoiceBlock());
	
	?>
	<html>
	<head>
		<title>Cell2i Login Page</title>
<link rel="icon" type="image/png" sizes="16x16" href="img/favicon.png">
<meta name="theme-color" content="#ffffff">
		<link rel="stylesheet" href="css/standart.css"/>
		<link rel="stylesheet" href="css/global.css"/>
	</head>
	<body style="background:#eee;">	
<div class="box col-12">
	<div class="row">
<div class="box col-3 col-sm-12 a-center">
	<a href="index.php" class="box col-12 a-center"><img src="img/cell2i-original.png"/></a>
</div>
<div class="box col-6 col-sm-12">
	<div class="box col-12">
		
		<div class="box col-12">
		
			<div class="box col-12 bg1">
				<div class="col col-12">
					<div class="row">
						<div class="col col-12 lineHeight35 fsize20">MAY INVOICE</div>
					</div>
					<div class="row">
						<div class="col col-12 lineHeight35 fsize16">Cost:858,45</div>
					</div>
					<div class="row">
						<div class="col col-12 fsize16">Invoice date:28.05.2018</div>
					</div>
					<div class="row">
						<div class="col col-12 lineHeight35 a-right fsize20">PAID</div>
					</div>
				</div>
			</div>
	
		</div>
		<div class="box col-12">
		
		<div class="box col-12 bg1">
			<div class="col col-12">
				<div class="row">
					<div class="col col-12 lineHeight35 fsize20">APRIL INVOICE</div>
				</div>
				<div class="row">
					<div class="col col-12 lineHeight35 fsize16">Cost:858,45</div>
				</div>
				<div class="row">
					<div class="col col-12 fsize16">Invoice date:28.04.2018</div>
				</div>
				<div class="row">
					<div class="col col-12 lineHeight35 a-right fsize20">NOT PAID</div>
				</div>
			</div>
		</div>
		
		</div>
		<div class="box col-12">
	
		<div class="box col-12 bg1">
			<div class="col col-12">
				<div class="row">
					<div class="col col-12 lineHeight35 fsize20">MARCH INVOICE</div>
				</div>
				<div class="row">
					<div class="col col-12 lineHeight35 fsize16">Cost:858,45</div>
				</div>
				<div class="row">
					<div class="col col-12 fsize16">Invoice date:28.03.2018</div>
				</div>
				<div class="row">
					<div class="col col-12 lineHeight35 a-right fsize20">PAID</div>
				</div>
			</div>
		</div>
		
		</div>
		<div class="box col-12">
	
		<div class="box col-12 bg1">
			<div class="col col-12">
				<div class="row">
					<div class="col col-12 lineHeight35 fsize20">FEBRUARY INVOICE</div>
				</div>
				<div class="row">
					<div class="col col-12 lineHeight35 fsize16">Cost:858,45</div>
				</div>
				<div class="row">
					<div class="col col-12 fsize16">Invoice date:28.02.2018</div>
				</div>
				<div class="row">
					<div class="col col-12 lineHeight35 a-right fsize20">NOT PAID</div>
				</div>
			</div>
		</div>
		
		</div>
	
	</div>
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