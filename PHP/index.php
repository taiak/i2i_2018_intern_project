<?php
ob_start();
@session_start();

require('soap.php');
require('classSystem.php');

if($_SESSION){
	
	$userInfo = $cell2i->userInfoBlock($_SESSION['MSISDN']);
	$userName = $userInfo[1].' '.$userInfo[2];
	$userPhone = $userInfo[0];
	$tariffInfo = $cell2i->tariffInfo($_SESSION['MSISDN']);
	
		$userTariff = $tariffInfo[0];
		$MBLimit = $tariffInfo[3];
		$MinuteLimit = $tariffInfo[1];
		$SMSLimit = $tariffInfo[2];
		
		$usableMB = $cell2i->tariffUsage($_SESSION['MSISDN'],'DATA');
		$usableMinute = $cell2i->tariffUsage($_SESSION['MSISDN'],'VOICE');
		$usableSMS = $cell2i->tariffUsage($_SESSION['MSISDN'],'SMS');

		$GBLimit = $cell2i->changeMBtoGB($MBLimit);
		$usableMB = $cell2i->fraction($cell2i->changeMBtoGB($usableMB[1]));
		$usableMBPercent = $cell2i->percentOperation($GBLimit,$usableMB);
		$usableMinutePercent = $cell2i->percentOperation($MinuteLimit,$usableMinute[1]);
		$usableSMSPercent = $cell2i->percentOperation($SMSLimit,$usableSMS[1]);

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
								<span class="box fsize36 lineHeight50"><?php echo $userName;?></span>
							</span>
						</div>
					</div>
					<div class="row">
						<div class="box col-12 a-center">
							<span class="dInlineBlock">
								<span class="col"><img src="img/smartphone.png"/></span>
								<span class="box fsize36 lineHeight50"><?php echo $userPhone;?></span>
							</span>
						</div>
					</div>
					<div class="row">
						<div class="box col-12 a-center">
							<span class="dInlineBlock">
								<span class="col"><img src="img/tariffArticle.png"/></span>
								<span class="box fsize36 lineHeight50"><?php echo $userTariff;?></span>
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
										<div class="col redBar a-center lineHeight35 fsize24" style="width:<?php echo $usableMBPercent;?>%"><?php echo $usableMB;?> GB</div>
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
										<div class="col redBar a-center lineHeight35 fsize24" style="width:<?php echo $usableMinutePercent;?>%"><?php echo $usableMinute[1];?> DK</div>
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
										<div class="col redBar a-center lineHeight35 fsize24" style="width:<?php echo $usableSMSPercent;?>%"><?php echo $usableSMS[1];?> SMS</div>
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