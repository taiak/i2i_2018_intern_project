<?php
ob_start();
@session_start();

class cell2i{
	public $WebServiceOutput;
	public $changeMBtoGBOutput;
	public $OneGB;
	public $percentOutput;
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
					
				}elseif($ReturnValue == 0){
					echo $loginError2;
				}
			}
			
			header('Location:index.php');
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
	public function invoiceBlock(){
		require('errors.php');
		require('soap.php');
		$input = array(
				'userId' => '5369722537'
			);
			$WebServiceOutput = $WebService->getInvoiceInfo($input);
				foreach($WebServiceOutput AS $UserInfo => $ReturnValue){
					if($ReturnValue){
						$userInfoBlock = explode("_",$ReturnValue);
						return $userInfoBlock;
					}else{

					}
				}
		
		
	}
}
$cell2i= new cell2i;



ob_end_flush();
?>