<?php
ob_start();
@session_start();

class cell2i{
	public $WebServiceOutput;
	public $changeGBtoMBOutput;
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
			/*
			$WebServiceOutput = $WebService->isAuthorized($input);

			foreach($WebServiceOutput AS $UserLogin => $ReturnValue){
				if($ReturnValue == 1){
					$_SESSION['MSISDN'] = $msisdn;
					
				}elseif($ReturnValue == 0){
					echo $loginError2;
				}
			}
			*/
				$_SESSION['MSISDN'] = $msisdn;
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
	public function changeGBtoMB($GBValue){
		$OneGB = 1000;
		$changeGBtoMBOutput = $GBValue * $OneGB;
		return $changeGBtoMBOutput;
	}
	public function percentOperation($bigNumber,$smallNumber){
		$percentOutput = $smallNumber/($bigNumber/100);
		return $percentOutput;
	}
	public function tariff(){
		require('soap.php');
		require('errors.php');
		$input = array(
				'userId' => '5369722537'
			);
		$WebServiceOutput = $WebService->getUserTariffName($input);

			foreach($WebServiceOutput AS $UserLogin => $ReturnValue){
				echo 'Tarife->'.$ReturnValue;
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
						echo "Password Confirmed";
					}elseif($ReturnValue == FALSE){
						echo $loginError2;
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
}
$cell2i= new cell2i;



ob_end_flush();
?>