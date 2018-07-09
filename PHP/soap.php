Web Servis adresi -> http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl
<br>
<?php
 
// wsdl cache 'ini devre disi birak
ini_set("soap.wsdl_cache_enabled", "0");
 
try {
 

 
 
 
 // SOAPClient nesnesi olustur
  $client = new SoapClient("http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl");
 
  // SOAPClient uzerinden karsi sunucudaki getAllNotebooks metodunu cagir
  $notebooks = $client->success_statu();

 
 
  echo "Metod basarili bir sekilde calistirildi.<br/>Sonuc asagidadir.<br/>";
 
  echo  "<pre>";
  // Sonucu ekrana bas
  var_dump($notebooks);
  echo  "</pre>";
} catch (Exception $exc) { // Hata olusursa yakala
  echo "Soap Hatasi Olustu: " . $exc->getMessage();
}


?>