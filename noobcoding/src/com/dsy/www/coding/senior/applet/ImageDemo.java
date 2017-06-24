package com.dsy.www.coding.senior.applet;

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 14, 2017 10:17:20 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)  显示图片
 * @parameter
 * @since  
 * @return
 * 
 **/
public class ImageDemo extends Applet{
	private Image image;
	  private AppletContext context;
	  public void init()
	  {
	      context = this.getAppletContext();
	      String imageURL = this.getParameter("image");
	      if(imageURL == null)
	      {
	         imageURL = "java.jpg";
	      }
	      try
	      {
	         URL url = new URL(this.getDocumentBase(), imageURL);
	         image = context.getImage(url);
	      }catch(MalformedURLException e)
	      {
	         e.printStackTrace();
	         // Display in browser status bar
	         context.showStatus("Could not load image!");
	      }
	   }
	   public void paint(Graphics g)
	   {
	      context.showStatus("Displaying image");
	      g.drawImage(image, 0, 0, 200, 84, null);
	      g.drawString("www.javalicense.com", 35, 100);
	   } 

}

