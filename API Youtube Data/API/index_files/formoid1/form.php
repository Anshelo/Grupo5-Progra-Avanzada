<?php

define('EMAIL_FOR_REPORTS', '');
define('RECAPTCHA_PRIVATE_KEY', '@privatekey@');
define('FINISH_URI', 'http://#######');
define('FINISH_ACTION', 'redirect');
define('FINISH_MESSAGE', 'Thanks for filling out my form!');
define('UPLOAD_ALLOWED_FILE_TYPES', 'mp4');

define('_DIR_', str_replace('\\', '/', dirname(__FILE__)) . '/');
require_once _DIR_ . '/handler.php';

?>

<?php if (frmd_message()): ?>
<link rel="stylesheet" href="<?php echo dirname($form_path); ?>/formoid-solid-blue.css" type="text/css" />
<span class="alert alert-success"><?php echo FINISH_MESSAGE; ?></span>
<?php else: ?>
<!-- Start Formoid form-->
<link rel="stylesheet" href="<?php echo dirname($form_path); ?>/formoid-solid-blue.css" type="text/css" />
<script type="text/javascript" src="<?php echo dirname($form_path); ?>/jquery.min.js"></script>
<form enctype="multipart/form-data" class="formoid-solid-blue" style="background-color:#FFFFFF;font-size:14px;font-family:'Roboto',Arial,Helvetica,sans-serif;color:#34495E;max-width:480px;min-width:150px" method="post"><div class="title"><h2>YouTube Data </h2></div>
	<div class="element-input<?php frmd_add_class("input"); ?>"><label class="title"><span class="required">*</span></label><div class="item-cont"><input class="large" type="text" name="input" required="required" placeholder="Video Title"/><span class="icon-place"></span></div></div>
	<div class="element-input<?php frmd_add_class("input1"); ?>"><label class="title"><span class="required">*</span></label><div class="item-cont"><input class="large" type="text" name="input1" required="required" placeholder="Video Description"/><span class="icon-place"></span></div></div>
	<div class="element-file<?php frmd_add_class("file"); ?>"><label class="title"><span class="required">*</span></label><div class="item-cont"><label class="large" ><div class="button">Choose File</div><input type="file" class="file_input" name="file" required="required"/><div class="file_text">No file selected</div><span class="icon-place"></span></label></div></div>
<div class="submit"><input type="submit" value="Submit"/></div></form><script type="text/javascript" src="<?php echo dirname($form_path); ?>/formoid-solid-blue.js"></script>

<!-- Stop Formoid form-->
<?php endif; ?>

<?php frmd_end_form(); ?>