<?php
require(dirname(__FILE__)."/include/config_base.php");
require(dirname(__FILE__)."/include/config_rglobals.php");
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="style/main.css" rel="stylesheet" type="text/css" />
<title><?php echo $cfs_softname;?>���ݱ���</title>
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
      <td><strong>&nbsp;���ݱ���</strong></td>
     </tr>
     <tr>
      <td bgcolor="#FFFFFF">
	  <?php
	  if($action=='save'){
$q1=mysql_query("show tables");     
while($t=mysql_fetch_array($q1)){     
$table=$t[0];     
$q2=mysql_query("show create table `$table`");     
$sql=mysql_fetch_array($q2);     
$mysql.=$sql['Create Table'].";\r\n\r\n";#DDL     
   
$q3=mysql_query("select * from `$table`");     
while($data=mysql_fetch_assoc($q3))     
{
$keys=array_keys($data);     
$keys=array_map('addslashes',$keys);     
$keys=join('`,`',$keys);     
$keys="`".$keys."`";     
$vals=array_values($data);     
$vals=array_map('addslashes',$vals);     
$vals=join("','",$vals);     
$vals="'".$vals."'";     
   
$mysql.="insert into `$table`($keys) values($vals);\r\n";     
}     
$mysql.="\r\n";     
   
}     
$filename="backup/".date('Ymdhms')."_".$cfg_dbname.".sql"; //�ļ���Ϊ���������     
$fp = fopen($filename,'w');     
fputs($fp,$mysql);     
fclose($fp);     
echo "<table id='table_border' width='100%'><tr id='row_style'><td>&nbsp;&nbsp;���ݱ��ݳɹ�,���ɱ����ļ�".$filename."</td></tr></table>";     

}
else
{
?>
       <table width="100%" cellspacing="0" cellpadding="0" border="0" id="table_border">
	   <form action="system_backup.php?action=save" method="post">
		<tr>
		 <td id="row_style">&nbsp;</td>
		 <td>&nbsp;<input type="submit" name="submit" value=" ������������ "></td>
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
