<?php
try {
  $client = new SoapClient("http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl");
} catch (Exception $exc) { // Hata olusursa yakala
  echo "Soap Hatasi Olustu: " . $exc->getMessage();
}
?>