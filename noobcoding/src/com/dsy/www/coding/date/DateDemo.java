package com.dsy.www.coding.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 8, 2017 9:06:46 PM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)
 * @parameter
 * @since  
 * @return
 * 
 **/
public class DateDemo {
	public static void main(String args[]){
		Date d = new Date();
		Date t = (Date) d.clone();
		System.out.println(t);
		
		int bo  = d.compareTo(t);
		boolean bt = d.after(t);
		boolean bb = d.before(t);
		Long lon =t.getTime();
		int ct = d.hashCode();
		String stt = d.toString();
		System.out.println(d+"---"+t+"---");
		System.out.println(bo+"--"+bt+"--"+bb+"--"+lon+"--"+ct+"--"+stt+"--");
		
		//�Ƚ���������  ���ַ���
		//ʹ��getTime()������ȡ��������(��1970��1��1�վ����ĺ�����ֵ),Ȼ��Ƚ�������ֵ
		//ʹ�÷���before(),after()��equals()�����磺һ���µ�12�ű�18���磬��new Date(99,2,12).before(new Date(99,2,18))����true
		//ʹ��compareTo()������������Comparable�ӿڶ���ģ�Date��ʵ��������ӿ�
		
		
		//SimpleDateFormat ������ѡ���κ��û���������ڸ�ʽ�����С�
		Date dNow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println("Current Date:"+sdf.format(dNow));
		
		System.out.println("--------------���Ƿָ���-----------------");
		
		 // ��ʼ�� Date ����
	     Date date = new Date();
	     //c��ʹ��  
	    System.out.printf("ȫ�����ں�ʱ����Ϣ��%tc%n",date);          
	    //f��ʹ��  
	    System.out.printf("��-��-�ո�ʽ��%tF%n",date);  
	    //d��ʹ��  
	    System.out.printf("��/��/���ʽ��%tD%n",date);  
	    //r��ʹ��  
	    System.out.printf("HH:MM:SS PM��ʽ��12ʱ�ƣ���%tr%n",date);  
	    //t��ʹ��  
	    System.out.printf("HH:MM:SS��ʽ��24ʱ�ƣ���%tT%n",date);  
	    //R��ʹ��  
	    System.out.printf("HH:MM��ʽ��24ʱ�ƣ���%tR",date);  
	    
	    System.out.println("-----------------���Ƿָ���-------------------");
	    Date dateD=new Date();                                      
        //b��ʹ�ã��·ݼ��  
        String str=String.format(Locale.US,"Ӣ���·ݼ�ƣ�%tb",dateD);       
        System.out.println(str);                                                                              
        System.out.printf("�����·ݼ�ƣ�%tb%n",dateD);  
        //B��ʹ�ã��·�ȫ��  
        str=String.format(Locale.US,"Ӣ���·�ȫ�ƣ�%tB",dateD);  
        System.out.println(str);  
        System.out.printf("�����·�ȫ�ƣ�%tB%n",dateD);  
        //a��ʹ�ã����ڼ��  
        str=String.format(Locale.US,"Ӣ�����ڵļ�ƣ�%ta",dateD);  
        System.out.println(str);  
        //A��ʹ�ã�����ȫ��  
        System.out.printf("�������ڵļ�ƣ�%tA%n",dateD);  
        //C��ʹ�ã���ǰ��λ  
        System.out.printf("���ǰ��λ���֣�������λǰ�油0����%tC%n",dateD);  
        //y��ʹ�ã������λ  
        System.out.printf("��ĺ���λ���֣�������λǰ�油0����%ty%n",dateD);  
        //j��ʹ�ã�һ�������  
        System.out.printf("һ���е�����������ĵڼ��죩��%tj%n",dateD);  
        //m��ʹ�ã��·�  
        System.out.printf("��λ���ֵ��·ݣ�������λǰ�油0����%tm%n",dateD);  
        //d��ʹ�ã��գ���λ���������㣩  
        System.out.printf("��λ���ֵ��գ�������λǰ�油0����%td%n",dateD);  
        //e��ʹ�ã��գ�һλ�����㣩  
        System.out.printf("�·ݵ��գ�ǰ�治��0����%te",dateD);  

		
	    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	    String input = args.length==0?"1818-11-11":args[0];
	    System.out.println(input+"Parses as ");
	    Date dd;
	    try{
	    	dd = sd.parse(input);
	    	System.out.println(dd);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    
	}

}

