<?php
$idchannelPOST = $_POST["idchannel"];
$apikeyPOST = $_POST["apikey"];
header("Location: https://www.googleapis.com/youtube/v3/activities?part=snippet,contentDetails&channelId=$idchannelPOST&key=$apikeyPOST");
?>