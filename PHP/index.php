<?php
ob_start();
@session_start();

require('soap.php');
require('classSystem.php');

if($_SESSION){
	
	$UserInfo = $cell2i->UserInfoBlock($_SESSION['Msisdn']);
	$UserName = $UserInfo[1].' '.$UserInfo[2];
	$UserPhone = $UserInfo[0];
	$TariffInfo = $cell2i->TariffInfo($_SESSION['Msisdn']);
	
		$UserTariff = $TariffInfo[0];
		$MBLimit = $TariffInfo[3];
		$MinuteLimit = $TariffInfo[1];
		$SMSLimit = $TariffInfo[2];
		
		$UsableMB = $cell2i->TariffUsage($_SESSION['Msisdn'],'DATA');
		$UsableMinute = $cell2i->TariffUsage($_SESSION['Msisdn'],'VOICE');
		$UsableSMS = $cell2i->TariffUsage($_SESSION['Msisdn'],'SMS');

		$GBLimit = $cell2i->ChangeMBtoGB($MBLimit);
		$UsableMB = $cell2i->ChangeMBtoGB($UsableMB[1]);
		$UsableMBPercent = $cell2i->PercentOperation($GBLimit,$UsableMB);
		$UsableMinutePercent = $cell2i->PercentOperation($MinuteLimit,$UsableMinute[1]);
		$UsableSMSPercent = $cell2i->PercentOperation($SMSLimit,$UsableSMS[1]);

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
		<a href="http://i2i-systems.com/" class="box col-2 col-sm-12 a-center"><img src="img/i2iLogo.png" class="userPagei2iLogo"/></a>
		
		<div class="col col-8 col-sm-12">
			<div class="row menu">
				<a href="" class="col col-2 a-center Btn" title="Mesajlarım"><img src="img/messageIcon.png" class="messageIcon"/></a>
				<a href="" class="col col-2 a-center Btn" title="Tarifelerim"><img src="img/tariffIcon.png"/></a>
				<a href="" class="col col-4 a-center logoBtn" title="Cell2i"><img src="img/cell2i-original.png" class="userPageC2iLogo"/></a>
				<a href="invoicePage.php" class="col col-2 a-center Btn" title="Faturalarım"><img src="img/invoiceIcon.png"/></a>
				<a href="logout.php" class="col col-2 a-center Btn" title="Oturumu Kapat"><img src="img/logoutIcon.png"/></a>
			</div>
		</div>
		
	</div>
</div>
<div class="inner">
	<div class="col col-12">
		<div class="row">
			<div class="box col-3 forDesktop"></div>
		<form action="" method="POST">
			<div class="col col-6 col-sm-12 userBlock">
				<div class="col col-12">
					<div class="row">
						<div class="box col-12 a-center">
							<span class="dInlineBlock">
								<span class="col"><img src="img/user.png"/></span>
								<span class="box fsize36 lineHeight50"><?php echo $UserName;?></span>
							</span>
						</div>
					</div>
					<div class="row">
						<div class="box col-12 a-center">
							<span class="dInlineBlock">
								<span class="col"><img src="img/smartphone.png"/></span>
								<span class="box fsize36 lineHeight50"><?php echo $UserPhone;?></span>
							</span>
						</div>
					</div>
					<div class="row">
						<div class="box col-12 a-center">
							<span class="dInlineBlock">
								<span class="col"><img src="img/tariffArticle.png"/></span>
								<span class="box fsize36 lineHeight50"><?php echo $UserTariff;?></span>
							</span>
						</div>
					</div>
					
				</div>
			</div>
		
			<div class="box col-3 forDesktop"></div>
		</div>
	</div>
</div>
<div class="innerIndex">
	<div class="box col-12">
		<div class="row">
			<div class="box col-2"></div>
			<div class="box col-10">
				
				<div class="row">
						<div class="box col-12">
							<div class="row">
								<div class="box col-9"></div>
								<div class="box col-3 fsize36">
									<?php echo $GBLimit;?> GB
								</div>
							</div>
							<div class="row">
								<div class="col col-9 col-sm-12 greenBar">
									<div class="row">
										<div class="col redBar a-center lineHeight35 fsize24 p-left p-right" style="width:<?php echo $UsableMBPercent;?>%"><?php echo $UsableMB;?> GB</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="box col-12">
							<div class="row">
								<div class="box col-9"></div>
								<div class="box col-3 fsize36">
									<?php echo $MinuteLimit;?> DK
								</div>
							</div>
							<div class="row">
								<div class="col col-9 col-sm-12 greenBar">
									<div class="row">
										<div class="col redBar a-center lineHeight35 fsize24 p-left p-right" style="width:<?php echo $UsableMinutePercent;?>%"><?php echo $UsableMinute[1];?> DK</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="box col-12">
							<div class="row">
								<div class="box col-9"></div>
								<div class="box col-3 fsize36">
									<?php echo $SMSLimit;?> SMS
								</div>
							</div>
							<div class="row">
								<div class="col col-9 col-sm-12 greenBar">
									<div class="row">
										<div class="col redBar a-center lineHeight35 fsize24 p-left p-right" style="width:<?php echo $UsableSMSPercent;?>%"><?php echo $UsableSMS[1];?> SMS</div>
									</div>
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