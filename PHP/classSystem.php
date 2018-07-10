<?php
ob_start();
@session_start();

class cell2i{
	public $WebServiceOutput;
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
				}elseif($ReturnValue == 0){
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
}
$cell2i= new cell2i;



ob_end_flush();
?>