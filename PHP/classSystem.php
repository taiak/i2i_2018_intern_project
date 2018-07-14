<?php
ob_start();
@session_start();

class cell2i{
	public $WebServiceOutput;
	public function UserLogin($Msisdn,$Password){
		require('soap.php');
		require('errors.php');
		if(!empty($Msisdn) && !empty($Password)){
			$Input = array(
				'userId' => $Msisdn,
				'password' => $Password
			);
			
			$WebServiceOutput = $WebService->isAuthorized($Input);

			foreach($WebServiceOutput AS $UserLogin => $ReturnValue){
				if($ReturnValue == 1){
					$_SESSION['Msisdn'] = $Msisdn;
					header('Location:index.php');
				}else{
					echo $LoginError2;
				}
			}
			

		}else{
			echo $LoginError1;
		}
		
	}
	public function ConnectWebService(){
		require('soap.php');
		$WebServiceOutput = $WebService->isConnected();
		foreach($WebServiceOutput AS $ConnectWebService => $ReturnValue){
			echo $ReturnValue;
		}
	}
	public function ChangeMBtoGB($MBValue){
		$OneGB = 1000;
		$ChangeMBtoGBOutput = $MBValue/$OneGB;
		$ChangeMBtoGBOutput = number_format($ChangeMBtoGBOutput,2,'.','');
		return $ChangeMBtoGBOutput;
	}
	public function PercentOperation($BigNumber,$SmallNumber){
		$PercentOutput = $SmallNumber/($BigNumber/100);
		return $PercentOutput;
	}
	public function TariffInfo($Msisdn){
		require('soap.php');
		require('errors.php');
		$Input = array(
				'userId' => $Msisdn
			);
		$WebServiceOutput = $WebService->getTariffInfo($Input);	
			foreach($WebServiceOutput AS $GetTariffInfo => $ReturnValue){
				$TariffInfoBlock = explode("_",$ReturnValue);
						return $TariffInfoBlock;
			}
			
	}
	public function TariffUsage($Msisdn,$InfoType){
		require('soap.php');
		require('errors.php');
		$Input = array(
				'userId' => $Msisdn,
				'infoType' => $InfoType
			);
		$WebServiceOutput = $WebService->GetUsageInfo($Input);	
			foreach($WebServiceOutput AS $GetUsageInfo => $ReturnValue){
				$TariffUsageBlock = explode("_",$ReturnValue);
						return $TariffUsageBlock;
			}
			
	}
	
	public function ChangePassword($Msisdn,$Password1,$Password2){
		require('errors.php');
		require('soap.php');
		$Input = array(
				'userId' => $Msisdn,
				'Password' => $Password1
			);
		if($this->PasswordMatchControl($Password1,$Password2) == 1){
			if($this->PasswordControl($Password1) == 1){
				$WebServiceOutput = $WebService->changeUserPassword($Input);
				foreach($WebServiceOutput AS $ChangePassword => $ReturnValue){
					if($ReturnValue == TRUE){
						echo '<font class="color6">Password Confirmed</font>';
					}elseif($ReturnValue == FALSE){

					}
				}
			}else{
				echo $ChangePasswordError2;
			}
		}else{
			echo $ChangePasswordError1;
		}
		
	
	}
	
	public function PasswordControl($Password){
		$PasswordLength = 8;
		$ReturnVal = 1;
		if ( strlen($Password) < $PasswordLength ) {
			$ReturnVal = 0;
		}
		if ( !preg_match("#[0-9]+#", $Password) ) {
			$ReturnVal = 0;
		}
		if ( !preg_match("/[\'^£$%&*()}{@#~?.><>,|=_+!-]/", $Password) ) {
			$ReturnVal = 0;
		}
		return $ReturnVal;
	}
	public function PasswordMatchControl($Password1,$Password2){
		if($Password1 === $Password2){
			return 1;
		}else{
			return 0;
		}
	}
	public function UserInfoBlock($Msisdn){
		require('errors.php');
		require('soap.php');
		$Input = array(
				'userId' => $Msisdn
			);
			$WebServiceOutput = $WebService->getUserInfo($Input);
				foreach($WebServiceOutput AS $UserInfo => $ReturnValue){
					if($ReturnValue){
						$UserInfoBlock = explode("_",$ReturnValue);
						return $UserInfoBlock;
					}else{

					}
				}
				
	}
	public function InvoiceBlock($Msisdn,$InvoiceCount){
		require('errors.php');
		require('soap.php');
		$Input = array(
				'userId' => $Msisdn,
				'invoiceCount' => $InvoiceCount
			);
			$WebServiceOutput = $WebService->getInvoiceInfo($Input);
			
			
				foreach($WebServiceOutput AS $UserInfo => $ReturnValue){
						if($ReturnValue){
							$UserInvoiceBlock = explode("@",$ReturnValue);
							for($i = $InvoiceCount-1; $i >= 0; $i--){
								$UserInvoiceArray = explode("_",$UserInvoiceBlock[$i]);
								
								$InvoiceFirstArray = explode(".",$UserInvoiceArray[0]);
								$InvoiceMonth = $InvoiceFirstArray[1];
								
								$Month = array(
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
								
								if($UserInvoiceArray[3] == 0){
									$InvoiceStatus = "NOT PAID";
								}elseif($UserInvoiceArray[3] == 1){
									$InvoiceStatus = "PAID";
								}
								
								$InvoiceArray = array(
									$i => array(
										'InvoiceMonth' => $Month[$InvoiceMonth],
										'InvoiceDate' => $UserInvoiceArray[1],
										'Cost' => $UserInvoiceArray[2],
										'PaidStatus' => $InvoiceStatus
									)
								);
								
								if(empty($InvoiceAllArray)){
									$InvoiceAllArray = $InvoiceArray;
								}else{
									$InvoiceAllArray = array_merge($InvoiceAllArray, $InvoiceArray);
								}
								
							}
							
							return $InvoiceAllArray;
						}else{
							return 0;
						}
					
	
				}
				
		
		
	}
}
$cell2i= new cell2i;



ob_end_flush();
?>