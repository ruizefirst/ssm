<?php
require(dirname(__FILE__)."/include/config_base.php");
require(dirname(__FILE__)."/include/config_rglobals.php");
require_once(dirname(__FILE__)."/include/checklogin.php");
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="style/main.css" rel="stylesheet" type="text/css" />
<title><?php echo $cfs_softname;?>���ݻ�ԭ</title>
</head>
<body>
<table width="100%" border="0" id="table_style_all" cellpadding="0" cellspacing="0">
  <tr>
    <td id="table_style" class="l_t">&nbsp;</td>
    <td>&nbsp;</td>
    <td id="table_style" class="r_t">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
	<table width="100%" border="0" cellpadding="0" cellspacing="2">
     <tr>
      <td><strong>&nbsp;���ݻ�ԭ</strong></td>
     </tr>
     <tr>
      <td bgcolor="#FFFFFF">
	  <?php
	  if($action=='save'){
	  if($filename==''){
	  showmsg("��������ȷ�ı����ļ�����!",-1);
	  }
$fp = fopen("/backup/".$filename,"r");

    //�������ݱ��д������
    $query = "";
    while(!feof($fp))
	  {
		   $line = trim(fgets($fp,1024));
		   if(ereg(";$",$line)){
			   $query .= $line;
			   $query = str_replace('#@__',$dbprefix,$query);
			   mysql_query($query,$conn);
			   $query='';
		   }else if(!ereg("^(//|--)",$line)){
			   $query .= $line;
		   }
	  }
	  fclose($fp);

	  $sysquerys = explode(';',$admindatas);
	  foreach($sysquerys as $query){
	  	if(trim($query)!='') mysql_query(str_replace('#@__',$dbprefix,$query),$conn);
	  }
	  mysql_close($conn);    
echo "<table id='table_border' width='100%'><tr><td id='row_style'>&nbsp;&nbsp;�����ļ�".$filename."�ɹ���ԭ!</td></tr></table>";
}
else
{
?>
       <table width="100%" cellspacing="0" cellpadding="0" border="0" id="table_border">
	   <form action="system_restore.php?action=save" method="post">
	    <tr>
		 <td id="row_style">�����ļ���:</td>
		 <td>&nbsp;&nbsp;<input type="text" name="filename">&nbsp;(�����ļ�λ��/backup/Ŀ¼�µ�.sql�ļ�.)
		</tr>
		<tr>
		 <td id="row_style">&nbsp;</td>
		 <td>&nbsp;<input type="submit" name="submit" value=" ��ԭ�������� "></td>
	    </tr></form>
	   </table>
	  </td>
     </tr>
    </table>
	<?php
	}
	?>
	</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td id="table_style" class="l_b">&nbsp;</td>
    <td>&nbsp;</td>
    <td id="table_style" class="r_b">&nbsp;</td>
  </tr>
</table>
<?php
copyright();
?>
</body>
</html>
