package com.dsy.www.coding.extend;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 12, 2017 2:32:43 PM
 * @version 1.0
 * @Description: TODO  extends  �̳�
 * @parameter
 * @since  
 * @return
 * �̳е����ԣ�
 * 1������ӵ�и����private �����Ժͷ���	��
 * 2���������ӵ���Լ������Ժͷ�������������ԶԸ��������չ
 * 3������������Լ��ķ�ʽʵ�ָ��࣬
 * 4��java�ļ̳��ǵ��̳У����ǿ��Զ��ؼ̳У��� Java �У���ļ̳��ǵ�һ�̳У�Ҳ����˵��һ������ֻ��ӵ��һ�����࣬���� extends ֻ�ܼ̳�һ���ࣩ��
 * 5���������֮�������ԣ��̳е�ȱ�㣬��϶ȸ߾ͻ���ɴ���֮�����ϵ����
 * 
 * 
 **/
public class ExtendsDemo {
	

}
class Penguin{
	private String name;
	private int id;
	public Penguin(String name,int id){
		this.name = name;
		this.id = id;
	}
	
	public void eat(){
		System.out.println(name+"���ڳ�");
	}
	
	public void sleep(){
		System.out.println(name+"����˯");
	}
	
	public void introduction(){
		System.out.println("��Һã�����"+ id+ "��"+ name+ ".");
	}
	
}

class Mouse{
	private String name;
	private int id;
	public Mouse(String name,int id){
		this.name = name;
		this.id = id;
	}
	public void eat(){
	System.out.println(name+"���ڳ�");	
	}
	
	public void sleep(){
		System.out.println(name+"����˯");
	}
	
	public void introduction(){
		System.out.println("��Һã�����"+id+"��"+name+".");
	}
	
	//����������Ĵ�������ظ������µĺ�����Ǵ���������ӷ�ס�����ά���Բ��ߣ�����Ҫ�Ӹ����Ͻ�������δ�������⣬����Ҫ�ü̳У������δ�����ͬ�Ĳ�����ȡ�������һ������
	//�Ż����ϴ������£�
	class  Animal{
		private String name;
		private int id;
		public Animal(String name,int id){
			this.name = name ;
			this.id = id;
		}
		public void eat(){
			System.out.println(name+"���ڳ�");
		}
		public void sleep(){
			System.out.println(name+"����˯");
		}
		public void introduction(){
			System.out.println("��Һã�����"+id+"��"+name+".");
		}
		
	}
	
	class Penguin1 extends Animal{
		
		public Penguin1(String name, int id) {
			super(name, id);
			// TODO Auto-generated constructor stub
		}
		
	}
	class Mouse1 extends Animal{
		public Mouse1(String name, int id) {
			super(name, id);
			// TODO Auto-generated constructor stub
		}
	}	
}

