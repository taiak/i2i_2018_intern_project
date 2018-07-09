<?php

ini_set("soap.wsdl_cache_enabled", "0");

try {
	$WSLink = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";
	$WebService = new SoapClient($WSLink);
	$WebServiceOutput = $WebService->isConnected();
	
	var_dump($WebServiceOutput);

} catch (Exception $exc) { // Hata olusursa yakala
  echo "Soap Hatasi Olustu: " . $exc->getMessage();
}

class cell2i{
	public $WebServiceOutput;
	public function UserLogin($phoneNumber,$password){
		$input = array(
			'userId' => $phoneNumber,
			'password' => $password
			);
		
		/* Manual Login */
		$manualLoginUser = "hasan";
		$manualLoginPass = "hasan1.";
		if(($manualLoginUser == $phoneNumber) && ($manualLoginPass == $password)){
			$WebServiceOutput = 1;
		}else{
			$WebServiceOutput = 0;
		}
		// $WebServiceOutput = $WebService->isAuthorized($input);
		return $WebServiceOutput;
	}
	public function ConnectWebService(){
		$WebServiceOutput = $WebService->isConnected();
		return $WebServiceOutput;
	}
	
}
$cell2i= new cell2i;
?>