package com.dsy.www.coding.senior.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 14, 2017 10:01:04 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @parameter
 * @since  
 * @return
 * Applet 是一种 Java 程序。它一般运行在支持 Java 的 Web 浏览器内。因为它有完整的 Java API支持,所以Applet 是一个全功能的 Java 应用程序。
 * Applet 类中的四个方法给你提供了一个框架，你可以再该框架上开发小程序：
 * 	1、init: 该方法的目的是为你的 Applet 提供所需的任何初始化。在 Applet 标记内的 param 标签被处理后调用该方法。
 *  2、start: 浏览器调用 init 方法后，该方法被自动调用。每当用户从其他页面返回到包含 Applet 的页面时，则调用该方法。
 *  3、stop: 当用户从包含 Applet 的页面移除的时候，该方法自动被调用。因此，可以在相同的 Applet 中反复调用该方法。
 *  4、destroy: 此方法仅当浏览器正常关闭时调用。因为 Applet 只有在 HTML 网页上有效，所以你不应该在用户离开包含 Applet 的页面后遗漏任何资源
 *  5、paint: 该方法在 start() 方法之后立即被调用，或者在 Applet 需要重绘在浏览器的时候调用。paint() 方法实际上继承于 java.awt。
 * 
 **/
public class HelloWorldApplet extends Applet {//小程序 demo
	 public static void main(String args[]){
		 
	 }
	 public void paint(Graphics g){
		 g.drawString("Hello World", 25, 50);
		 String str = "<html><head><head><body><input type = 'button' value ='submit'></input><body></html>";
		 g.drawString(str, 50, 75);
	 }
	 
}

