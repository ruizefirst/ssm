<?php
require(dirname(__FILE__)."/include/config_base.php");
require(dirname(__FILE__)."/include/config_rglobals.php");
require_once(dirname(__FILE__)."/include/checklogin.php");
if($action=='save'){
if($s_name==''){
ShowMsg('������Ա��������','-1');
exit();
}
 $addsql="insert into #@__staff(s_name,s_address,s_phone,s_part,s_way,s_money,s_utype,s_duty) values('$s_name','$s_address','$s_phone','$s_part','$s_way','$s_money','$s_utype','$s_utype')";
 $message="���Ա��".$s_name."�ɹ�";
$password1=md5($password);
 $addsql2="insert into #@__boss(boss,password,logindate,loginip,errnumber,rank,`key`,key1,code) values('$s_name','$password1','0000-00-00 00:00:00','','0','$s_utype','0','0','0')";
 $loginip=getip();
 $logindate=getdatetimemk(time());
 $username=GetCookie('VioomaUserID');
 $asql=New Dedesql(false);
 $rs=$asql->ExecuteNoneQuery($addsql);
 if(!$rs){
  showmsg('��������:'.$asql->getError(),'-1');
  exit();
 }
 $rs1=$asql->ExecuteNoneQuery($addsql2);
 if(!$rs1){
  showmsg('��������:'.$asql->getError(),'-1');
  exit();
 }
 WriteNote($message,$logindate,$loginip,$username);
 showmsg('�ɹ�����˹�˾Ա��','system_worker.php');
 exit();
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="style/main.css" rel="stylesheet" type="text/css" />
<title><?php echo $cfs_softname;?>Ա������</title>
<script language="javascript">
function cway(value){
if(value==0)
document.forms[0].s_e.value="%";
else
document.forms[0].s_e.value="Ԫ/��";
}
function getinfo(){
window.open('part_list.php?form=form1&field=s_part','selected','directorys=no,toolbar=no,status=no,menubar=no,resizable=no,width=500,height=500,top=100,left=320');
}
</script>
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
      <td><strong>&nbsp;��˾Ա������</strong>&nbsp;&nbsp;<a href="system_worker.php?action=new">��ӹ�˾Ա��</a> | <a href="system_worker.php">�鿴��˾Ա��</a></td>
     </tr>
	 <form action="system_worker.php?action=save" method="post" name="form1">
     <tr>
      <td bgcolor="#FFFFFF">
	  <?php if($action=='new'){ ?>
       <table width="100%" cellspacing="0" cellpadding="0" border="0" id="table_border">
	    <tr>
		 <td id="row_style">&nbsp;Ա������/��½��:</td>
		 <td>
		 &nbsp;<input type="text" name="s_name" size="10" id="need"></td>
	    </tr>
		<tr>
		 <td id="row_style">&nbsp;��½���룺</td>
		 <td>&nbsp;<input type="password" name="password" size="12"></td>
		</tr>
	    <tr>
		 <td id="row_style">&nbsp;��ϵ��ַ:</td>
		 <td>
		 &nbsp;<input type="text" name="s_address" size="30"></td>
	    </tr>
		<tr>
		 <td id="row_style">&nbsp;��ϵ�绰:</td>
		 <td>
		 &nbsp;<input type="text" name="s_phone" size="15"></td>
	    </tr>	
		<tr>
		 <td id="row_style">&nbsp;���ڲ���:</td>
		 <td>
		 &nbsp;<input type="text" name="s_part" size="20">&nbsp;<input type="button" value="ѡ����" onclick="getinfo()"></td>
	    </tr>
		<tr>
		 <td id="row_style">&nbsp;ְ��/����Ա����:</td>
		 <td>
		 &nbsp;<?php getusertype('',0);?></td>
	    </tr>	
		<tr>
		 <td id="row_style">&nbsp;��ɷ�ʽ:</td>
		 <td>
		 <?php
		 if ($cfg_way=='1'){
		 ?>
		 &nbsp;<select name="s_way" onchange="cway(this.value)"><option value="0">�����ܶ�İٷֱ�</option><option value="1">�̶����(����)</select>
		 <?php
		 }
		 else
		 echo "&nbsp;Ա����ɹ��ܱ�����Ա����!";
		 ?>
		 </td>
	    </tr>		
		<tr>
		 <td id="row_style">&nbsp;��ɶ�(Ϊ�ձ�ʾ��ӵĴ�Ա�������):</td>
		 <td>
		 <?php
		 if ($cfg_way=='1'){
		 ?>
		 &nbsp;<input type="text" name="s_money" size="5" value="0">
		 <input type="text" name="s_e" size="5" style="border:0px;background:transparent;" value="%" readonly>
		 <?php
		 }
		 else
		 echo "&nbsp;";
		 ?>
		 </td>
	    </tr>	
		<tr>
		 <td id="row_style">&nbsp;</td>
		 <td>&nbsp;<input type="submit" name="submit" value=" ���Ա�� "></td>
	    </tr>
		</form>
	   </table>
	   <?php
	    } 
		else
		{
       echo "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" id=\"table_border\">";
       $csql=New Dedesql(false);
	   $csql->SetQuery("select * from #@__staff");
	   $csql->Execute();
	   $rowcount=$csql->GetTotalRow();
	   if($rowcount==0)
	   echo "<tr><td>&nbsp;��˾�ﻹû���κ�Ա��,����<a href=system_worker.php?action=new>���Ա��</a>��</td></tr>";
	   else{
	   echo "<tr class='row_color_head'>
	   <td>ID</td>
	   <td>����</td>
	   <td>��ϵ��ַ</td>
	   <td>��ϵ�绰</td>
	   <td>����</td>
	   <td>ְ��</td>
	   <td>����</td>
	   </tr>";
	   while($row=$csql->GetArray()){
	   echo "<tr>
	   <td><center>ID��:".$row['id']."</td>
	   <td><center>&nbsp;".$row['s_name']."</td>
	   <td><center>&nbsp;".$row['s_address']."</td>
	   <td><center>&nbsp;".$row['s_phone']."</td>
	   <td><center>&nbsp;".$row['s_part']."</td>
	   <td><center>&nbsp;".getusertype($row['s_duty'],0)."</td>
	   <td><center><a href=system_worker_edit.php?id=".$row['id'].">�޸�</a> | <a href=system_worker_del.php?id=".$row['id'].">ɾ��</a></td>
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
