<?php
require(dirname(__FILE__)."/include/config_base.php");
require(dirname(__FILE__)."/include/config_rglobals.php");
require_once(dirname(__FILE__)."/include/checklogin.php");
check_grant('guest_pay.php',GetCookie('rank'));
if($action=='save'){
if($guestid=='' || $guestid==0){
ShowMsg('��ѡ��ͻ�������','-1');
exit();
}
 $loginip=getip();
 $logindate=getdatetimemk(time());
 $username=GetCookie('VioomaUserID');
 $pingyin=GetPinyin($g_name,1);
 $addsql="insert into #@__pay(guestid,money,mem,dtime) values('$guestid','$pay','$mem','$logindate')";
 $message="�ͻ�".$guestid."���Ԥ����".$pay."Ԫ�ɹ�";
 $asql=New Dedesql(false);
 $asql->ExecuteNoneQuery($addsql);
 $asql->ExecuteNoneQuery("update #@__guest set g_pay=g_pay+'$pay' where id='$guestid'");
 $asql->close();
 WriteNote($message,$logindate,$loginip,$username);
 showmsg('�ɹ�����˿ͻ�Ԥ����','guest_pay.php');
 exit();
}elseif($action=='del'){
 $loginip=getip();
 $logindate=getdatetimemk(time());
 $username=GetCookie('VioomaUserID');
 $addsql="delete from #@__pay where id='$id'";
 $message="�ͻ�".$id."Ԥ���¼ɾ���ɹ�";
 $asql=New Dedesql(false);
 $asql->ExecuteNoneQuery($addsql);
 $asql->ExecuteNoneQuery("update #@__guest set g_pay=g_pay-".$m." where id='$gid'");
 $asql->close();
 WriteNote($message,$logindate,$loginip,$username);
 showmsg('�ɹ�ɾ���˿ͻ�Ԥ����¼','guest_pay.php');
 exit();
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="style/main.css" rel="stylesheet" type="text/css" />
<title><?php echo $cfs_softname;?>�ͻ�Ԥ�������</title>
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
     <tr><form action="system_guest.php" method="post">
      <td><strong>&nbsp;�ͻ�Ԥ�������</strong>&nbsp;&nbsp;<a href="guest_pay.php?action=new">���ӿͻ�Ԥ����</a> | <a href="guest_pay.php">�鿴�ͻ�Ԥ����</a> 
	  </td>
	  <td align="right">
	  �ͻ�������<input type="text" value="<?php echo ($helpw=='')?'�������ƻ�����ƴ��':$helpw?>" onclick="this.value='';" name="helpw">&nbsp;<input type="submit" value="����">&nbsp;&nbsp;
	  </td></form>
     </tr>
     <tr>
      <td bgcolor="#FFFFFF" colspan="2">
	  <?php if($action=='new'){ ?><form action="guest_pay.php?action=save" method="post" name="form1">
       <table width="100%" cellspacing="0" cellpadding="0" border="0" id="table_border">
	    <tr>
		 <td id="row_style">&nbsp;�ͻ�����:</td>
		 <td>
		 &nbsp;<?php echo get__list('#@__guest','guestid',$guestid,'id','g_name');?> (��ѡ��ҪԤ�����Ŀͻ�)</td>
	    </tr>
	    <tr>
		 <td id="row_style">&nbsp;Ԥ����:</td>
		 <td>
		 &nbsp;<input type="text" name="pay" size="15"> Ԫ</td>
	    </tr>
		<tr>
		 <td id="row_style">&nbsp;Ԥ��˵��:</td>
		 <td>
		 &nbsp;<textarea rows="2" cols="50" name="mem"></textarea></td>
	    </tr>
		<tr>
		 <td id="row_style">&nbsp;Ԥ������:</td>
		 <td>
		 &nbsp;<?php echo getdatetimemk(time()); ?></td>
	    </tr>	
		<tr>
		 <td id="row_style">&nbsp;</td>
		 <td>&nbsp;<input type="submit" name="submit" value=" ��ӿͻ�Ԥ�� "></td>
	    </tr>
	   </table></form>
	   <?php
	    } 
		else
		{
       echo "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" id=\"table_border\">";
       $csql=New Dedesql(false);
	   $query="select * from #@__pay order by id desc";	   
	   $csql->SetQuery($query);
	   $csql->Execute();
	   $rowcount=$csql->GetTotalRow();
	   if($rowcount==0)
	   echo "<tr><td>&nbsp;û���κοͻ�Ԥ��,����<a href=guest_pay.php?action=new>��ӿͻ�Ԥ��</a>��</td></tr>";
	   else{
	   echo "<tr class='row_color_head'>
	   <td>ID</td>
	   <td>�ͻ�ȫ��</td>
	   <td>Ԥ����</td>
	   <td>Ԥ��˵��</td>
	   <td>ʱ��</td>
	   <td>����</td>
	   </tr>";
	   while($row=$csql->GetArray()){
	   echo "<tr>
	   <td><center>".$row['id']."</td>
	   <td><center>&nbsp;".get__id('#@__guest',$row['guestid'],'g_name','id')."</td>
	   <td><center>��".number_format($row['money'],2,'.',',')."</td>
	   <td><center>&nbsp;".$row['mem']."</td>
	   <td><center>&nbsp;".$row['dtime']."</td>
	   <td><center><a href=guest_pay.php?action=del&id=".$row['id']."&gid=".$row['guestid']."&m=".$row['money'].">ɾ</a></td>
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
