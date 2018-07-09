<?php
class cell2i{
	public $WebServiceOutput;
	public function UserLogin($phoneNumber,$password){
		$input = array(
			'userId' => $phoneNumber,
			'password' => $password
			);

		$WebServiceOutput = $WebService->isAuthorized($input);
		foreach($WebServiceOutput AS $UserLogin => $ReturnValue){
			return $ReturnValue;
		}
	}
	public function ConnectWebService(){
		require('soap.php');
		$WebServiceOutput = $WebService->isConnected();
		foreach($WebServiceOutput AS $ConnectWebService => $ReturnValue){
			return $ReturnValue;
		}
	}	
}
$cell2i= new cell2i;
?>