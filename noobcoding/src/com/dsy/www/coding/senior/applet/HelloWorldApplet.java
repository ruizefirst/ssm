package com.dsy.www.coding.senior.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 14, 2017 10:01:04 AM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)
 * @parameter
 * @since  
 * @return
 * Applet ��һ�� Java ������һ��������֧�� Java �� Web ������ڡ���Ϊ���������� Java API֧��,����Applet ��һ��ȫ���ܵ� Java Ӧ�ó���
 * Applet ���е��ĸ����������ṩ��һ����ܣ�������ٸÿ���Ͽ���С����
 * 	1��init: �÷�����Ŀ����Ϊ��� Applet �ṩ������κγ�ʼ������ Applet ����ڵ� param ��ǩ���������ø÷�����
 *  2��start: ��������� init �����󣬸÷������Զ����á�ÿ���û�������ҳ�淵�ص����� Applet ��ҳ��ʱ������ø÷�����
 *  3��stop: ���û��Ӱ��� Applet ��ҳ���Ƴ���ʱ�򣬸÷����Զ������á���ˣ���������ͬ�� Applet �з������ø÷�����
 *  4��destroy: �˷�����������������ر�ʱ���á���Ϊ Applet ֻ���� HTML ��ҳ����Ч�������㲻Ӧ�����û��뿪���� Applet ��ҳ�����©�κ���Դ
 *  5��paint: �÷����� start() ����֮�����������ã������� Applet ��Ҫ�ػ����������ʱ����á�paint() ����ʵ���ϼ̳��� java.awt��
 * 
 **/
public class HelloWorldApplet extends Applet {//С���� demo
	 public static void main(String args[]){
		 
	 }
	 public void paint(Graphics g){
		 g.drawString("Hello World", 25, 50);
		 String str = "<html><head><head><body><input type = 'button' value ='submit'></input><body></html>";
		 g.drawString(str, 50, 75);
	 }
	 
}

