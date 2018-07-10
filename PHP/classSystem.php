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
		$OneGB = 1024;
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
}
$cell2i= new cell2i;



ob_end_flush();
?>