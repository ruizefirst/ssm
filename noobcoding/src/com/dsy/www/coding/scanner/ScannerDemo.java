package com.dsy.www.coding.scanner;

import java.util.Scanner;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 11, 2017 9:48:07 AM
 * @version 1.0
 * @Description: TODO Scanner ����÷�
 * @parameter
 * @since  
 * @return
 * 
 * next��nextLine������
 * next()
 * 1��һ��Ҫ��ȡ����Ч�ַ���ſ��Խ�������
 * 2����������Ч�ַ�֮ǰ�����Ŀհף�next()�Ὣ���Զ�ȥ��
 * 3��ֻ��������Ч�ַ���Ž����������Ŀհ���Ϊ�ָ������߽�����
 * 4��next()���ܵõ����пո���ַ���
 * nextLine()
 * 1����EnterΪ��������Ҳ����˵nextLine()���ص�������س�֮ǰ�������ַ�
 * 2�����Ի�ÿհ�
 * 
 **/
public class ScannerDemo {
	
	public static void main(String args[]){
		
		/**--------------------------------------------*/
/*		Scanner s = new Scanner(System.in);
		//�Ӽ��̽�������
		
		//next��ʽ�����ַ���
		System.out.println("next ��ʽ���գ�");
		//�ж��Ƿ�������
		if(s.hasNext()){
			String str1 = s.next();
			System.out.println("��������Ϊ��"+str1);
		}*/
		/**--------------------------------------------*/
		
		/**--------------------------------------------*/
		//nextLine��ʽ�����ַ���
	/*	System.out.println("newLine��ʽ�����ַ�����");
		//�ж��Ƿ�������
		if(s.hasNextLine()){
			String st2 = s.nextLine();
			System.out.println("��������Ϊ��"+st2);
		}*/
		/**--------------------------------------------*/
		
		//���Ҫ���� int �� float ���͵����ݣ��� Scanner ����Ҳ��֧�֣�����������֮ǰ�����ʹ�� hasNextXxx() ����������֤����ʹ�� nextXxx() ����ȡ
		/**--------------------------------------------*/
		// �Ӽ��̽�������  
   /*     int i = 0 ;  
        float f = 0.0f ;  
        System.out.print("����������");  
        if(s.hasNextInt()){                 
      // �ж�������Ƿ�������  
            i = s.nextInt() ;                
      // ��������  
            System.out.println("�������ݣ�" + i) ;  
        }else{                                 
      // ����������Ϣ  
            System.out.println("����Ĳ���������") ;  
        }  
        System.out.print("����С����");  
        if(s.hasNextFloat()){              
      // �ж�������Ƿ���С��  
            f = s.nextFloat() ;             
      // ����С��  
            System.out.println("С�����ݣ�" + f) ;  
        }else{                                
      // ����������Ϣ  
            System.out.println("����Ĳ���С����") ;  
        }  */
        /**--------------------------------------------*/
        
        //���������֣��������ܺ���ƽ������ÿ����һ�������ûس�ȷ�ϣ�ͨ��������������������벢���ִ�н��
        /**--------------------------------------------*/
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        int m = 0;
        while(scan.hasNextDouble()){
        	double x = scan.nextDouble();
        	m = m + 1;
        	sum = sum + x;
        }
        System.out.println(m+"�����ĺͣ�"+sum);
        System.out.println(m+"������ƽ��ֵ��"+(sum/m));
        /**--------------------------------------------*/ 
	}

}

