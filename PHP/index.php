<?php
require('soap.php');
require('classSystem.php');
$cell2i->ConnectWebService();

if($_GET['pg']){
$pageLink=$_GET['pg'];
$phpFile=$pageLink.'.php';

require($phpFile);

}else{
	echo 'INDEX';
}
?>