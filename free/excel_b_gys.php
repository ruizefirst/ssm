<?php
require(dirname(__FILE__)."/include/config_base.php");
require(dirname(__FILE__)."/include/config_rglobals.php");
$row=new dedesql(false);
switch($type){
case "day":
$query="select * from #@__kcbackgys,#@__basic where to_days(#@__kcbackgys.dtime)=to_days('$sday') and #@__kcbackgys.productid=#@__basic.cp_number";
$report_title="�˻ع������ձ���";
break;
case "week":
$query="select * from #@__kcbackgys,#@__basic where week(#@__kcbackgys.dtime)='$sday' and #@__kcbackgys.productid=#@__basic.cp_number";
$report_title="�˻ع������ܱ���";
break;
case "month":
$query="select * from #@__kcbackgys,#@__basic where month(#@__kcbackgys.dtime)=month('$sday') and #@__kcbackgys.productid=#@__basic.cp_number";
$report_title="�˻ع������±���";
break;
case "year":
$query="select * from #@__kcbackgys,#@__basic where YEAR(#@__kcbackgys.dtime)=YEAR('$sday') and #@__kcbackgys.productid=#@__basic.cp_number";
$report_title="�˻ع������걨��";
break;
case "other":
$query="select * from #@__kcbackgys,#@__basic where #@__kcbackgys.rdh='$sday' and #@__kcbackgys.productid=#@__basic.cp_number";
$report_title="�ɹ��˻�����";
break;
}
$row->setquery($query);
$row->execute();
header("Content-type:application/vnd.ms-excel");
header("Content-Disposition:filename=excel_rk.xls");
echo "����\t����\t���\t����\t��λ\t����\t��Ӧ��\t�ɹ�����\t����\t���\t\n";
while($rs=$row->getArray()){
$allmoney+=$rs['number']*$rs['cp_jj'];
$alln+=$rs['number'];
echo $rs['productid']."\t".$rs['cp_name']."\t".$rs['cp_gg']."\t".get_name($rs['cp_categories'],'categories').">".get_name($rs['cp_categories_down'],'categories')."\t".get_name($rs['cp_dwname'],'dw')."\t".$rs['cp_jj']."\t".get_name($rs['productid'],'gys')."\t".$rs['idh']."\t".$rs['number']."\t��".$rs['number']*$rs['cp_jj']."\t\n";
}
echo "��   ��\t\t\t\t\t\t\t\t������".$alln."\t����".$allmoney."\t\n";
?>