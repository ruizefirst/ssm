<?php
require(dirname(__FILE__)."/include/config_rglobals.php");
require(dirname(__FILE__)."/include/config_base.php");
require_once(dirname(__FILE__)."/include/checklogin.php");
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
 if($cp_name=='') echo "<script language='javascript'>alert('�������Ʒ������!');history.go(-1)</script>";
 if($cp_gg=='') echo "<script language='javascript'>alert('�������Ʒ�Ĺ��!');history.go(-1)</script>";
 if($cp_categories=='') echo "<script language='javascript'>alert('�������Ʒ�ķ���!');history.go(-1)</script>";
 if($cp_categories_down=='') echo "<script language='javascript'>alert('�������Ʒ���ӷ���!');history.go(-1)</script>";
 if($cp_dwname=='') echo "<script language='javascript'>alert('�������Ʒ�Ļ�����λ!');history.go(-1)</script>";
 if($cp_jj=='' || $cp_sale=='') echo "<script language='javascript'>alert('��Ʒ�����뽨�����ۼ�Ϊ������!');history.go(-1)</script>";
 if(!(is_numeric($cp_jj) && is_numeric($cp_sale) )) echo "<script language='javascript'>alert('�۸����Ϊ����!');history.go(-1)</script>";
 if($cp_jj>$cp_sale) echo "<script language='javascript'>alert('���ۼ۲���С�ڽ���!');history.go(-1)</script>";
$bsql=New Dedesql(false);
$query="update #@__basic set cp_number='".$cp_number."',cp_tm='".$cp_tm."',cp_name='".$cp_name."',cp_gg='".$cp_gg."',cp_categories='".$cp_categories."',cp_categories_down='".$cp_categories_down."',cp_dwname='".$cp_dwname."',cp_style='".$cp_style."',cp_jj='".$cp_jj."',cp_sale='".$cp_sale."',cp_saleall='".$cp_saleall."',cp_sale1='".$cp_sale1."',cp_sdate='".$cp_sdate."',cp_edate='".$cp_edate."',cp_gys='".$cp_gys."',cp_helpword='".$cp_helpword."',cp_bz='".$cp_bz."' where id='$id'";
$bsql->ExecuteNoneQuery($query);
showmsg('�ɹ��޸��˲�Ʒ������Ϣ','system_basic_cp.php?action=seek');
 $loginip=getip();
 $logindate=getdatetimemk(time());
 $username=GetCookie('VioomaUserID');
 WriteNote('�޸Ĳ�Ʒ������Ϣ'.$cp_name.' �ɹ�',$logindate,$loginip,$username);
$bsql->close();
exit();
}
$seekrs=New Dedesql(falsh);
$squery="select * from #@__basic where id='$id'";
$seekrs->SetQuery($squery);
$seekrs->Execute();
$rowcount=$seekrs->gettotalrow();
if($rowcount==0){
Showmsg('�Ƿ��Ĳ���','-1');
exit();
}
$row=$seekrs->GetOne();
$seekrs->close();
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
 <form action="system_basic_edit.php?action=save" method="post" name="form1">
   <tr>
    <td class="cellcolor">��Ʒ����:</td>
    <td>&nbsp;<input type="hidden" value="<?php echo $id?>" name="id"><input type="text" name="cp_number" value="<?php echo $row['cp_number'] ?>" style="color:red;font-family:Verdana, Arial, Helvetica, sans-serif;"></td>
  </tr>
  <tr>
    <td class="cellcolor" width="30%">��Ʒ������:<br>(��������ɨ���ǿ�ֱ��ɨ��)</td>
    <td>&nbsp;<input type="text" name="cp_tm" value="<?php echo $row['cp_tm'] ?>" onkeydown="check(event);">&nbsp;��ʹ��������,����ʱ��ֱ��ʹ��</td>
  </tr>  
  <tr>
    <td class="cellcolor" width="30%">��Ʒ����:</td>
    <td>&nbsp;<input type="text" name="cp_name" id="need" onblur="pinyin(this.value)" value="<?php echo $row['cp_name'] ?>"></td>
  </tr>
  <tr>
    <td class="cellcolor">��Ʒ���:</td>
    <td>&nbsp;<input type="text" name="cp_gg" id="need" value="<?php echo $row['cp_gg'] ?>"></td>
  </tr>
  <tr>
    <td class="cellcolor">��Ʒ��������:</td>
    <td>&nbsp;
	<?php
    getcategories($row['cp_categories'],$row['cp_categories_down']);
	?>	</td>
  </tr>
  <tr>
    <td class="cellcolor">��λ:</td>
    <td>&nbsp;<?php getdw($row['cp_dwname']) ?></td>
  </tr>
  <td class="cellcolor">��Ʒ����:</td>
  <td>&nbsp;
  <?php
  if($row['cp_style']=='1')
  echo "<select name='cp_style'><option selected value='1'>�������۲�Ʒ</option><option value='0'>�����۲�Ʒ</option></select>";
  else
  echo "<select name='cp_style'><option value='1'>�������۲�Ʒ</option><option selected value='0'>�����۲�Ʒ</option></select>";
  ?>&nbsp;�����۲�Ʒ����������������б���
  </td>
  <tr>
    <td class="cellcolor">�����۸�:</td>
    <td>&nbsp;<input type="text" name="cp_jj" id="need" value="<?php echo $row['cp_jj'] ?>"></td>
  </tr>
  <tr>
    <td class="cellcolor">�������ۼ۸�:</td>
    <td>&nbsp;<input type="text" name="cp_sale" id="need" value="<?php echo $row['cp_sale'] ?>"></td>
  </tr>
  <tr>
    <td class="cellcolor">���������۸�:</td>
    <td>&nbsp;<input type="text" name="cp_saleall" value="<?php echo $row['cp_saleall'] ?>"></td>
  </tr>
  <tr>
   <td class="cellcolor">�Զ���۸�</td>
   <td>&nbsp;<input type="text" name="cp_sale1" value="<?php echo $row['cp_sale1'] ?>">
  </tr>  
  <tr>
    <td class="cellcolor">��������:</td>
    <td>&nbsp;<input type="text" name="cp_sdate" onclick="setday(this)" value="<?php echo $row['cp_sdate'] ?>">
	&nbsp;���������ѡ��ʱ��	</td>
  </tr>
  <tr>
    <td class="cellcolor">��������:</td>
    <td>&nbsp;<input type="text" name="cp_edate" onclick="setday(this)" value="<?php echo $row['cp_edate'] ?>">&nbsp;���������ѡ��ʱ��</td>
  </tr>
  <tr>
    <td class="cellcolor">��Ӧ��:</td>
    <td>&nbsp;<input type="text" name="cp_gys" readonly value="<?php echo $row['cp_gys'] ?>">&nbsp;<img src="images/up.gif" border="0" align="absmiddle" style="cursor:hand;" onclick="window.open('select_gys.php?form=form1&field=cp_gys','selected','directorys=no,toolbar=no,status=no,menubar=no,resizable=no,width=250,height=270,top=200,left=520')" />���ѡ��Ӧ��</td>
  </tr>

  <tr>
    <td class="cellcolor">���Ǵ�:</td>
    <td>&nbsp;<input type="text" name="cp_helpword" value="<?php echo $row['cp_helpword'] ?>">&nbsp;(���ڿ�����Ѱ��Ʒ��,�粻������ƴ��������ĸ��¼)</td>
  </tr>    
  <tr>
    <td class="cellcolor">��ע:</td>
    <td>&nbsp;
      <textarea rows="5" cols="30" name="cp_bz"><?php echo $row['cp_bz'] ?></textarea></td>
  </tr>
  <tr>
    <td class="cellcolor">&nbsp;</td>
    <td>&nbsp;<input type="button" value=" �޸Ĳ�Ʒ��Ϣ " onclick="checkForm()"></td>
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
copyright();
?>
</body>
</html>