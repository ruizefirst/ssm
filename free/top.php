<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>Viooma������Web��</title>
<style type="text/css">
body {font:normal 12px Arial;background:#3179bd url(images/right_bg.gif) repeat-x top;margin:0px;}
td,p{font-size:12px;}
#main_table {background:url(images/top_bg.gif) no-repeat left top;}
#top_menu {background:url(images/menu02.gif) no-repeat bottom center;text-align:center;width:70px;float:left;margin-left:5px;height:27px;padding-top:10px;}
#top_menu a{padding-top:10px;font-weight:bold;}
a:link,a:visited {font:normal 12px Verdana, Arial, Helvetica, sans-serif;color:#000;text-decoration:none;}
a:hover {font:normal 12px Verdana, Arial, Helvetica, sans-serif;color:#F00;text-decoration:none;}
#menu_big{font:bold 13px Arial;color:#FFF;padding-left:10px;}
</style>
<script language='javascript'>
function $Nav(){
	if(window.navigator.userAgent.indexOf("MSIE")>=1) return 'IE';
  else if(window.navigator.userAgent.indexOf("Firefox")>=1) return 'FF';
  else return "OT";
}

var preID = 0;

function OpenMenu(cid,lurl,rurl,bid){
   if($Nav()=='IE'){
     if(rurl!='') top.document.frames.main.location = rurl;
     if(cid > -1) top.document.frames.menu.location = 'menu.php?c='+cid;
     else if(lurl!='') top.document.frames.menu.location = lurl;
     if(bid>0) document.getElementById("d"+bid).className = 'thisclass';
     if(preID>0 && preID!=bid) document.getElementById("d"+preID).className = '';
     preID = bid;
   }else{
     if(rurl!='') top.document.getElementById("main").src = rurl;
     if(cid > -1) top.document.getElementById("menu").src = 'menu.php?c='+cid;
     else if(lurl!='') top.document.getElementById("menu").src = lurl;
     if(bid>0) document.getElementById("d"+bid).className = 'thisclass';
     if(preID>0 && preID!=bid) document.getElementById("d"+preID).className = '';
     preID = bid;
   }
}

var preFrameW = '160,*';
var FrameHide = 0;
function ChangeMenu(way){
	var addwidth = 10;
	var fcol = top.document.all.bodyFrame.cols;
	if(way==1) addwidth = 10;
	else if(way==-1) addwidth = -10;
	else if(way==0){
		if(FrameHide == 0){
			preFrameW = top.document.all.bodyFrame.cols;
			top.document.all.bodyFrame.cols = '0,*';
			FrameHide = 1;
			return;
		}else{
			top.document.all.bodyFrame.cols = preFrameW;
			FrameHide = 0;
			return;
		}
	}
	fcols = fcol.split(',');
	fcols[0] = parseInt(fcols[0]) + addwidth;
	top.document.all.bodyFrame.cols = fcols[0]+',*';
}

function resetBT(){
	if(preID>0) document.getElementById("d"+preID).className = 'bdd';
	preID = 0;
}

</script>
</head>
<body leftmargin="0" topmargin="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="90" id="main_table">
  <tr height="41">
    <td width="180"><img src="images/logo.gif"></td>
    <td valign="bottom" align="left">
	 <table width="100%" height="27" cellspacing="0" cellpadding="0" border="0">
	  <tr>
	   <td width="10"></td>
	   <td>
	   <div id="top_menu"><a href="javascript:OpenMenu(2,'','system_basic.php',1)">ϵͳ����</a></div>
	   <div id="top_menu"><a href="javascript:OpenMenu(3,'','system_rk.php',2)">������</a></div>
	   <div id="top_menu"><a href="javascript:OpenMenu(4,'','sale.php',1)">���۹���</a></div>
	   <div id="top_menu"><a href="javascript:OpenMenu(5,'','system_kc.php',1)">������</a></div>
	   <div id="top_menu"><a href="javascript:OpenMenu(6,'','system_guest.php',1)">�ͻ�����</a></div>
	   <div id="top_menu"><a href="javascript:OpenMenu(7,'','report.php',1)">ͳ�Ʊ���</a></div>
	   <div id="top_menu"><a href="javascript:OpenMenu(8,'','system_money.php',1)">�������</a></div>
	   <div id="top_menu"><a href="javascript:OpenMenu(9,'','system_ys.php',1)">Ӧ��Ӧ��</a></div>
	   <div id="top_menu"><a href="system_note.php" target="main">ϵͳ��־</a></div>
	   </td>
	   <td width="10%">&nbsp;</td>
	  </tr>
	 </table>
	</td>
  </tr>
  <tr height="17">
    <td colspan="2"></td>
  </tr>
  <tr height="32">
   <td style="background:url(images/left_menu_bg.gif) no-repeat center bottom;"><div id="menu_big">���ù��ܿ��ٵ���</div></td>
   <td>
   <table width="100%" border="0" cellspacing="0" cellpadding="0" height="32">
    <tr>
     <td width="10" style="background:url(images/bg_bottom.gif) repeat-x bottom;vertical-align:top"><img src="images/teble_top_left.gif"></td>
     <td style="background:url(images/bg_bottom.gif) repeat-x bottom">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
        <td width="15"><img src="images/arrow.gif"></td>
		<td width="420" style="color:#FF0000;">
		<?php
require_once(dirname(__FILE__)."/include/config_base.php");
require_once(dirname(__FILE__)."/include/checklogin.php");
		if ($cfg_isalarm=='1'){//���ÿ�汨��
		$sql=new dedesql(false);
		$query="select * from #@__mainkc where number<=5";
		$sql->setquery($query);
		$sql->execute();
		$snumber=$sql->gettotalrow();
		 if($snumber<=0)
		 echo "<b>&nbsp;��汨��:</b>&nbsp;��0������Ʒ����ȱ��";
		 else
		 echo "<b>&nbsp;��汨��:</b>&nbsp;".$snumber."������Ʒȱ��,<a href='system_kc_lost.php' target='main'>����鿴</a>";
		 $sql->close();
		}
		else{
		?>
		���¹��棺<iframe width="380" height="22" src="http://www.viooma.com/note.html" scrolling="no" frameborder="0" marginheight="0" marginwidth="0" vspace="0" hspace="0"></iframe>
		<?php
		}
		?>
		<div style="display:none;"><script language="javascript" type="text/javascript" src="http://js.users.51.la/2059281.js"></script></div></td>
        <td align="right">&nbsp;<?php echo GetCookie('VioomaUserID')."(".getusertype(GetCookie('rank'),0).")";?>&nbsp;|&nbsp;<a href="http://www.viooma.com" target="_blank">�ٷ���ҳ</a>&nbsp;|&nbsp;<a href="system_password.php" target="main">�޸�����</a>&nbsp;|&nbsp;<a href="system_out.php" target="_top">��ȫ�˳�</a></td>
       </tr>
      </table>
	 </td>
     <td style="background:url(images/bg_bottom.gif) repeat-x bottom right;vertical-align:top;width:8px;"><img src="images/teble_top_right.gif" style="text-align:right;width:8px;"></td>
	 <td width="15"></td>
    </tr>
   </table>
   </td>
  </tr>
</table>
</body>
</html>
