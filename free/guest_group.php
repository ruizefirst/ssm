<?php
require(dirname(__FILE__)."/include/config_base.php");
require(dirname(__FILE__)."/include/config_rglobals.php");
require_once(dirname(__FILE__)."/include/checklogin.php");
if($action=='save'){
 if($groupname=='') {
 showmsg('������ͻ���������','-1');
 exit();
 }
 if(!is_numeric($sub) || $sub=='' || $sub>10 || $sub<1){
  showmsg('�ۿ�ֻ����1��10֮�����,����С��','-1');
 exit();
 }
 $addsql="insert into #@__group(groupname,sub,groupmem,staffid) values('$groupname','$sub','$groupmem','$staff')";
 $message="��ӿͻ�����".$groupname."�ɹ�";
  
 $loginip=getip();
 $logindate=getdatetimemk(time());
 $username=Getcookie('VioomaUserID');
 $asql=New Dedesql(false);
 $asql->ExecuteNoneQuery($addsql);
 $asql->close();
 WriteNote($message,$logindate,$loginip,$username);
 showmsg('�ɹ�����˿ͻ�����','guest_group.php');
 exit();
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="style/main.css" rel="stylesheet" type="text/css" />
<title><?php echo $cfg_softname;?>�ͻ��������</title>
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
      <td><strong>&nbsp;�ͻ��������</strong>&nbsp;&nbsp;<a href="guest_group.php?action=new">��ӿͻ�����</a> | <a href="guest_group.php">�鿴�ͻ�����</a></td>
     </tr><form action="guest_group.php?action=save" method="post">
     <tr>
      <td bgcolor="#FFFFFF">
	  <?php if($action=='new'){ ?>
       <table width="100%" cellspacing="0" cellpadding="0" border="0" id="table_border">
	    <tr>
		 <td id="row_style" width="25%">&nbsp;�ͻ���������:<br>(�ɰ�����λ�á��ͻ����ʵȽ��з���)</td>
		 <td>
		 &nbsp;<input type="text" name="groupname" size="20"></td>
	    </tr>
		<tr>
		 <td id="row_style">&nbsp;�˷���������ۿ�:</td>
		 <td>
		 &nbsp;<input type="text" name="sub" size="2" value="10"> ��</td>
	    </tr>
		<tr>
		 <td id="row_style">
		 &nbsp;�ͻ�����˵����
		 </td>
		 <td>&nbsp;<textarea cols="40" rows="3" name="groupmem"></textarea>
		</tr>
		<tr>
		 <td id="row_style">
		 &nbsp;�˷��鸺���ˣ�
		 </td>
		 <td>
		 &nbsp;<?php echo getstaff()?>
		 </td>
		</tr>
		<tr>
		 <td id="row_style">&nbsp;</td>
		 <td>&nbsp;<input type="submit" name="submit" value=" ��ӿͻ����� "></td>
	    </tr>
	   </table></form>
	   <?php
	    } 
		else
		{
       echo "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" id=\"table_border\">";
       $csql=New Dedesql(false);
	   if(GetCookie('rank')==1)
	   $query="select * from #@__group";	   
	   else{
	   $sql1=New Dedesql(false);
	   $query1="select id from #@__staff where s_name='".GetCookie("VioomaUserID")."'";
	   $rowi=$sql1->getone($query1);
	   $sid=$rowi['id']; 
	   $query="select * from #@__group where staffid='$sid'";
	   }
	   $csql->SetQuery($query);
	   $csql->Execute();
	   $rowcount=$csql->GetTotalRow();
	   if($rowcount==0)
	   echo "<tr><td>&nbsp;ϵͳ�ﻹû���κοͻ�����,����<a href=guest_group.php?action=new>��ӷ���</a>��</td></tr>";
	   else{
	   echo "<tr class='row_color_head'>
	   <td>ID</td>
	   <td>��������</td>
	   <td>�ۿ�</td>
	   <td>����Ա��</td>
	   <td>����</td>
	   </tr>";
	   while($row=$csql->GetArray()){
	   echo "<tr>
	   <td><center>ID��:".$row['id']."</td>
	   <td><center><img src=images/cate.gif align=absmiddle>&nbsp;".$row['groupname']."</td>
	   <td><center>".$row['sub']." ��</td>
	   <td><center>".getstaff($row['staffid'],'SHOW')."</td>
	   <td><center><a href=group_edit.php?id=".$row['id'].">�޸�</a> | <a href=group_del.php?id=".$row['id'].">ɾ��</a></td>
	   </tr>";
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
