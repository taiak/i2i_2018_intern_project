<?php
	IF(GETENV("HTTP_CLIENT_IP")) {
	 $IP = GETENV("HTTP_CLIENT_IP");
	 }ELSEIF(GETENV("HTTP_X_FORWARDED_FOR")) {
	 $IP = GETENV("HTTP_X_FORWARDED_FOR");
	 IF (STRSTR($ip, ',')) {
	 $TMP = EXPLODE(',', $IP);
	 $IP = TRIM($TMP[0]);
	 }
	 }ELSE{
	 $IP = GETENV("REMOTE_ADDR");
	 }
	 echo $IP;
	 ?>