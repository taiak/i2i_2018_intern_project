<?php
ob_start();
@session_start();

require('soap.php');
require('classSystem.php');

if($_SESSION){
	
	$InvoiceArray = $cell2i->InvoiceBlock($_SESSION['Msisdn'],6);
	
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
	<a href="index.php" class="box col-12 a-center"><img src="img/cell2i-original.png" class="invoiceLogo"/></a>
</div>
<div class="box col-6 col-sm-12">
	<div class="box col-12">
		
		<?php
		foreach($InvoiceArray AS $Invoice){
		?>
		<div class="box col-12">
		
			<div class="box col-12 bg1 invoiceBlockSP" style="margin-bottom:20px;">
				<div class="col col-12">
					<div class="row">
						<div class="col col-12 lineHeight50 fsize36"><?php echo $Invoice['InvoiceMonth'];?> INVOICE</div>
					</div>
					<div class="row">
						<div class="col col-12 lineHeight50 fsize30 fw300">Cost:<?php echo $Invoice['Cost'];?></div>
					</div>
					<div class="row">
						<div class="col col-12 fsize30 fw300 lineHeight35">Invoice date:<?php echo $Invoice['InvoiceDate'];?></div>
					</div>
					<div class="row">
						<div class="col col-12 lineHeight35 a-right fsize36"><?php echo $Invoice['PaidStatus'];?></div>
					</div>
				</div>
			</div>
	
		</div>
		<?php
		}
		?>

	
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