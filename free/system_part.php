<?php
require(dirname(__FILE__)."/include/config_base.php");
require(dirname(__FILE__)."/include/config_rglobals.php");
require_once(dirname(__FILE__)."/include/checklogin.php");
if($action=='save'){
if($p_name==''){
ShowMsg('�����빫˾���ŵ�����','-1');
exit();
}
 $addsql="insert into #@__part(p_name,p_text) values('$p_name','$p_text')";
 $message="��ӹ�˾����".$p_name."�ɹ�";

 $loginip=getip();
 $logindate=getdatetimemk(time());
 $username=GetCookie('VioomaUserID');
 $asql=New Dedesql(false);
 $asql->ExecuteNoneQuery($addsql);
 $asql->close();
 WriteNote($message,$logindate,$loginip,$username);
 showmsg('�ɹ�����˹�˾����','system_part.php');
 exit();
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="style/main.css" rel="stylesheet" type="text/css" />
<title><?php echo $cfg_softname;?>���Ź���</title>
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
      <td><strong>&nbsp;���Ź���</strong>&nbsp;&nbsp;<a href="system_part.php?action=new">����µĲ���</a> | <a href="system_part.php">�鿴�����б�</a></td>
     </tr>
	 <form action="system_part.php?action=save" method="post">
     <tr>
      <td bgcolor="#FFFFFF">
	  <?php if($action=='new'){ ?>
       <table width="100%" cellspacing="0" cellpadding="0" border="0" id="table_border">
	    <tr>
		 <td id="row_style">&nbsp;��������:</td>
		 <td>
		 &nbsp;<input type="text" name="p_name" size="30" id="need"></td>
	    </tr>
	    <tr>
		 <td id="row_style">&nbsp;��ע:</td>
		 <td>
		 &nbsp;<textarea name="p_text" rows="3" cols="30"></textarea></td>
	    </tr>
		<tr>
		 <td id="row_style">&nbsp;</td>
		 <td>&nbsp;<input type="submit" name="submit" value=" ��Ӳ��� "></td>
	    </tr>
		</form>
	   </table>
	   <?php
	    } 
		else
		{
       echo "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" id=\"table_border\">";
       $csql=New Dedesql(false);
	   $csql->SetQuery("select * from #@__part");
	   $csql->Execute();
	   $rowcount=$csql->GetTotalRow();
	   if($rowcount==0)
	   echo "<tr><td>&nbsp;ϵͳ�ﻹû���κβ���,����<a href=system_part.php?action=new>��Ӳ���</a>��</td></tr>";
	   else{
	   echo "<tr class='row_color_head'><td>ID</td><td>��������</td><td>��ע</td><td>����</td></tr>";
	   while($row=$csql->GetArray()){
	   echo "<tr><td>ID��:".$row['id']."</td><td>&nbsp;".$row['p_name']."</td><td>&nbsp;".$row['p_text']."</td><td><a href=system_part_edit.php?id=".$row['id'].">�޸�</a> | <a href=system_part_del.php?id=".$row['id'].">ɾ��</a></td></tr>";
	   }
	   }
	   echo "</table>";
	  
	   $csql->close();
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
