<?php
/**
 * Example Application
 *
 * @package Example-application
 */

require 'libs/Smarty.class.php';
require('urlSettings.php');

$smarty = new Smarty;


require('filePhpField.php');

if($_GET){
$pg = $_GET['pg'];

switch($pg){
	case 'loginPage':
		echo 'LOGIN';
	break;
}



$tpl = array_search($pg,$urlSettings).'.tpl';

$smarty->display($tpl);
}else{
	echo 'INDEX';
}
?>