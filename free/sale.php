<?php
require(dirname(__FILE__)."/include/config_rglobals.php");
require(dirname(__FILE__)."/include/config_base.php");
require(dirname(__FILE__)."/include/page.php");
require_once(dirname(__FILE__)."/include/checklogin.php");
check_grant('sale.php',GetCookie('rank'));
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="style/main.css" rel="stylesheet" type="text/css" />
<title>���۹���</title>
<style type="text/css">
.rtext {background:transparent;border:0px;color:red;font-weight:bold;font-family:Verdana, Arial, Helvetica, sans-serif;}
</style>
<script language="javascript">
function isInteger(sNum) { 
var num 
num=new RegExp('[^0-9_]','') 
if (isNaN(sNum)) { 
return false 
} 
else { 
if (sNum.search(num)>=0) { 
return false 
} 
else { 
return true 
} 
} 
} 

function getinfo(){
window.open('system_basic_list.php?form=form1&field=seek_text','selected','directorys=no,toolbar=no,status=no,menubar=no,resizable=no,width=750,height=500,top=100,left=120,scrollbars=yes');
}
function getinfo1(){
window.open('member_list.php?form=form1&field=member','selected','directorys=no,toolbar=no,status=no,menubar=no,resizable=no,width=600,height=500,top=100,left=320,scrollbars=yes');
}

function putrkinfo(){
pid=document.forms[0].seek_number.value;//����
did=document.forms[0].r_dh.value;//����
member=document.forms[0].member.value;//��Ա
number=document.forms[0].rk_number.value;//�˻�����
salen=document.forms[0].sale.value;//���ۼ�
lid=document.forms[0].labid.value;//�ֿ��
if(pid==''){
alert('��ѡ��Ҫ���۵Ĳ�Ʒ!');
return false;
}
if(number=='' || (!isInteger(number)) || number<=0){
alert('��ȷ����������ȷ����������');
return false;
}
if(salen=='' || salen<=0){
alert('��ȷ����������ȷ�����ۼ۸�');
return false;
}
url="current_order_sale.php?pid="+pid+"&did="+did+"&num="+number+"&sale="+salen+"&labid="+lid+"&member="+member;
var obj=window.frames["current_order"];
 obj.window.location=url;
}

function showsubinfo(tbnum){
whichEl = eval("rk_subinfo" + tbnum);
if (whichEl.style.display == "none"){eval("rk_subinfo" + tbnum + ".style.display=\"\";");}
else{eval("rk_subinfo" + tbnum + ".style.display=\"none\";");}
}
function setsale(number){
document.forms[0].sale.value=number;
}
</script>
</head>
<?php
//��ⵥ������
$rs=New Dedesql(falsh);
$query="select * from #@__reportsale";
$rs->SetQuery($query);
$rs->Execute();
$rowcount=$rs->GetTotalRow();
$cdh="Vs".str_replace('-','',GetDateMk(date(time())))."-".($rowcount+1);
 $rs->close();
 
if ($action=='save'){//�����˻�������¼

$bsql=New Dedesql(false);
$query="select * from #@__sale where rdh='$r_dh'";//�����˵���Ʒ
$bsql->SetQuery($query);
$bsql->Execute();
$rowcount=$bsql->GetTotalRow();
if ($rowcount==0){
 ShowMsg('�Ƿ�������û��Ҫ���۵Ĳ�Ʒ!','-1');
 exit();
}
else{
 checkbank();
 $money=0;
 while($row=$bsql->getArray()){
 $money+=$row['number']*$row['sale'];
 $csql=New dedesql(false);
 $csql->setquery("select * from #@__mainkc where p_id='".$row['productid']."'");
 $csql->execute();
 $totalrec=$csql->gettotalrow();
 if($totalrec!=0){
  $csql->executenonequery("update #@__mainkc set number=number-".$row['number']." where p_id='".$row['productid']."' and l_id='".$row['salelab']."'");
  }
 }
 //Ԥ�����
 if($payed!='' && $payed>0){
 $guestid=get__id('#@__guest',$member,'id','g_name');
 if($guestid>0){
 if($money>=$payed)
 $csql->ExecuteNonequery("update #@__guest set g_pay=0 where id='$guestid'");
 else
 $csql->ExecuteNonequery("update #@__guest set g_pay=g_pay-".$money." where id='$guestid'");
 }
 }
 $csql->close(); 
 $loginip=getip();
 $logindate=getdatetimemk(time());
 $username=GetCookie('VioomaUserID');
 WriteNote('���۵�'.$r_dh.'�ɹ�����',$logindate,$loginip,$username);
 $newsql=New dedesql(false);
 $newsql->executenonequery("insert into #@__reportsale(r_dh,r_people,r_date,r_status,r_adid) values('".$r_dh."','".$r_people."','".$r_date."','0','".$staff."')");
 //д������¼
 $newsql->executenonequery("insert into #@__accounts(atype,amoney,abank,dtime,apeople,atext) values('����','".$money."','".BANKID."','".$r_date."','".$r_people."','���۲�Ʒ�����ֽ𣬶�Ӧ���۵���Ϊ��".$r_dh."')");
  //�������н��
 $newsql->executenonequery("update #@__bank set bank_money=bank_money+".$money." where id='".BANKID."'");
 $newsql->close();
 ShowMsg('��Ʒ������,ϵͳ�Զ���ת�����۵���ӡ����.','report_sale.php?action=save&type=other&sday='.$r_dh);
$bsql->close();
exit();
    }
}
else if($action=='seek'){ //�б�
?>
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
      <td><strong>&nbsp;���۵�����</strong>&nbsp;&nbsp;- <a href="sale.php">�µ�</a> <a href="importsale1.php">������������</a> | <a href="importsale2.php">��������ϸ��</a></td>
     </tr>
     <tr>
      <td bgcolor="#FFFFFF">
<?php
$orderstring=" order by r_date desc";
       echo "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" id=\"table_border\">";
	   if(GetCookie('rank')==1)
	   $query="select * from #@__reportsale".$orderstring;
	   else
	   $query="select * from #@__reportsale where r_people='".GetCookie('VioomaUserID')."'".$orderstring;
       $csql=New Dedesql(false);
	   $dlist = new DataList();
       $dlist->pageSize = $cfg_record;
       $dlist->SetParameter("action",$action);//����GET������
       $dlist->SetSource($query);
	   echo "<tr class='row_color_head'>
	   <td>ID</td>
	   <td>���۵���</td>
	   <td>������Ա</td>
	   <td>����ʱ��</td>
	   <td>���״̬</td>
	   <td>��ز���</td>
	   </tr>";
	   $mylist = $dlist->GetDataList();
       while($row = $mylist->GetArray('dm')){
	   if($row['r_status']==1){
	   if(Getcookie('rank')=='1')
	   $statusstring="<a href='?action=sure&t=no&id=".$row['id']."'><img src='images/yes.png' alt='ȡ���õ����' border='0'></a>";
	    else
	   $statusstring="<img src='images/yes.png' alt='ȡ���õ����' border='0'>";
	   $printstring=" | <a href=report_sale.php?action=save&type=other&sday=".$row['r_dh'].">��ӡ���۵�</a>";
	   }
	   else{
	   if(Getcookie('rank')=='1')
	   $statusstring="<a href='?action=sure&t=yes&id=".$row['id']."'><img src='images/no.png' alt='��˸õ�' border='0'></a>";
	    else
	   $statusstring="<img src='images/no.png' alt='��˸õ�' border='0'>";
	   $printstring="";
	   }
	   echo "<tr>
	   <td><center>ID��:".$row['id']."</td>
	   <td><center>&nbsp;".$row['r_dh']."</td>
	   <td><center>&nbsp;".$row['r_people']."</td>
	   <td><center>&nbsp;".$row['r_date']."</td>
	   <td><center>&nbsp;".$statusstring."</td>
	   <td><center><span onclick=showsubinfo(".$row['id'].") style='cursor:hand;'>չ������</span> ".$printstring."</td>
	   </tr>";
	   echo "<tr id='rk_subinfo".$row['id']."' style='display:none;'>
	   <td colspan='6'><br>
	   <table width=\"98%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" id=\"table_border\" align=\"center\">";
	   
	   $csql1=New Dedesql(false);
	   $csql1->SetQuery("select * from #@__sale where rdh='".$row['r_dh']."'");
	   $csql1->Execute();
	   $rowcount=$csql1->GetTotalRow();
	   echo "<tr class='row1_color_head'>
	   <td><center>����</td>
	   <td><center>����</td>
	   <td><center>���</td>
	   <td><center>����</td>
	   <td><center>��λ</td>
	   <td><center>�ۼ�</td>
	   <td><center>�ͻ�</td>
	   <td><center>��������</td>
	   <td><center>���</td>
	   </tr>";
	   while($row=$csql1->GetArray()){
	   $nsql=New dedesql(false);
	   $query1="select * from #@__basic where cp_number='".$row['productid']."'";
	   $nsql->setquery($query1);
	   $nsql->execute();
	   $row1=$nsql->getone();
	   echo "<tr onMouseMove=\"javascript:this.bgColor='#EBF1F6';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\">
	   <td><center>".$row['productid']."</td>
	   <td><center>&nbsp;".$row1['cp_name']."</td>
	   <td><center>".$row1['cp_gg']."</td>
	   <td><center>".get_name($row1['cp_categories'],'categories').">".get_name($row1['cp_categories_down'],'categories')."</td>
	   <td><center>".get_name($row1['cp_dwname'],'dw')."</td>
	   <td><center>��".$row['sale']."</td>
	   <td><center>".$row['member']."</td>
	   <td><center>".$row['number']."</td>
	   <td><center>��".number_format($row['number']*$row['sale'],2,'.',',')."</td>
	   </tr>";
	   $nsql->close();
	   }
	   $csql1->close();
	   echo "</table><br></td></tr>\r\n";
	   }
	   $csql->close();
   echo "<tr><td colspan='6'>&nbsp;".$dlist->GetPageList($cfg_record)."</td></tr></table>\r\n </td></tr></table>
 </td></tr>  <tr>
    <td id=\"table_style\" class=\"l_b\">&nbsp;</td>
    <td>&nbsp;</td>
    <td id=\"table_style\" class=\"r_b\">&nbsp;</td>
  </tr>
</table>";
 }
 else if($action=='sure'){
 $susql=new dedesql(false);
 if($t=='yes')
 $query="update #@__reportsale set r_status=1 where id='$id'";
 else
 $query="update #@__reportsale set r_status=0 where id='$id'";
 $susql->executenonequery($query);
 $susql->close();
 showmsg('�������״̬���޸�','sale.php?action=seek');
 }
 else{
?>
<script language="javascript">
function check(e){
var e = window.event ? window.event : e;
    if(e.keyCode == 13){
        thistm=document.forms[0].tm.value;
    //window.parent.main.location.href='sale.php?thistm='+thistm;
        window.location.href='sale.php?thistm='+thistm;
    //document.forms[0].rk_number.focus();
	return false;
    }
}
function checkForm(){
document.forms[0].submit();
}
</script>
<body onload="form1.tm.focus()">
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
      <td><strong><strong>&nbsp;���۹���</strong>&nbsp;&nbsp;- <a href="sale.php">�µ�</a> - <a href="sale.php?action=seek">���۵���ѯ</a></td>
     </tr>
     <tr>
      <td bgcolor="#FFFFFF">
       <table width="100%" border="0" cellspacing="0" cellpadding="0" id="table_border">
	   <form action="sale.php?action=save" method="post" name="form1">
    <tr height="30">
    <td class="cellcolor">���۵���:</td>
    <td class="cellcolor">&nbsp;<input type="text" name="r_dh" value="<?php echo $cdh; ?>" readonly class="rtext" size="15">&nbsp;(������Ա:<input type="text" name="r_people" value="<?php echo GetCookie('VioomaUserID'); ?>" readonly class="rtext" size="8">����ʱ��:<input type="text" name="r_date" value="<?php echo GetDateTimeMk(time());?>"  readonly class="rtext">)</td>
  </tr>
  <tr>
    <td class="cellcolor" width="30%">��Ʒ������Ϣ:<br></td>
    <td>&nbsp;<input type="text" name="tm" value="" onkeydown="check(event);" ondblclick="getinfo()">&nbsp;<img src="images/03.gif" border="0" style="cursor:hand;" alt="������������Ʒ��Ϣ" onclick="getinfo()"> 
	<input type="text" name="seek_text" value="" readonly class="rtext" size="15">(֧��ɨ��ǹ)
	<input type="hidden" name="seek_number" value=""/>
	</td>
  </tr> 
  <tr>
    <td class="cellcolor" width="30%">����:<br></td>
    <td>
	&nbsp;<input type="text" name="rk_number" size="5"><input type="text" class="rtext" name="showdw" readonly size="15">
	&nbsp;<!--�����ֿ�--><input type="hidden" name="labid" value="">
	</td>
  </tr> 
  <tr>
    <td class="cellcolor" width="30%">ҵ��Ա:<br></td>
    <td>&nbsp;<?php getadid('');?>
	</td>
  </tr>
  <tr>
   <td class="cellcolor" width="30%">���ۼ۸�</td>
   <td>&nbsp;<input type="text" name="sale" id="need">&nbsp;(��ѡ��������ۼ�)
   <div style="height:27px;float:left;" id="sale_string"></div>
   </td>
  </tr>
  <tr>
    <td class="cellcolor" width="30%">�ͻ�:<br></td>
    <td>&nbsp;<input type="text" name="member">&nbsp;<input type="button" value="ѡ��ͻ�" onclick="getinfo1()">
	&nbsp;Ԥ����:<input type="text" name="payed" value="" size="6" class="rtext" readonly> Ԫ
	</td>
  </tr>      
  <tr id="product_date" style="display:block;">
   <td colspan="2">
   &nbsp;��������Ʒ������Ϣ:<input type="text" class="rtext" style="width:80%;" name="showinfo" readonly>
   </td>
  </tr> 
  <tr>
    <td class="cellcolor">&nbsp;</td>
    <td>&nbsp;<input type="button" value=" �Ǽǵ��˵� " onclick="putrkinfo()">&nbsp;&nbsp;<input type="button" value="��������ۼ�¼" onclick="checkForm()"></td>
  </tr>
  <tr>
   <td colspan="2">
   <iframe src="current_order_sale.php?pid=&did=<?php echo $cdh ?>&action=normal" width="100%" height="400" scrolling="auto" frameborder="0" marginheight="0" marginwidth="0" name="current_order" od="current_order"></iframe>
   </td>
  </tr></form>
</table>
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
if($thistm!=''){//ɨ��ǹ����
	echo $thistm;
	$checksql=new Dedesql(false);
	$checkquery="select * from #@__basic,#@__mainkc where #@__basic.cp_tm='$thistm' and #@__mainkc.p_id=#@__basic.cp_number";
	$checksql->setquery($checkquery);
	$checksql->execute();
	$recordnumbers=$checksql->getTotalRow();
	if($recordnumbers==0){//�޴�����
		?>
		<script language="javascript">
		 document.forms[0].tm.focus();
		</script>
		<?php 
	}
	else{
		$row=$checksql->getone();
		//echo $row['cp_name']
		?>
		<script lanugage="javascript">
		function showproduct(){
		document.forms[0].seek_text.value="<?php echo $row['cp_name']?>";
		document.forms[0].seek_number.value="<?php echo $row['cp_number']?>";
		document.forms[0].showinfo.value="��Ʒ���ƣ�<?php echo $row['cp_number']?>  ���<?php echo $row['cp_gg']?>";
		document.forms[0].showdw.value="<?php echo get_name($row['cp_dwname'],'dw')." ��棺".$row['number']?>";
		document.forms[0].sale.value="<?php echo $row['cp_sale']?>";
		document.forms[0].labid.value="<?php echo $row['l_id']?>";
		document.getElementById("sale_string").innerHTML="&nbsp;<input type='radio' name='sale1' checked value='<?php echo $row['cp_sale']?>' onclick='setsale(this.value)'><?php echo $row['cp_sale']?>&nbsp;����<input type='radio' name='sale1' value='<?php echo $row['cp_saleall']?>' onclick='setsale(this.value)'><?php echo $row['cp_saleall']?>&nbsp;����<input type='radio' name='sale1' value='<?php echo $row['cp_sale1']?>' onclick='setsale(this.value)'><?php echo $row['cp_sale1']?> ����";
		document.forms[0].rk_number.value="1";
		document.forms[0].rk_number.focus();
		}
		showproduct();
		</script>
		<?php 
	}
}
}
copyright();
?>
</body>
</html>