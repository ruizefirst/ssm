package com.dsy.www.coding.senior.applet;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 14, 2017 10:18:10 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)  播放音频
 * @parameter
 * @since  
 * @return
 * 
 **/
public class AudioDemo extends Applet {
	 private AudioClip clip;
	   private AppletContext context;
	   public void init()
	   {
	      context = this.getAppletContext();
	      String audioURL = this.getParameter("audio");
	      if(audioURL == null)
	      {
	         audioURL = "default.au";
	      }
	      try
	      {
	         URL url = new URL(this.getDocumentBase(), audioURL);
	         clip = context.getAudioClip(url);
	      }catch(MalformedURLException e)
	      {
	         e.printStackTrace();
	         context.showStatus("Could not load audio file!");
	      }
	   }
	   public void start()
	   {
	      if(clip != null)
	      {
	         clip.loop();
	      }
	   }
	   public void stop()
	   {
	      if(clip != null)
	      {
	         clip.stop();
	      }
	   }

}

