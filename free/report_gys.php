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
<title>��Ӧ�̶��ʵ�����</title>
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
      <td><strong>&nbsp;��Ӧ�̶��ʱ���</strong>&nbsp;&nbsp; 
	  <a href="report_gys.php?type=month">�±���</a> | 
	  <a href="report_gys.php?type=year">�걨��</a>&nbsp;&nbsp;
	  <input type="button" onClick="preview(1);" value=" ��ӡ��Ӧ�̶��ʱ� ">
	  </td>
     </tr>
     <tr>
      <td bgcolor="#FFFFFF">
     <?php
	  if($type=='')$type='month';
	  switch($type){
	   case 'month':
	   ?>
       <table width="100%" cellspacing="0" cellpadding="0" border="0" id="table_border">
	    <tr height="40">
		<form action="report_gys.php?action=save&type=month" name="form1" method="post">
		 <td id="row_style" colspan="10">
		 ��Ӧ������:<?php echo ($action=='save')?getgyslist($gys,'select'):getgyslist('','')?>&nbsp;
		 ��ѡ���·�&nbsp;&nbsp;<input type="text" name="sday" onclick="setday(this)" value="<?php echo ($action=='save')?$sday:GetDateMk(time());?>">(���������ѡ�񱨱�����)&nbsp;&nbsp;
		 <input type="submit" value=" ��ʾ�±��� ">
		 </td>
	    </tr>
	   <?php
	   break;
	   case 'year':
	   ?>
       <table width="100%" cellspacing="0" cellpadding="0" border="0" id="table_border">
	    <tr height="40">
		<form action="report_gys.php?action=save&type=year" name="form1" method="post">
		 <td id="row_style" colspan="10">
		 ��Ӧ������:<?php echo ($action=='save')?getgyslist($gys,'select'):getgyslist('','')?>&nbsp;
		 ��ѡ�����&nbsp;&nbsp;<input type="text" name="sday" onclick="setday(this)" value="<?php echo ($action=='save')?$sday:GetDateMk(time());?>">(���������ѡ�񱨱�����)&nbsp;&nbsp;
		 <input type="submit" value=" ��ʾ�걨�� ">
		 </td>
	    </tr>
		<?php
	   break;
	   }
		if($action=='save'){//��ʾ����
        $row=new dedesql(false);
		$plist=new datalist();
		$plist->pageSize = $cfg_record;
		//����GET������
		switch($type){
case "month":
$query="select * 
        from #@__sale,#@__basic 
		where month(#@__sale.dtime)=month('$sday') 
		and #@__sale.productid=#@__basic.cp_number 
		and #@__basic.cp_gys='$gys' 
		";
$report_title="��Ӧ���¶��ʵ�";
break;
case "year":
$query="select * 
        from #@__sale,#@__basic 
		where year(#@__sale.dtime)=year('$sday') 
		and #@__sale.productid=#@__basic.cp_number 
		and #@__basic.cp_gys='$gys' 
		";
$report_title="��Ӧ������ʵ�";
break;
}
$p_name=GetCookie('VioomaUserID');
$p_date=GetDateMk(time());
$worker=$staff;
$row->setquery($query);
$row->execute();
while($rs=$row->getArray()){
$allmoney+=$rs['number']*$rs['cp_jj'];
$alln+=$rs['number'];
}
$row->close();
$plist->SetParameter("type",$type);
$plist->SetParameter("action",$action);
$plist->SetParameter("sday",$sday);
$plist->SetSource($query);
$p_rtitle= "<tr class='row_report_head'>
<td>����</td>
<td>����</td>
<td>���</td>
<td>����</td>
<td>��λ</td>
<td>����</td>
<td>�ɹ�����</td>
<td>����</td>
<td>���</td>
</tr>";
$mylist = $plist->GetDataList();
       while($row = $mylist->GetArray('dm')){
	   $n+=$row['number'];
	   $money+=$row['number']*$row['cp_jj'];
	   $p_string=$p_string."<tr onMouseMove=\"javascript:this.bgColor='#EBF1F6';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\">\r\n
	   <td>".$row['productid']."</td>\r\n
	   <td>&nbsp;".$row['cp_name']."</td>\r\n
	   <td>".$row['cp_gg']."</td>\r\n<td>".get_name($row['cp_categories'],'categories').">".get_name($row['cp_categories_down'],'categories')."</td>\r\n
	   <td>".get_name($row['cp_dwname'],'dw')."</td>
	   <td>��".$row['cp_jj']."</td>\r\n
	   <td>".$row['rdh']."</td>\r\n<td>".$row['number']."</td>\r\n
	   <td>��".$row['number']*$row['cp_jj']."</td>\r\n
	   </tr>";
	   }
	   $p_string="<table width='100%' id='report_table' border='1' cellspacing='0' cellpadding='0'>". $p_rtitle .$p_string. "<tr>\r\n<td>&nbsp;&nbsp;С  �ƣ�</td><td colspan='5'>&nbsp;</td><td colspan='2'>������".$n."</td><td colspan='2'>����".$money."</td>\r\n</tr>\r\n
	   <tr><td>&nbsp;&nbsp;��  ��:</td><td colspan='4'>������".$alln."</td><td colspan='3'>���:��".number_format($allmoney,2,'.',',')."</td><td colspan='2'></td></tr>
	   </table>";	
	   $p_pagestring=$plist->GetPageList($cfg_record);
		}
		?>
	   </table><?php if($action=='save'){?>
	   <table width="100%" cellspacing="0" cellpadding="0">
	    <tr>
		 <td>
   	  <!--startprint1-->
<?php 
require(dirname(__FILE__)."/templets/t_gys.html");
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
