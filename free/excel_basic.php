<?php
require(dirname(__FILE__)."/include/config_base.php");
require(dirname(__FILE__)."/include/config_rglobals.php");
$query="select * from #@__basic";
$row=New Dedesql(false);
$row->setquery($query);
$row->execute();
header("Content-type:application/vnd.ms-excel");
header("Content-Disposition:filename=excel_basic.xls");
echo "����\t����\t���\t����\t��λ\t����\t��Ӧ��\t\n";
while($rs=$row->getArray()){
$alln+=1;
echo $rs['cp_number']."\t".$rs['cp_name']."\t".$rs['cp_gg']."\t".get_name($rs['cp_categories'],'categories').">".get_name($rs['cp_categories_down'],'categories')."\t".get_name($rs['cp_dwname'],'dw')."\t".$rs['cp_jj']."\t".get_name($rs['cp_number'],'gys')."\t\n";
}
echo "��   ��\t\t\t\t\t\t\t��Ʒ���ࣺ\t".$alln." ��\t\n";
?>