<?php
require_once(dirname(__FILE__)."/include/config_base.php");
require_once(dirname(__FILE__)."/include/a_code.php");
require_once(dirname(__FILE__)."/include/cryption.php");
require(dirname(__FILE__)."/include/config_rglobals.php");
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="style/main.css" rel="stylesheet" type="text/css" />
<title>ViooMa������ϵͳע��</title>
</head>
<body>
<?
function GetBackAlert($msg,$isstop=0)
{
	$msg = str_replace('"','`',$msg);
  if($isstop==1) $msg = "<script>\r\n<!--\r\n alert(\"{$msg}\");\r\n-->\r\n</script>\r\n";
  else $msg = "<script>\r\n<!--\r\n alert(\"{$msg}\");history.go(-1);\r\n-->\r\n</script>\r\n";
  $msg = "<meta http-equiv=content-type content='text/html; charset=gb2312'>\r\n".$msg;
  return $msg;
}
?>
<table width="100%" border="0" id="table_style_all" cellpadding="0" cellspacing="0">
  <tr>
    <td id="table_style" class="l_t">&nbsp;</td>
    <td>&nbsp;</td>
    <td id="table_style" class="r_t">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
	<table width="100%" border="0" cellpadding="8" cellspacing="1">
	<form action="regsiter.php?action=sure" method="post">
     <tr>
      <td>
       <b>ViooMa������ ϵͳע��</b>
	  </td>
     </tr>
	 <tr bgcolor="#FFFFFF">
	  <td style="line-height:150%">
	  <?php
	  //��Ȩ�����洢����
	  if ($action=='sure'){
	   $sql=new dedesql(false);
	   $query="select * from #@__boss";
	   $sql->SetQuery($query);
	   $row=$sql->GetOne();
	   if ($rkey!=$row['key']){
	   echo "<script language='javascript'>alert('���ע���벻���ϱ�׼����ȷ��!��ѯQQ��475994986');history.go(-1);</script>";
	   exit();
	   }
	   if($rfile==''){
	   echo "<script language='javascript'>alert('��������Ȩ�ļ�����ȷ·����');history.go(-1);</script>";
	   exit();
	   }
	   $errstring=GetBackAlert("��ȡ��д����Ȩ�ļ�ʧ�ܣ�����ϵͳ��װĿ¼�Ƿ�ɶ�ȡ��д�룡");
	   $fp = fopen(dirname(__FILE__)."/".$rfile,"r") or die($errstring);
       $key_string1 = fread($fp,filesize($rfile));
       fclose($fp);
	   $aes = new AES(true);
	   $key = "this is a 32 byte key";
	   $keys = $aes->makeKey($key);
	   $key_string = $aes->decryptString($key_string1, $keys);//��һ�ν���
	   $password='userma';
	   $ct = new Crypto;//�ڶ��ν���
	   $strtoencrypt = $ct->decrypt ($password,$key_string);
	   $nowfilename=cn_substr($strtoencrypt,6,0);
	   $php_code_string="/*  ע��˵��:
ViooMa�����棨PHP�棩��Ӧ��С��ҵ�������û�ʹ�ã�����ʵ�ã������򵥣������Զ��������������桱����ȱ�ٵİ��֣�Ψһ�ٷ���վ��http://www.viooma.com ��ѯQQ��475994986 ��ѯ�绰��138731933788��ע�����ϵͳ���Ƶ�����ϵ�ң� */
{}rkey='#request_code#'; //ע����
{}start_date='#date#'; //��ʼʱ��
{}end_faq='#faq#'; //��������
{}request_file='#keyfile#'; //��Ȩ�ļ�
{}request_code='#code#'; //��Ȩ��
{}pay_body='#company_name#'; //��Ȩ�û�
{}rnd_string='#r_name#';//˽����Կ
/*  ע��˵��:
ViooMa�����棨PHP�棩��Ӧ��С��ҵ�������û�ʹ�ã�����ʵ�ã������򵥣������Զ��������������桱����ȱ�ٵİ��֣�Ψһ�ٷ���վ��http://www.viooma.com ��ѯQQ��475994986 ��ѯ�绰��138731933788��ע�����ϵͳ���Ƶ�����ϵ�ң� */";
        $php_code_string=str_replace('#request_code#',$rkey,$php_code_string);
		$php_code_string=str_replace('#date#',GetDateTimeMk(time()),$php_code_string);
		$php_code_string=str_replace('#faq#',15,$php_code_string);
		$php_code_string=str_replace('#keyfile#',$rfile,$php_code_string);
		$php_code_string=str_replace('#code#',$key_string,$php_code_string);
		$php_code_string=str_replace('#company_name#',$company,$php_code_string);
		$php_code_string=str_replace('#r_name#',$nowfilename,$php_code_string);
		$php_code_string=str_replace('{}','$',$php_code_string);
	   $fp1 = fopen(dirname(__FILE__)."/include/".$nowfilename.".php","w") or die($errstring);
  	   fwrite($fp1,"<?php\r\n".$php_code_string."\r\n?>");
	   fclose($fp1);
	   $sql1=new dedesql(false);
	   $query1="update #@__boss set code='$key_string'";
	   $sql1->setquery($query1);
	   $sql1->execute();
	   $sql1->close();
	   header("Location:regsiter.php");
	  }
	  ?>
	  &nbsp;&nbsp;<font color="red">ע��˵��:</font><br>
	  ViooMa�����棨PHP�棩��Ӧ��С��ҵ�������û�ʹ�ã�����ʵ�ã������򵥣������Զ��������������桱����ȱ�ٵİ��֣�Ψһ�ٷ���վ��<a href="http://www.viooma.com" target="_blank">http://www.viooma.com</a>&nbsp;��ѯQQ��<a href="http://wpa.qq.com/msgrd?V=1&Uin=475994986&Site=ioshenmue&M">475994986</a>&nbsp;��ѯ�绰��13873193788��ע�����ϵͳ���Ƶ�����ϵ�ң�
	  </td>
	 </tr>
	 <?php
	 $sql=new dedesql(false);
	 $query="select * from #@__boss";
	 $sql->setquery($query);
	 $row=$sql->getone();
	 ?>
	 <tr>
	  <td bgcolor="#EFEFEF">
	  ViooMa������ע���룺<input type="text" name="rkey" size="20" value="<?php echo $row['key'];?>" onclick="this.select()" readonly>
	  </td>
	 </tr>
	 <?php
	   $password='userma';
	   $ct = new Crypto;//�ڶ��ν���
	   $strtoencrypt = $ct->decrypt ($password,$row['code']);
	   $filename=cn_substr($strtoencrypt,6,0);
	 if($row['key']==str_replace($filename."-",'',$strtoencrypt) && file_exists(dirname(__FILE__)."/include/".$filename.".php")){
	 require(dirname(__FILE__)."/include/".$filename.".php");
	  if($rkey==$row['key'] && $request_code==$row['code'])
	  $Flag=True;
	  else
	  $Flag=False;
	 }
	 else
	 $Flag=False;
	 
	 if($Flag){
	 ?>
	 <tr>
	  <td bgcolor="#FFFFFF">
	  ��Ȩ�룺<?php echo $request_code;?>
	  <br>˽����Կ��<?php echo $rnd_string;?>
	  <br>��Ȩʱ�䣺<?php echo $start_date;?>
	  <br>��Ȩ����<?php echo $pay_body;?>
	  </td>
	 </tr>
	 <?php
	 }
	 else{
	 ?>
	 <tr>
	  <td bgcolor="#EFEFEF">
	  ��Ȩ�ļ�����<input type="text" name="rfile" size="15">&nbsp;��Ȩ�ļ��ɹٷ���������չ��Ϊ.dat���ļ��������ļ��ڷ�������Ŀ¼��
	  </td>
	 </tr>
	 <tr>
	  <td bgcolor="#EFEFEF">
	  ��˾��Ϣ��<input type="text" name="company" size="30">&nbsp;��˾���Ƽ���ϵ�绰��
	  </td>
	 </tr>
	 <tr>
	  <td bgcolor="#FFFFFF">
	  <center><input type="submit" value="  ����ע�����ʽ��  ">
	  </td>
	 </tr>
	 <?php
	 }
	 $sql->close();
	 ?>
	 </form>
    </table>
	</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td id="table_style" class="l_b">&nbsp;</td>
    <td>&nbsp;</td>
    <td id="table_style" class="r_b">&nbsp;</td>
  </tr>
</table>
</body>
</html>
