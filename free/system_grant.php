<?php
require(dirname(__FILE__)."/include/config_base.php");
require(dirname(__FILE__)."/include/config_rglobals.php");
require_once(dirname(__FILE__)."/include/checklogin.php");
if($action=='save'){
 $sql=new dedesql(false);
 $query="select * from #@__menu where reid!=0";
 $sql->setquery($query);
 $sql->execute();
 while($row=$sql->getarray()){
 $array=$_POST['r'.$row['id']];
 $size=count($array);
 $grantstring="admin_AllowAll|";
 for($i=0;$i<$size;$i++){
 $grantstring=$grantstring.$array[$i]."|";
 //echo $grantstring."<br>";
 $sql->executenonequery("update #@__menu set rank='$grantstring' where id='".$row['id']."'");
 }
 }
 $sql->close();
 showmsg('ϵͳȨ�޷��������ѱ���.','system_grant.php');
}
else{
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="style/main.css" rel="stylesheet" type="text/css" />
<title><?php echo $cfg_softname;?>����Ա����</title>
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
      <td><strong>&nbsp;����ԱȨ�޹���</strong>&nbsp;&nbsp;<a href="system_boss.php?action=new">����µĲ���Ա</a> | <a href="system_boss.php">�鿴����Ա�б�</a>&nbsp;|&nbsp;<a href="system_grant.php">Ȩ�޷���</a></td>
     </tr>
     <tr>
      <td bgcolor="#FFFFFF">
       <table width="100%" cellspacing="0" border="0" id="table_border">
	   <tr>
	    <td>
		<center>ϵͳ����
		</td>
		<td>
		<center>�ɲ����û���
		</td>
	   </tr>
	   <form action="system_grant.php?action=save" method="post">
	   <?php
	   $sql=new dedesql(false);
	   $query="select * from #@__menu where reid!=0";
	   $sql->setquery($query);
	   $sql->execute();
	   while($row=$sql->getarray()){
	   echo "<tr>
	     <td id='row_style' style='text-align:left'>&nbsp;&nbsp;".$row['name']." <font color='#999999'>(�ļ�:".$row['url'].")</font></td>
		 <td>";
		 $s=new dedesql(false);
		 $q1="select * from #@__usertype where rank>1";
		 $s->setquery($q1);
		 $s->execute();
		 while ($r1=$s->getarray()){
		 $tmparray = explode($r1['content'],$row['rank']);
		 if(count($tmparray)>1)
		 echo "<input type='checkbox' name='r".$row['id']."[]' value='".$r1['content']."' checked>".$r1['typename']."\r\n";
		 else
		 echo "<input type='checkbox' name='r".$row['id']."[]' value='".$r1['content']."'>".$r1['typename']."\r\n";
		 }
		 $s->close();
		 echo "</td>
	   </tr>";
	   }
	   $sql->close();
	   ?>
	   <tr><td>&nbsp;</td><td><input type="submit" value="����"></tr>
	   </form>
	   </table>
	   <?php
	   }
	   ?>
	  </td>
     </tr>
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
<?php
copyright();
?>
</body>
</html>
