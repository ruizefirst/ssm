<?php
require(dirname(__FILE__)."/include/config_base.php");
require(dirname(__FILE__)."/include/config_rglobals.php");
$row=new dedesql(false);
switch($type){
case "day":
$query="select * from #@__sale,#@__basic where YEAR(#@__kc.dtime)=YEAR('$sday') and month(#@__kc.dtime)=month('$sday') and to_days(#@__sale.dtime)=to_days('$sday') and #@__sale.productid=#@__basic.cp_number";
$report_title="�����ձ���";
break;
case "week":
$query="select * from #@__sale,#@__basic where week(#@__sale.dtime)='$sday' and #@__sale.productid=#@__basic.cp_number";
$report_title="�����ܱ���";
break;
case "month":
$query="select * from #@__sale,#@__basic where YEAR(#@__kc.dtime)=YEAR('$sday') and month(#@__sale.dtime)=month('$sday') and #@__sale.productid=#@__basic.cp_number";
$report_title="�����±���";
break;
case "year":
$query="select * from #@__sale,#@__basic where YEAR(#@__sale.dtime)=YEAR('$sday') and #@__sale.productid=#@__basic.cp_number";
$report_title="�����걨��";
break;
case "other":
$query="select * from #@__sale,#@__basic where #@__sale.rdh='$sday' and #@__sale.productid=#@__basic.cp_number";
$report_title="�ͻ����۵�";
break;
}
$row->setquery($query);
$row->execute();
header("Content-type:application/vnd.ms-excel");
header("Content-Disposition:filename=excel_rk.xls");
echo "����\t����\t���\t����\t��λ\t�ۼ�\t�ͻ�\t���۵�\t����\t���\t\n";
while($rs=$row->getArray()){
$allmoney+=$rs['number']*$rs['sale'];
$alln+=$rs['number'];
echo $rs['productid']."\t".$rs['cp_name']."\t".$rs['cp_gg']."\t".get_name($rs['cp_categories'],'categories').">".get_name($rs['cp_categories_down'],'categories')."\t".get_name($rs['cp_dwname'],'dw')."\t".$rs['cp_jj']."\t".get_name($rs['productid'],'gys')."\t".$rs['rdh']."\t".$rs['number']."\t��".$rs['number']*$rs['sale']."\t\n";
}
echo "��   ��\t\t\t\t\t\t\t\t������".$alln."\t����".$allmoney."\t\n";
?>