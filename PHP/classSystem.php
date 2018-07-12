<?php
ob_start();
@session_start();

class cell2i{
	public $WebServiceOutput;
	public $changeMBtoGBOutput;
	public $OneGB;
	public $percentOutput;
	public $valueFraction, $valueArray, $valueFractionOutput;
	public function UserLogin($msisdn,$password){
		require('soap.php');
		require('errors.php');
		if(!empty($msisdn) && !empty($password)){
			$input = array(
				'userId' => $msisdn,
				'password' => $password
			);
			
			$WebServiceOutput = $WebService->isAuthorized($input);

			foreach($WebServiceOutput AS $UserLogin => $ReturnValue){
				if($ReturnValue == 1){
					$_SESSION['MSISDN'] = $msisdn;
					header('Location:index.php');
				}else{
					echo $loginError2;
				}
			}
			

		}else{
			echo $loginError1;
		}
		
	}
	public function ConnectWebService(){
		require('soap.php');
		$WebServiceOutput = $WebService->isConnected();
		foreach($WebServiceOutput AS $ConnectWebService => $ReturnValue){
			echo $ReturnValue;
		}
	}
	public function changeMBtoGB($MBValue){
		$OneGB = 1000;
		$changeMBtoGBOutput = $MBValue/$OneGB;
		return $changeMBtoGBOutput;
	}
	public function percentOperation($bigNumber,$smallNumber){
		$percentOutput = $smallNumber/($bigNumber/100);
		return $percentOutput;
	}
	public function fraction($value){
		$valueArray = explode(".",$value);
		$valueFraction = substr($valueArray[1],0,2);
		$valueFractionOutput = $valueArray[0].'.'.$valueFraction;
		return $valueFractionOutput;
	}
	public function tariffInfo($msisdn){
		require('soap.php');
		require('errors.php');
		$input = array(
				'userId' => $msisdn
			);
		$WebServiceOutput = $WebService->getTariffInfo($input);	
			foreach($WebServiceOutput AS $getTariffInfo => $ReturnValue){
				$tariffInfoBlock = explode("_",$ReturnValue);
						return $tariffInfoBlock;
			}
			
	}
	public function tariffUsage($msisdn,$infoType){
		require('soap.php');
		require('errors.php');
		$input = array(
				'userId' => $msisdn,
				'infoType' => $infoType
			);
		$WebServiceOutput = $WebService->getUsageInfo($input);	
			foreach($WebServiceOutput AS $getUsageInfo => $ReturnValue){
				$tariffUsageBlock = explode("_",$ReturnValue);
						return $tariffUsageBlock;
			}
			
	}
	
	public function changePassword($msisdn,$password1,$password2){
		require('errors.php');
		require('soap.php');
		$input = array(
				'userId' => $msisdn,
				'password' => $password1
			);
		if($this->passwordMatchControl($password1,$password2) == 1){
			if($this->passwordControl($password1) == 1){
				$WebServiceOutput = $WebService->changeUserPassword($input);
				foreach($WebServiceOutput AS $ChangePassword => $ReturnValue){
					if($ReturnValue == TRUE){
						echo '<font class="color6">Password Confirmed</font>';
					}elseif($ReturnValue == FALSE){

					}
				}
			}else{
				echo $changePasswordError2;
			}
		}else{
			echo $changePasswordError1;
		}
		
	
	}
	
	public function passwordControl($password){
		$password_length = 8;
		$returnVal = 1;
		if ( strlen($password) < $password_length ) {
			$returnVal = 0;
		}
		if ( !preg_match("#[0-9]+#", $password) ) {
			$returnVal = 0;
		}
		/*if ( !preg_match("#[a-z]+#", $password) ) {
			$returnVal = 0;
		}
		if ( !preg_match("#[A-Z]+#", $password) ) {
			$returnVal = 0;
		}*/
		if ( !preg_match("/[\'^£$%&*()}{@#~?.><>,|=_+!-]/", $password) ) {
			$returnVal = 0;
		}
		return $returnVal;
	}
	public function passwordMatchControl($password1,$password2){
		if($password1 === $password2){
			return 1;
		}else{
			return 0;
		}
	}
	public function userInfoBlock($msisdn){
		require('errors.php');
		require('soap.php');
		$input = array(
				'userId' => $msisdn
			);
			$WebServiceOutput = $WebService->getUserInfo($input);
				foreach($WebServiceOutput AS $UserInfo => $ReturnValue){
					if($ReturnValue){
						$userInfoBlock = explode("_",$ReturnValue);
						return $userInfoBlock;
					}else{

					}
				}
				
	}
	public function invoiceBlock($msisdn,$invoiceCount){
		require('errors.php');
		require('soap.php');
		$input = array(
				'userId' => $msisdn,
				'invoiceCount' => $invoiceCount
			);
			$WebServiceOutput = $WebService->getInvoiceInfo($input);
			
				foreach($WebServiceOutput AS $UserInfo => $ReturnValue){
						if($ReturnValue){
							$userInvoiceBlock = explode("@",$ReturnValue);
							for($i = 0; $i < $invoiceCount; $i++){
								$userInvoiceArray = explode("_",$userInvoiceBlock[$i]);
								
								$invoiceFirstArray = explode(".",$userInvoiceArray[0]);
								$invoiceMonth = $invoiceFirstArray[1];
								
								$month = array(
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
								
								if($userInvoiceArray[3] == 0){
									$invoiceStatus = "NOT PAID";
								}elseif($userInvoiceArray[3] == 1){
									$invoiceStatus = "PAID";
								}
								
								$InvoiceArray = array(
									$i => array(
										'invoiceMonth' => $month[$invoiceMonth],
										'lastDate' => $userInvoiceArray[1],
										'price' => $userInvoiceArray[2],
										'status' => $invoiceStatus
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