<?php
$idchannelPOST = $_POST["idchannel"];
$apikeyPOST = $_POST["apikey"];
header("Location: https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&allThreadsRelatedToChannelId=$idchannelPOST&key=$apikeyPOST");
?>
