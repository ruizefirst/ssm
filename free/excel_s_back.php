<?php
require(dirname(__FILE__)."/include/config_base.php");
require(dirname(__FILE__)."/include/config_rglobals.php");
$row=new dedesql(false);
switch($type){
case "day":
$query="select * from #@__saleback,#@__basic where to_days(#@__saleback.dtime)=to_days('$sday') and #@__saleback.productid=#@__basic.cp_number";
$report_title="�˻��ձ���";
break;
case "week":
$query="select * from #@__saleback,#@__basic where week(#@__saleback.dtime)='$sday' and #@__saleback.productid=#@__basic.cp_number";
$report_title="�˻��ܱ���";
break;
case "month":
$query="select * from #@__saleback,#@__basic where month(#@__saleback.dtime)=month('$sday') and #@__saleback.productid=#@__basic.cp_number";
$report_title="�˻��±���";
break;
case "year":
$query="select * from #@__saleback,#@__basic where YEAR(#@__saleback.dtime)=YEAR('$sday') and #@__saleback.productid=#@__basic.cp_number";
$report_title="�˻��걨��";
break;
case "other":
$query="select * from #@__saleback,#@__basic where #@__saleback.rdh='$sday' and #@__saleback.productid=#@__basic.cp_number";
$report_title="�ͻ��˻���";
break;
}
$row->setquery($query);
$row->execute();
header("Content-type:application/vnd.ms-excel");
header("Content-Disposition:filename=excel_rk.xls");
echo "����\t����\t���\t����\t��λ\t�ۼ�\t�ͻ�\t���۵���\t����\t���\t\n";
while($rs=$row->getArray()){
$allmoney+=$rs['number']*$rs['cp_sale'];
$alln+=$rs['number'];
echo $rs['productid']."\t".$rs['cp_name']."\t".$rs['cp_gg']."\t".get_name($rs['cp_categories'],'categories').">".get_name($rs['cp_categories_down'],'categories')."\t".get_name($rs['cp_dwname'],'dw')."\t".$rs['cp_jj']."\t".$rs['member']."\t".$rs['sdh']."\t".$rs['number']."\t��".$rs['number']*$rs['cp_sale']."\t\n";
}
echo "��   ��\t\t\t\t\t\t\t\t������".$alln."\t����".$allmoney."\t\n";
?>