<?php
require(dirname(__FILE__)."/include/config_base.php");
require(dirname(__FILE__)."/include/config_rglobals.php");
require(dirname(__FILE__)."/include/page.php");
require_once(dirname(__FILE__)."/include/checklogin.php");
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="style/main.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="include/calendar.js"></script>
<title><?php echo $cfg_softname;?>�����ʿ����</title>
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
      <td>
	   <table width="100%" border="0" cellspacing="0">
	   <form action="system_ps.php?action=seek" name="form1" method="post">
	    <tr>
		 <td>
	     <strong>&nbsp;�����ʿ�</strong>
	     </td>
		 <td align="right">
		 ���ͻ�:<select name="member"><option value="" selected>��ʾ���пͻ�</option>
		 <?php
		 if($action=='sure'){//ȷ���տ��
		 $sql=new dedesql(false);
		 $row=$sql->getone("select * from #@__bank where bank_default='1'");
		 $loginip=getip();
          $logindate=getdatetimemk(time());
          $username=GetCookie('VioomaUserID');
		 $query="update #@__reportsale set finish='0' where r_dh='$dh'";
		 $query1="insert into #@__accounts(atype,amoney,abank,dtime,apeople,atext) values('֧��','$money','".$row['id']."','$logindate','$username','ȡ�������˿���ţ�$dh')";
		 $sql->executenonequery($query);
		 $sql->executenonequery($query1);
          WriteNote('�ɹ�ȡ���տ��:'.$dh.'�Ŀ���.',$logindate,$loginip,$username);
		  $sql->close();
		  showMsg('ȡ���տ�����ɹ�!','system_ps.php');
		 }
		 $sql1=new dedesql(false);
		 $q1="SELECT id,g_name FROM #@__guest ORDER BY id DESC";
		 $sql1->setquery($q1);
		 $sql1->execute();
		 while($r=$sql1->getArray()){
		 if($action=='seek')
		 if($r['g_name']==$member)
		 echo "<option value='".$r['g_name']."' selected>".$r['g_name']."</option>";
		 else
		 echo "<option value='".$r['g_name']."'>".$r['g_name']."</option>";
		 else
		 echo "<option value='".$r['g_name']."'>".$r['g_name']."</option>";
		 }
		 $sql1->close();
		 ?>
		   </select>
		 ���ڶΣ�
		 <?php 
		 if($action=='seek'){
		 echo "<input type=\"text\" name=\"cp_sdate\" size=\"15\" VALUE=\"".$cp_sdate."\" onclick=\"setday(this)\"> �� 
		 <input type=\"text\" name=\"cp_edate\" size=\"15\" VALUE=\"".$cp_edate."\" onclick=\"setday(this)\">";
		 $hurl="system_money.php?action=seek&cp_sdate='$cp_sdate'&cp_edate='$cp_edate'&atype=";}
		 else{
		 echo "<input type=\"text\" name=\"cp_sdate\" size=\"15\" VALUE=\"����ѡ������\" onclick=\"setday(this)\"> �� 
		 <input type=\"text\" name=\"cp_edate\" size=\"15\" VALUE=\"����ѡ������\" onclick=\"setday(this)\">";
		 $hurl="system_money.php?atype=";}
		 ?>
		 <input type="submit" value="�鿴����">
		 &nbsp;&nbsp;
		 </td>
		</tr></form>
	   </table>
	  </td>
     </tr>
	 <form method="post" name="sel">
     <tr>
      <td bgcolor="#FFFFFF">
       <?php
	   $asql=New dedesql(false);
	   $aquery="select * from #@__reportsale where finish='1'";
	   $asql->setquery($aquery);
	   $asql->execute();
	   $inumber=$asql->gettotalrow();
	   while($r1=$asql->getArray()){
	   $asql1=new dedesql(false);
	   $asql1->setquery("select * from #@__sale where rdh='".$r1['r_dh']."'");
	   $asql1->execute();
	   while($r2=$asql1->getArray()){
	   $imoney+=$r2['sale']*$r2['number'];
	   }
	   $asql1->close();
	   }
	   $asql->close();
	   $moneystring="<b>�����ʿ".$inumber." ����ƽ���".number_format($imoney,2,'.',',')."Ԫ</b>";
       echo "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" id=\"table_border\">";
	   if($action=='seek'){
	   if($cp_sdate=='' || $cp_edate=='' || $cp_sdate=='����ѡ������' || $cp_edate=='����ѡ������' || $cp_sdate>$cp_edate)echo "<script>alert('��ѡ����ȷ��ʱ���');history.go(-1);</script>";
	   if($member=='')
	   $query="select * from #@__reportsale where r_date between '$cp_sdate' and '$cp_edate' and finish='1' order by r_date desc";
	   else
	   $query="SELECT * 
FROM #@__reportsale
WHERE r_date
BETWEEN '$cp_sdate'
AND '$cp_edate'
AND finish = '1'
AND r_dh
IN (
SELECT rdh
FROM #@__sale
WHERE member = '$member'
)";
	   }
	   else
	   $query="select * from #@__reportsale where finish='1' order by r_date desc";
$csql=New Dedesql(false);
$dlist = new DataList();
$dlist->pageSize = $cfg_record;
//����GET������
if($action=='seek'){
$dlist->SetParameter("action",$action);
$dlist->SetParameter("member",$member);
$dlist->SetParameter("cp_sdate",$cp_sdate);
$dlist->SetParameter("cp_edate",$cp_edate);
}
$dlist->SetSource($query);
       echo "<tr><td colspan='8' align='right'>".$moneystring."&nbsp;&nbsp;</td></tr>";
	   echo "<tr class='row_color_head'>
	   <td>���</td>
	   <td>ҵ��Ա</td>
	   <td>����</td>
	   <td>����Ա</td>
	   <td>����</td>
	   <td>���</td>
	   <td>���</td>
	   <td>����</td>
	   </tr>";
	   $mylist = $dlist->GetDataList();
       while($row = $mylist->GetArray('dm')){
	   if($row['r_status']=='1') $statustring="<font color=red>����</font>";
	   else $statustring="δ��";
	   if($member=='')
	   $cmoney=Out_money('sale',$row['r_dh']);
	   else
	   $cmoney=Out_money('sale',$row['r_dh'],$member);
	   $amoney+=$cmoney;
	   echo "<tr onMouseMove=\"javascript:this.bgColor='#EBF1F6';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\">\r\n
	   <td><center>".$row['id']."</td>
	   <td><center>&nbsp;".$row['r_adid']."</td>
	   <td><center>".$row['r_dh']."</td>
	   <td><center>".$row['r_people']."</td>
	   <td><center>".$row['r_date']."</td>
	   <td><center>��".$cmoney."</td>
	   <td><center>".$statustring."</td>
	   <td><center><a href='system_ps.php?action=sure&dh=".$row['r_dh']."&money=$cmoney' title='ȷ��ȡ���˿�����'>ȡ���տ�</a></td>\r\n
	   </tr>";
	   }
	   echo "<tr><td colspan=\"8\">&nbsp;&nbsp;�ܼƣ�&nbsp;��".$amoney."Ԫ</td></tr>";
	   echo "<tr><td colspan='8'>&nbsp;".$dlist->GetPageList($cfg_record)."</td></tr>";
	   echo "</table>";
	   $csql->close();
	   ?>
	  </td>
     </tr></form>
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
