<?php
require(dirname(__FILE__)."/include/config_rglobals.php");
require(dirname(__FILE__)."/include/config_base.php");
require(dirname(__FILE__)."/include/page.php");
require_once(dirname(__FILE__)."/include/checklogin.php");
check_grant('system_basic_cp.php',GetCookie('rank'));
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="style/main.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="include/calendar.js"></script>
<script language="javascript" src="include/py.js"></script>
<title>��Ʒ������Ϣ¼��</title>
<script language = "JavaScript">
var onecount; 
onecount = 0; 
subcat = new Array();
<?php
$count=0;
$rsql=New Dedesql(false);
$rsql->SetQuery("select * from #@__categories where reid!=0");
$rsql->Execute();
while($rs=$rsql->GetArray()){
?>
subcat[<?php echo $count;?>] = new Array("<?php echo $rs['categories'];?>","<?php echo $rs['reid'];?>","<?php echo $rs['id'];?>");
<?php 
    $count++;
}
$rsql->close();
?>
onecount=<?php echo $count?>; 
function getCity(locationid) 
{ 
    document.form1.cp_categories_down.length = 0; 

    var locationid=locationid; 

    var i; 
    document.form1.cp_categories_down.options[0] = new Option('==��ѡ������ӷ���==',''); 
    for (i=0;i < onecount; i++) 
    { 
        if (subcat[i][1] == locationid) 
        { 
        document.form1.cp_categories_down.options[document.form1.cp_categories_down.length] = new Option(subcat[i][0], subcat[i][2]);
        } 
    } 

} 

function out_excel(){
/*cp=document.forms[0].cp_categories.value;
cp_down=document.forms[0].cp_categories_down.value;*/
s=document.forms[0].sort.value;
st=document.forms[0].stext.value;
window.open('excel_basic.php?sort='+s+'&stext='+st,'','');
}

</script>
<script type="text/vbscript"> 
function vbChr(c) 
vbChr = chr(c) 
end function 

function vbAsc(n) 
vbAsc = asc(n) 
end function 

</script> 
</head>
<?php
if ($action=='save'){
 if($cp_name==''){ echo "<script language='javascript'>alert('�������Ʒ������!');history.go(-1)</script>";exit();}
 if($cp_gg=='') {echo "<script language='javascript'>alert('�������Ʒ�Ĺ��!');history.go(-1)</script>";exit();}
 if($cp_categories==''){ echo "<script language='javascript'>alert('�������Ʒ�ķ���!');history.go(-1)</script>";exit();}
 if($cp_categories_down==''){ echo "<script language='javascript'>alert('�������Ʒ���ӷ���!');history.go(-1)</script>";exit();}
 if($cp_dwname==''){ echo "<script language='javascript'>alert('�������Ʒ�Ļ�����λ!');history.go(-1)</script>";exit();}
 if($cp_jj=='' || $cp_sale==''){ echo "<script language='javascript'>alert('��Ʒ�����뽨�����ۼ�Ϊ������!');history.go(-1)</script>";exit();}
 if(!(is_numeric($cp_jj) && is_numeric($cp_sale) )){ echo "<script language='javascript'>alert('�۸����Ϊ����!');history.go(-1)</script>";exit();}
 if($cp_jj>$cp_sale){ echo "<script language='javascript'>alert('���ۼ۲���С�ڽ���!');history.go(-1)</script>";exit();}
$bsql=New Dedesql(false);
$query="select * from #@__basic where cp_name='$cp_name' and cp_gg='$cp_gg'";
$bsql->SetQuery($query);
$bsql->Execute();
$rowcount=$bsql->GetTotalRow();
if ($rowcount>=1){
 ShowMsg('�˲�Ʒ���ƺ͹�������ݿ����Ѿ�����,���������!','-1');
 exit();
}
else{
if($cp_saleall=='')$cp_saleall=$cp_sale;
if($cp_sale1=='')$cp_sale1=$cp_sale;
if($cp_sdate=='')$cp_sdate='0000-00-00';
if($cp_edate=='')$cp_edate='0000-00-00';
$addquery="insert into #@__basic(cp_number,cp_tm,cp_name,cp_gg,cp_categories,cp_categories_down,cp_dwname,cp_style,cp_jj,cp_sale,cp_saleall,cp_sale1,cp_sdate,cp_edate,cp_gys,cp_helpword,cp_bz) values('$cp_number','$cp_tm','$cp_name','$cp_gg','$cp_categories','$cp_categories_down','$cp_dwname','$cp_style','$cp_jj','$cp_sale','$cp_saleall','$cp_sale1','$cp_sdate','$cp_edate','$cp_gys','$cp_helpword','$cp_bz')";
$rs=$bsql->ExecuteNoneQuery($addquery);
if($rs)
ShowMsg('�ɹ�д��һ����Ʒ������Ϣ.','system_basic_cp.php');
else
ShowMsg('��������:'.$bsql->getError(),'-1');
 $loginip=getip();
 $logindate=getdatetimemk(time());
 $username=GetCookie('VioomaUserID');
 WriteNote('��Ӳ�Ʒ������Ϣ'.$cp_name.' �ɹ�',$logindate,$loginip,$username);
$bsql->close();
exit();
    }
}
else if($action=='seek'){ //�б�
?>
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
	<form action="system_basic_cp.php?action=seek&seek=yes" method="post" name="form1">
     <tr>
      <td><strong>&nbsp;��Ʒ������Ϣ����</strong>(ע:��ɫ����Ϊ����ѡ��)&nbsp;&nbsp;- <a href="system_basic_cp.php">�²�Ʒ�Ǽ�</a> - <a href="system_basic_cp.php?action=seek">��Ʒ������Ϣ��ѯ</a></td>
     </tr>
     <tr height="27">
	  <td align="right" bgcolor="#FFFFFF">
	  ������
		 <select name="sort">
		 <option value="1">�����Ų�ѯ</option>
		 <option value="2">�������ѯ</option>
		 <option value="3" selected>�����Ʋ�ѯ</option>
		 <option value="4">�����Ǵʲ�ѯ</option>
		 </select>
		 <input type="text" name="stext" size="15" VALUE="<?PHP ECHO $stext ?>"><input type="submit" value="��ʼ����">&nbsp;<input type="button" onclick="out_excel()" value="����excel" />
		 &nbsp;&nbsp;
	  </td>
	 </tr></form>
	 <tr>
      <td bgcolor="#FFFFFF">
<?php
echo "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" id=\"table_border\">";
if($seek=='yes'){
switch($sort){
 case "1":
 $query="select * from #@__basic where cp_number LIKE '%".$stext."%'";
 break;
 case "2":
 $query="select * from #@__basic where cp_tm = '$stext'";
 break;
 case "3":
 $query="select * from #@__basic where cp_name LIKE '%".$stext."%'";
 break;
 case "4":
 $query="select * from #@__basic where cp_helpword LIKE '%".$stext."%'";
 break;
}
}
else
$query="select * from #@__basic";
$csql=New Dedesql(false);
$dlist = new DataList();
$dlist->pageSize = $cfg_record;
$dlist->SetParameter("action",$action);
$dlist->SetParameter("seek",$seek);
$dlist->SetParameter("sort",$sort);
$dlist->SetParameter("stext",$stext);
//$dlist->SetParameter("field",$field);//����GET������
$dlist->SetSource($query);
	   echo "<tr class='row_color_head'>
	   <td>ID</td>
	   <td>����</td>
	   <td>���</td>
	   <td>����</td>
	   <td>��λ</td>
	   <td>����</td>
	   <td>��Ӧ��</td>
	   <td>����</td>
	   <td>���Ǵ�</td>
	   <td>����</td>
	   </tr>";
	   $mylist = $dlist->GetDataList();
       while($row = $mylist->GetArray('dm')){
	   if($row['cp_style']=='1')$pstyle='';
	   else
	   $pstyle="<font color=red>������</font>";
	   echo "<tr>
	   <td><center>ID��:".$row['id']."</td>
	   <td><center>&nbsp;".$row['cp_name']."</td>
	   <td><center>&nbsp;".$row['cp_gg']."</td>
	   <td><center>&nbsp;".get_name($row['cp_categories'],'categories').">".get_name($row['cp_categories_down'],'categories')."</td>
	   <td><center>&nbsp;".get_name($row['cp_dwname'],'dw')."</td>
	   <td><center>&nbsp;��".$row['cp_jj']."</td>
	   <td>".$row['cp_gys']."</td>
	   <td><center>".$pstyle."</td>
	   <td><center>".$row['cp_helpword']."</td>
	   <td><a href=system_basic_edit.php?id=".$row['id'].">�޸�</a> | <a href=system_basic_del.php?id=".$row['id'].">ɾ��</a></td>
	   </tr>";
	   }
	   echo "<tr><td colspan='8'>&nbsp;".$dlist->GetPageList($cfg_record)."</td></tr></table>";
	  
	   $csql->close();
   echo " </td></tr></table>
 </td></tr><tr>
    <td id=\"table_style\" class=\"l_b\">&nbsp;</td>
    <td>&nbsp;</td>
    <td id=\"table_style\" class=\"r_b\">&nbsp;</td>
  </tr>
</table>";
 }
 else{
?>
<script language="javascript">
function check(e){
var e = window.event ? window.event : e;
    if(e.keyCode == 13){
    document.forms[0].cp_name.focus();
	return false;
    }
}
function checkForm(){
document.forms[0].submit();
}
</script>
<body onload="form1.cp_tm.focus()">
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
      <td><strong>&nbsp;��Ʒ������Ϣ����</strong>(ע:��ɫ����Ϊ����ѡ��)&nbsp;&nbsp;- <a href="system_basic_cp.php">�²�Ʒ�Ǽ�</a> - <a href="system_basic_cp.php?action=seek">��Ʒ������Ϣ��ѯ</a></td>
     </tr>
     <tr>
      <td bgcolor="#FFFFFF">
 <table width="100%" border="0" cellspacing="0" cellpadding="0" id="table_border">
 <form action="system_basic_cp.php?action=save" method="post" name="form1">
   <tr>
    <td class="cellcolor">��Ʒ����:</td>
    <td>&nbsp;<input type="text" name="cp_number" value="<?php echo GetMkTime(time()) ?>" style="color:red;"></td>
  </tr>
  <tr>
    <td class="cellcolor" width="30%">��Ʒ������:<br>(��������ɨ���ǿ�ֱ��ɨ��)</td>
    <td>&nbsp;<input type="text" name="cp_tm" onkeydown="check(event);">&nbsp;��ʹ��������,����ʱ��ֱ��ʹ��</td>
  </tr>  
  <tr>
    <td class="cellcolor" width="30%">��Ʒ����:</td>
    <td>&nbsp;<input type="text" name="cp_name" id="need" onblur="pinyin(this.value)"></td>
  </tr>
  <tr>
    <td class="cellcolor">��Ʒ���:</td>
    <td>&nbsp;<input type="text" name="cp_gg" id="need"></td>
  </tr>
  <tr>
    <td class="cellcolor">��Ʒ��������:</td>
    <td>&nbsp;
	<?php
    getcategories(0,'');
	?>	</td>
  </tr>
  <tr>
    <td class="cellcolor">��λ:</td>
    <td>&nbsp;<?php getdw() ?></td>
  </tr>
  <tr>
   <td class="cellcolor">��Ʒ����:</td>
   <td>&nbsp;<select name="cp_style"><option selected value="1">�������۲�Ʒ</option><option value="0">�����۲�Ʒ</option></select>&nbsp;�����۲�Ʒ����������������б���
   </td>
  </tr>
  <tr>
    <td class="cellcolor">�����۸�:<br>(���ʱ�������޸Ļ�����)</td>
    <td>&nbsp;<input type="text" name="cp_jj" id="need"></td>
  </tr>
  <tr>
    <td class="cellcolor">�������ۼ۸�:</td>
    <td>&nbsp;<input type="text" name="cp_sale" id="need"></td>
  </tr>
  <tr>
    <td class="cellcolor">���������۸�:</td>
    <td>&nbsp;<input type="text" name="cp_saleall"></td>
  </tr>
  <tr>
   <td class="cellcolor">�Զ���۸�:</td>
   <td>&nbsp;<input type="text" name="cp_sale1">
  </tr>
  <tr>
    <td class="cellcolor">��������:</td>
    <td>&nbsp;<input type="text" name="cp_sdate" onclick="setday(this)">
	&nbsp;���������ѡ��ʱ��	</td>
  </tr>
  <tr>
    <td class="cellcolor">��������:</td>
    <td>&nbsp;<input type="text" name="cp_edate" onclick="setday(this)">&nbsp;���������ѡ��ʱ��</td>
  </tr>
  <tr>
    <td class="cellcolor">��Ӧ��:</td>
    <td>&nbsp;<input type="text" name="cp_gys" readonly>&nbsp;<img src="images/up.gif" border="0" align="absmiddle" style="cursor:hand;" onclick="window.open('select_gys.php?form=form1&field=cp_gys','selected','directorys=no,toolbar=no,status=no,menubar=no,resizable=no,width=250,height=270,top=200,left=520,scrollbars=yes')" />���ѡ��Ӧ��</td>
  </tr>

  <tr>
    <td class="cellcolor">���Ǵ�:</td>
    <td>&nbsp;<input type="text" name="cp_helpword">&nbsp;(���ڿ�����Ѱ��Ʒ��,�粻������ƴ��������ĸ��¼)</td>
  </tr>    
  <tr>
    <td class="cellcolor">��ע:</td>
    <td>&nbsp;
      <textarea rows="5" cols="30" name="cp_bz"></textarea></td>
  </tr>
  <tr>
    <td class="cellcolor">&nbsp;</td>
    <td>&nbsp;<input type="button" value=" �Ǽ��²�Ʒ " onclick="checkForm()"></td>
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
}
copyright();
?>
</body>
</html>
