<title>Web进销存 -Powered by viooma.com</title>
<?php 
if(!file_exists(dirname(__FILE__)."/install/install.finish")){
  echo "·如果你还没安装本程序，请运行<a href='install/index.php'> install/index.php </a> 进入安装&gt;&gt;<br/><br/>";
  echo "·如果你已经安装好程序，请删除或者重新命名 install 目录!  <br/><br/>";
  exit();
}
?>
<frameset rows="90,*,27" cols="*" frameborder="0" framespacing="0">
 <frame src="top.php" frameborder="0" noresize="noresize" scrolling="no"/>
 <frameset cols="180,*" frameborder="0">
  <frame src="menu.php" name="menu" noresize="noresize" frameborder="0" scrolling="no"/>
  <frame src="main.php" name="main" noresize="noresize" frameborder="0"/>
 </frameset>
 <frame src="footer.php" frameborder="0" noresize="noresize" scrolling="no" />
</frameset><noframes></noframes>