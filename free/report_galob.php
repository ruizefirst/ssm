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
<title>Ӫҵͳ��</title>
<script language=javascript>    
function preview(oper)
{
if (oper < 10){
bdhtml=window.document.body.innerHTML;//��ȡ��ǰҳ��html����
sprnstr="<!--startprint"+oper+"-->";//���ô�ӡ��ʼ����
eprnstr="<!--endprint"+oper+"-->";//���ô�ӡ��������
prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //�ӿ�ʼ�������ȡhtml

prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//�ӽ���������ǰȡhtml
window.document.body.innerHTML=prnhtml;
window.print();
window.document.body.innerHTML=bdhtml;
} 
else {
window.print();
}
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
      <td><strong>&nbsp;Ӫҵͳ��</strong>&nbsp;&nbsp; 
	  <a href="report_galob.php?type=other">�ۺ�ͳ��</a>&nbsp;&nbsp;
	  <input type="button" onClick="preview(1);" value=" ��ӡͳ�Ʊ��� ">
	  </td>
     </tr>
     <tr>
      <td bgcolor="#FFFFFF">
     <?php
	  if($type=='')$type='other';
	  switch($type){
	   case 'month':
	   ?>
       <table width="100%" cellspacing="0" cellpadding="0" border="0" id="table_border">
	    <tr height="40">
		<form action="report_galob.php?action=save&type=month" name="form1" method="post">
		 <td id="row_style" colspan="10">
		 ��Ӧ������:<?php echo ($action=='save')?getgyslist($gys,'select'):getgyslist('','')?>&nbsp;
		 ��ѡ���·�&nbsp;&nbsp;<input type="text" name="sday" onclick="setday(this)" value="<?php echo ($action=='save')?$sday:GetDateMk(time());?>">(���������ѡ�񱨱�����)&nbsp;&nbsp;
		 <input type="submit" value=" ��ʾ��ͳ�� ">
		 </td>
	    </tr>
	   <?php
	   break;
	   case 'year':
	   ?>
       <table width="100%" cellspacing="0" cellpadding="0" border="0" id="table_border">
	    <tr height="40">
		<form action="report_galob.php?action=save&type=year" name="form1" method="post">
		 <td id="row_style" colspan="10">
		 ��Ӧ������:<?php echo ($action=='save')?getgyslist($gys,'select'):getgyslist('','')?>&nbsp;
		 ��ѡ�����&nbsp;&nbsp;<input type="text" name="sday" onclick="setday(this)" value="<?php echo ($action=='save')?$sday:GetDateMk(time());?>">(���������ѡ�񱨱�����)&nbsp;&nbsp;
		 <input type="submit" value=" ��ʾ��ͳ�� ">
		 </td>
	    </tr>
		<?php
	   break;
	   case 'other':
	   ?>
	   <table width="100%" cellspacing="0" cellpadding="0" border="0" id="table_border">
	   <tr height="40">
		<form action="report_galob.php?action=save&type=other" name="form1" method="post">
		 <td id="row_style" colspan="10">
		 ��ʼʱ��:&nbsp;&nbsp;<input type="text" name="sday" onclick="setday(this)" value="<?php echo ($action=='save')?$sday:GetDateMk(time());?>">&nbsp;&nbsp;����ʱ��:&nbsp;&nbsp;<input type="text" name="eday" onclick="setday(this)" value="<?php echo ($action=='save')?$eday:GetDateMk(time());?>">(���������ѡ�񱨱�����)&nbsp;&nbsp;
		 <input type="submit" value=" ��ʾ�ۺ�ͳ�� ">
	   <?php
	   break;
	   }
		if($action=='save'){//��ʾ����
        $row=new dedesql(false);
		switch($type){
case 'other':
//�ɹ����
$query="select distinct rdh from #@__kc where dtime between '$sday' and '$eday'";
$row->setquery($query);
$row->execute();
$total_d=$row->gettotalrow();//����
$query="select * from #@__kc,#@__basic where #@__kc.productid=#@__basic.cp_number and dtime between '$sday' and '$eday'";
$report_title="�ۺ�Ӫҵ����";
$row->setquery($query);
$row->execute();
while ($rs=$row->getArray()){
 $totalnumber_in+=$rs['number'];
 $totalmoney_in+=$rs['number']*$rs['cp_jj'];
}
//�ɹ��˻����
$query="select distinct rdh from #@__kcbackgys where dtime between '$sday' and '$eday'";
$row->setquery($query);
$row->execute();
$total_b=$row->gettotalrow();//�˵���
$query="select * from #@__kcbackgys,#@__basic where #@__kcbackgys.productid=#@__basic.cp_number and dtime between '$sday' and '$eday'";
$row->setquery($query);
$row->execute();
while($rs=$row->getArray()){
 $totalmoney_back+=$rs['number']*$rs['cp_jj'];
 $totalnumber_back+=$rs['number'];
 }
//�������
$query="select distinct rdh from #@__sale where dtime between '$sday' and '$eday'";
$row->setquery($query);
$row->execute();
$total_s=$row->gettotalrow();//������
$query="select * from #@__sale,#@__basic where #@__sale.productid=#@__basic.cp_number and dtime between '$sday' and '$eday'";
$row->setquery($query);
$row->execute();
while ($rs=$row->getArray()){
 $totalnumber_s+=$rs['number'];
 $totalmoney_s+=$rs['number']*$rs['cp_sale'];
 $totalmoney_cb+=$rs['number']*$rs['cp_jj'];//���۳ɱ�
}
//�����˻����
$query="select distinct rdh from #@__saleback where dtime between '$sday' and '$eday'";
$row->setquery($query);
$row->execute();
$total_sb=$row->gettotalrow();//�˵���
$query="select * from #@__saleback,#@__basic where #@__saleback.productid=#@__basic.cp_number and dtime between '$sday' and '$eday'";
$row->setquery($query);
$row->execute();
while ($rs=$row->getArray()){
 $totalnumber_back+=$rs['number'];
 $totalmoney_sb+=$rs['number']*$rs['cp_sale'];
 $totalmoney_sb_cb+=$rs['number']*$rs['cp_jj'];
}
//���
$query="select * from #@__mainkc,#@__basic where #@__mainkc.p_id=#@__basic.cp_number";
$row->setquery($query);
$row->execute();
while ($rs=$row->getArray()){
 $totalnumber_kc+=$rs['number'];
 $totalmoney_kc+=$rs['number']*$rs['cp_jj'];
}
break;
}
$p_name=GetCookie('VioomaUserID');
$p_date=GetDateMk(time());

$row->close();
}
		?>
	   </table>
	   <?php if($action=='save'){?>
	   <table width="100%" cellspacing="0" cellpadding="0">
	    <tr>
		 <td>
   	  <!--startprint1-->
<?php 
require(dirname(__FILE__)."/templets/t_global.html");
?>
	   <!--endprint1-->
	     </td>
		</tr>
	   </table>
	   <?php } ?>
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
<?php
copyright();
?>
</body>
</html>
