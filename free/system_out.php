<?php
require(dirname(__FILE__)."/include/config_base.php");
$message='�û�'.GetCookie('VioomaUserID').'�ɹ��˳�ϵͳ';
$outtime=GetDatetimeMk(time());
$theip=getip();
WriteNote($message,$outtime,$theip,GetCookie('VioomaUserID'));
DropCookie('VioomaUserID');
?>