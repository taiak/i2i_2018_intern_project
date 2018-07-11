<?php
ob_start();
@session_start();

require('soap.php');
require('classSystem.php');

if($_SESSION){
	
	$userInfo = $cell2i->userInfoBlock($_SESSION['MSISDN']);
	$userName = $userInfo[1].' '.$userInfo[2];
	$defaultPhoneX = " XXX XX XX";
	$userPhone = substr($userInfo[0],0,3).$defaultPhoneX;
	$tariffInfo = $cell2i->tariffInfo($_SESSION['MSISDN']);
	if(!empty($tariffInfo)){
		$userTariff = $tariffInfo[0];
		$GBLimit = $tariffInfo[1];
		$MinuteLimit = $tariffInfo[2];
		$SMSLimit = $tariffInfo[3];
	}
	if(!empty($userTariff)){
		$tariffUsage = $cell2i->tariffUsage($_SESSION['MSISDN'],$userTariff);
	}
	if(!empty($tariffUsage)){
		if(!empty($tariffUsage[1])){$usableMB = $tariffUsage[1];}else{$usableMB = 0;}
		if(!empty($tariffUsage[2])){$usableMinute = $tariffUsage[2];}else{$usableMinute = 0;}
		if(!empty($tariffUsage[3])){$usableSMS = $tariffUsage[3];}else{$usableSMS = 0;}
	}
	if(!empty($tariffInfo) && !empty($tariffUsage)){
		$GBNewLimit = $cell2i->changeGBtoMB($GBLimit);
		$usableMBPercent = $cell2i->percentOperation($GBNewLimit,$usableMB);
		$usableMinutePercent = $cell2i->percentOperation($MinuteLimit,$usableMinute);
		$usableSMSPercent = $cell2i->percentOperation($SMSLimit,$usableSMS);
	}else{
		$usableMBPercent = "ERROR";
		$usableMinutePercent = "ERROR";
		$usableSMSPercent = "ERROR";
	}


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
				<a href="invoicePage.php" class="box col-2 a-center Btn" title="Faturalarım"><img src="img/invoiceIcon.png"/></a>
				<a href="logout.php" class="box col-2 a-center Btn" title="Oturumu Kapat"><img src="img/logoutIcon.png"/></a>
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
				<div class="box col-12">
					<div class="row">
						<div class="box col-12 a-center">
							<span class="dInlineBlock">
								<span class="col"><img src="img/user.png"/></span>
								<span class="box fsize16 lineHeight22"><?php echo $userName;?></span>
							</span>
						</div>
					</div>
					<div class="row">
						<div class="box col-12 a-center">
							<span class="dInlineBlock">
								<span class="col"><img src="img/smartphone.png"/></span>
								<span class="box fsize16 lineHeight22"><?php echo $userPhone;?></span>
							</span>
						</div>
					</div>
					<div class="row">
						<div class="box col-12 a-center">
							<span class="dInlineBlock">
								<span class="col"><img src="img/tariffArticle.png"/></span>
								<span class="box fsize16 lineHeight22"><?php echo $userTariff;?></span>
							</span>
						</div>
					</div>
					<div class="row">
						<div class="box col-12">
							<div class="row">
								<div class="box col-10"></div>
								<div class="box col-2 fsize16">
									<?php echo $GBLimit;?> GB
								</div>
							</div>
							<div class="row">
								<div class="col col-10 col-sm-12 greenBar lineHeight22">
									<div class="row">
										<div class="col redBar a-right lineHeight22" style="width:<?php echo $usableMBPercent;?>%"><?php echo $usableMB;?> MB</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="box col-12">
							<div class="row">
								<div class="box col-10"></div>
								<div class="box col-2 fsize16">
									<?php echo $MinuteLimit;?> DK
								</div>
							</div>
							<div class="row">
								<div class="col col-10 col-sm-12 greenBar lineHeight22">
									<div class="row">
										<div class="col redBar a-right lineHeight22" style="width:<?php echo $usableMinutePercent;?>%"><?php echo $usableMinute;?> DK</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="box col-12">
							<div class="row">
								<div class="box col-10"></div>
								<div class="box col-2 fsize16">
									<?php echo $SMSLimit;?> SMS
								</div>
							</div>
							<div class="row">
								<div class="col col-10 col-sm-12 greenBar lineHeight22">
									<div class="row">
										<div class="col redBar a-right lineHeight22" style="width:<?php echo $usableSMSPercent;?>%"><?php echo $usableSMS;?> SMS</div>
									</div>
								</div>
							</div>
						</div>
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