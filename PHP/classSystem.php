<?php
OB_START();
@SESSION_START();

CLASS cell2i{
	PUBLIC $WebServiceOutput;
	PUBLIC FUNCTION UserLogin($Msisdn,$Password){
		REQUIRE('soap.php');
		REQUIRE('errors.php');
		$this->LogWrite("-----class -> cell2i , function -> UserLogin-----");
		IF(!EMPTY($Msisdn) && !EMPTY($Password)){
			$this->LogWrite("Msisdn ve Password değerleri alındı");
			$Input = array(
				'userId' => $Msisdn,
				'password' => $Password
			);
			$this->LogWrite("Msisdn ve Password değerleri dizi(array) haline getirildi");
			$WebServiceOutput = $WebService->isAuthorized($Input);
			
			FOREACH($WebServiceOutput AS $UserLogin => $RETURNValue){
				IF($RETURNValue == 1){
					$this->LogWrite("WebServisten bilgi çekiliyor");	
					$_SESSION['Msisdn'] = $Msisdn;
					$this->LogWrite("Login işlemi yapıldı");
					header('Location:index.php');
				}ELSE{
					$this->LogWrite("Login işlemi yapılamadı");
					ECHO $LoginError2;
				}
			}
			

		}ELSE{
			$this->LogWrite("Msisdn ve Password değerleri alınamadı");
			ECHO $LoginError1;
			
		}
		$this->LogWrite("-----class -> cell2i , function -> UserLogin-----");
	}
	PUBLIC FUNCTION ConnectWebService(){
		REQUIRE('soap.php');
		$this->LogWrite("-----class -> cell2i , function -> ConnectWebService-----");
		$WebServiceOutput = $WebService->isConnected();
		FOREACH($WebServiceOutput AS $ConnectWebService => $ReturnValue){
			$this->LogWrite("WebServisten bilgi çekiliyor");	
			ECHO $ReturnValue;
			$this->LogWrite("Bağlantı durumu sorgulandı.Bağlantı Durumu: ".$RETURNValue);
		}
		$this->LogWrite("-----class -> cell2i , function -> ConnectWebService-----");
	}
	PUBLIC FUNCTION ChangeMBtoGB($MBValue){//CONVERT
		$this->LogWrite("-----class -> cell2i , function -> ChangeMBtoGB-----");
		$OneGB = 1000;
		$this->LogWrite(" OneGB = 1000 ");
		$ChangeMBtoGBOutput = $MBValue/$OneGB;
		$this->LogWrite(" ".$ChangeMBtoGBOutput."=".$MBValue."/".$OneGB." ");
		$ChangeMBtoGBOutput = number_format($ChangeMBtoGBOutput,2,'.','');
		$this->LogWrite(" ChangeMBtoGBOutput = ".$ChangeMBtoGBOutput." ");
		$this->LogWrite("-----class -> cell2i , function -> ChangeMBtoGB-----");
		RETURN $ChangeMBtoGBOutput;
		
	}
	PUBLIC FUNCTION PercentOperation($BigNumber,$SmallNumber){
		$this->LogWrite("-----class -> cell2i , function -> PercentOperation-----");
		$PercentOutput = $SmallNumber/($BigNumber/100);
		$this->LogWrite(" ".$PercentOutput."=".$SmallNumber."/(".$BigNumber."/100) ");
		$this->LogWrite("-----class -> cell2i , function -> PercentOperation-----");
		RETURN $PercentOutput;
	}
	PUBLIC FUNCTION TariffInfo($Msisdn){
		$this->LogWrite("-----class -> cell2i , function -> TariffInfo-----");
		REQUIRE('soap.php');
		REQUIRE('errors.php');
		$Input = ARRAY(
				'userId' => $Msisdn
			);
		$this->LogWrite("Msisdn değerini dizi(array) haline getirildi");
		$WebServiceOutput = $WebService->getTariffInfo($Input);	
			FOREACH($WebServiceOutput AS $GetTariffInfo => $ReturnValue){
				$this->LogWrite("WebServisten bilgi çekiliyor");	
				$TariffInfoBlock = EXPLODE("_",$ReturnValue);
				$this->LogWrite("WebServisten çekilen tarife bilgilerini '_' değerlerine göre ayırarak dizi(array) haline getirildi");
						RETURN $TariffInfoBlock;
			}
		$this->LogWrite("-----class -> cell2i , function -> TariffInfo-----");
	}
	PUBLIC FUNCTION TariffUsage($Msisdn,$InfoType){
		REQUIRE('soap.php');
		REQUIRE('errors.php');
		$this->LogWrite("-----class -> cell2i , function -> TariffUsage-----");
		$Input = ARRAY(
				'userId' => $Msisdn,
				'infoType' => $InfoType
			);
		$this->LogWrite("Msisdn ve InfoType değerleri dizi(array) haline getirildi");
		$WebServiceOutput = $WebService->GetUsageInfo($Input);	
			FOREACH($WebServiceOutput AS $GetUsageInfo => $ReturnValue){
				$this->LogWrite("WebServisten bilgi çekiliyor");	
				$TariffUsageBlock = EXPLODE("_",$ReturnValue);
				$this->LogWrite("WebServisten çekilen kullanılan tarife bilgilerini '_' değerlerine göre ayırarak dizi(array) haline getirildi");
						RETURN $TariffUsageBlock;
			}
		$this->LogWrite("-----class -> cell2i , function -> TariffUsage-----");	
	}
	
	PUBLIC FUNCTION ChangePassword($Msisdn,$Password1,$Password2){
		REQUIRE('errors.php');
		REQUIRE('soap.php');
		$this->LogWrite("-----class -> cell2i , function -> ChangePassword-----");
		$Input = ARRAY(
				'userId' => $Msisdn,
				'password' => $Password1
			);
		$this->LogWrite("Msisdn ve Password1 değerleri dizi(array) haline getirildi");
		IF($this->PasswordMatchControl($Password1,$Password2) == 1){
			$this->LogWrite("Password1 ve Password2 değerlerinin birbirine eşit olduğu onaylandı");
			IF($this->PasswordControl($Password1) == 1){
				$this->LogWrite("Password değeri istenilen niteliklere uygun olduğu onaylandı");
				$WebServiceOutput = $WebService->changeUserPassword($Input);
				FOREACH($WebServiceOutput AS $ChangePassword => $ReturnValue){
					IF($ReturnValue == TRUE){
						$this->LogWrite("WebServisten bilgi çekiliyor");	
						$this->LogWrite("WebServis ile Password Yenilendi");
						ECHO '<font class="color6">Password Confirmed</font>';
					}ELSEIF($ReturnValue == FALSE){
						$this->LogWrite("WebServisten Password için olumsuz sonuç dönüşü oldu");
					}
				}
			}ELSE{
				$this->LogWrite("Password değeri istenilen niteliklere uygun olduğu onaylanmadı");
				ECHO $ChangePasswordError2;
			}
		}ELSE{
			$this->LogWrite("Password1 ile Password2 değerlerinin eşleşmediği tespit edildi");
			ECHO $ChangePasswordError1;
		}
		
		$this->LogWrite("-----class -> cell2i , function -> ChangePassword-----");
	}
	
	PUBLIC FUNCTION PasswordControl($Password){
		$this->LogWrite("-----class -> cell2i , function -> PasswordControl-----");
		$PasswordLength = 8;
		$this->LogWrite(" PasswordLength = 8 ");
		$ReturnVal = 1;
		$this->LogWrite(" ReturnVal = 1 ");
		IF ( STRLEN($Password) < $PasswordLength ) {
			$this->LogWrite("Password değerinin uzunluğu yetersiz olduğu anlaşıldı ve sonuç olumsuza çevrildi");
			$ReturnVal = 0;
		}
		IF ( !PREG_MATCH("#[0-9]+#", $Password) ) {
			$this->LogWrite("Password değerinin içinde sayı kullanılmadığı anlaşıldı ve sonuç olumsuza çevrildi");
			$ReturnVal = 0;
		}
		IF ( !PREG_MATCH("/[\'^£$%&*()}{@#~?.><>,|=_+!-]/", $Password) ) {
			$this->LogWrite("Password değerinin içinde özel karakter kullanılmadığı anlaşıldı ve sonuç olumsuza çevrildi");
			$ReturnVal = 0;
		}
		RETURN $ReturnVal;
		$this->LogWrite("-----class -> cell2i , function -> PasswordControl-----");
	}
	PUBLIC FUNCTION PasswordMatchControl($Password1,$Password2){
		$this->LogWrite("-----class -> cell2i , function -> PasswordMatchControl-----");
		IF($Password1 === $Password2){
			$this->LogWrite("Password1 ve Password2 değerlerinin eşit olduğu anlaşıldı ve sonuç olumlu olarak tanımlandı");
			RETURN 1;
		}ELSE{
			$this->LogWrite("Password1 ve Password2 değerlerinin eşit olmadığı anlaşıldı ve sonuç olumsuz olarak tanımlandı");
			RETURN 0;
		}
		$this->LogWrite("-----class -> cell2i , function -> PasswordMatchControl-----");
	}
	PUBLIC FUNCTION UserInfoBlock($Msisdn){
		REQUIRE('errors.php');
		REQUIRE('soap.php');
		$this->LogWrite("-----class -> cell2i , function -> UserInfoBlock-----");
		$Input = ARRAY(
				'userId' => $Msisdn
			);
		$this->LogWrite("Msisdn değeri dizi(array) haline getirildi");
			$WebServiceOutput = $WebService->getUserInfo($Input);
				FOREACH($WebServiceOutput AS $UserInfo => $ReturnValue){
					IF($ReturnValue){
						$this->LogWrite("WebServisten bilgi çekiliyor");	
						$UserInfoBlock = EXPLODE("_",$ReturnValue);
						$this->LogWrite("WebServisten çekilen kullanıcı bilgilerini '_' değerlerine göre ayırarak dizi(array) haline getirildi");
						RETURN $UserInfoBlock;
					}ELSE{
						$this->LogWrite("WebServisten kullanıcı bilgileri için olumsuz sonuç dönüşü oldu");
					}
				}
		$this->LogWrite("-----class -> cell2i , function -> UserInfoBlock-----");		
	}
	PUBLIC FUNCTION InvoiceBlock($Msisdn,$InvoiceCount){
		REQUIRE('errors.php');
		REQUIRE('soap.php');
		$this->LogWrite("-----class -> cell2i , function -> InvoiceBlock-----");	
		$Input = ARRAY(
				'userId' => $Msisdn,
				'invoiceCount' => $InvoiceCount
			);
			$this->LogWrite("Msisdn ve InvoiceCount değerleri dizi(array) haline getirildi");	
			$WebServiceOutput = $WebService->getInvoiceInfo($Input);
			
			
				FOREACH($WebServiceOutput AS $UserInfo => $ReturnValue){
						IF($ReturnValue){
							$this->LogWrite("WebServisten bilgi çekiliyor");	
							$UserInvoiceBlock = EXPLODE("@",$ReturnValue);
							$this->LogWrite("Çekilen fatura bloğu '@' değerlerine göre ayırarak dizi(array) haline getirildi");	
							FOR($i = $InvoiceCount-1; $i >= 0; $i--){
								$this->LogWrite("Fatura çekiminde döngü değeri:".$i);	
								$UserInvoiceArray = EXPLODE("_",$UserInvoiceBlock[$i]);
								$this->LogWrite("Çekilen faturalar bloğu '_' değerlerine göre ayırarak fatura değerini dizi(array) haline getirildi");	
								$InvoiceFirstArray = EXPLODE(".",$UserInvoiceArray[0]);
								$this->LogWrite("Çekilen fatura bloğu '.' değerlerine göre ayırarak tarih değerini dizi(array) haline getirildi");	
								$InvoiceMonth = $InvoiceFirstArray[1];
								$this->LogWrite("InvoiceMonth=".$InvoiceFirstArray[1]);	
								$Month = ARRAY(
									'01' => 'JANUARY',
									'02' => 'FEBRUARY',
									'03' => 'MARCH',
									'04' => 'APRIL',
									'05' => 'MAY',
									'06' => 'JUNE',
									'07' => 'JULY',
									'08' => 'AUGUST',
									'09' => 'SEPTEMBER',
									'10' => 'OCTOBER',
									'11' => 'NOVEMBER',
									'12' => 'DECEMBER'
								);
								$this->LogWrite("Month adında dizi(array) oluşturarak içine aylar tanımlandı");	
								IF($UserInvoiceArray[3] == 0){
									$this->LogWrite("Ödeme durumunu 'NOT PAID' olarak tanımlandı");	
									$InvoiceStatus = "NOT PAID";
								}ELSEIF($UserInvoiceArray[3] == 1){
									$this->LogWrite("Ödeme durumunu 'PAID' olarak tanımlandı");
									$InvoiceStatus = "PAID";
								}
								
								$InvoiceArray = ARRAY(
									$i => ARRAY(
										'InvoiceMonth' => $Month[$InvoiceMonth],
										'InvoiceDate' => $UserInvoiceArray[1],
										'Cost' => $UserInvoiceArray[2],
										'PaidStatus' => $InvoiceStatus
									)
								);
									$this->LogWrite("InvoiceArray adında dizi(array) içinde faturalar düzenli bir dizi(array) haline getirildi");								
								IF(EMPTY($InvoiceAllArray)){
									$this->LogWrite("InvoiceAllArray değeri ilk defa oluşturuluyor");
									$InvoiceAllArray = $InvoiceArray;
								}ELSE{
									$this->LogWrite("InvoiceAllArray değerine yeni InvoiceArray dizi(array) değeri eklendi");
									$InvoiceAllArray = ARRAY_MERGE($InvoiceAllArray, $InvoiceArray);
								}
								
							}
							
									$this->LogWrite("InvoiceAllArray dizi(array)leri gönderildi");
							RETURN $InvoiceAllArray;
						}ELSE{
							$this->LogWrite("WebServisten fatura bilgileri için olumsuz sonuç dönüşü oldu");
							RETURN 0;
						}
					
	
				}
				
		
		$this->LogWrite("-----class -> cell2i , function -> UserInfoBlock-----");	
	}
	PRIVATE FUNCTION LogWrite($LogInput){
		date_default_timezone_set('Etc/GMT-3');
		$Time = DATE("d.m.Y , H:i:s");
		$Ip = GETENV("REMOTE_ADDR");
		IF(!EMPTY($_SESSION['Msisdn'])){
			$SessionUser = $_SESSION['Msisdn'];
		}ELSE{
			$SessionUser = "GUEST";
		}
		$LogArticle = "Date->".$Time." / Ip->".$Ip." / SessionUser->".$SessionUser." / Operation->".$LogInput."\n\n";
		$LogFile = FOPEN("log.txt", "a");
		FWRITE($LogFile, $LogArticle);
		FCLOSE($LogFile);
	}
}
$cell2i= NEW cell2i;



OB_END_FLUSH();
?>