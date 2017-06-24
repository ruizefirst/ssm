package com.dsy.www.coding.extend;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 12, 2017 2:32:43 PM
 * @version 1.0
 * @Description: TODO  extends  继承
 * @parameter
 * @since  
 * @return
 * 继承的特性：
 * 1、子类拥有父类非private 的属性和方法	，
 * 2、子类可以拥有自己的属性和方法，即子类可以对父类进行扩展
 * 3、子类可以用自己的方式实现父类，
 * 4、java的继承是单继承，但是可以多重继承（在 Java 中，类的继承是单一继承，也就是说，一个子类只能拥有一个父类，所以 extends 只能继承一个类），
 * 5、提高了类之间的耦合性（继承的缺点，耦合度高就会造成代码之间的联系）。
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
		System.out.println(name+"正在吃");
	}
	
	public void sleep(){
		System.out.println(name+"正在睡");
	}
	
	public void introduction(){
		System.out.println("大家好！我是"+ id+ "号"+ name+ ".");
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
	System.out.println(name+"正在吃");	
	}
	
	public void sleep(){
		System.out.println(name+"正在睡");
	}
	
	public void introduction(){
		System.out.println("大家好！我是"+id+"号"+name+".");
	}
	
	//以上两个类的代码存在重复，导致的后果就是代码量大且臃肿、而且维护性不高，所有要从根本上解决这两段代码的问题，就需要用继承，将两段代码相同的部分提取出来组成一个父类
	//优化以上代码如下：
	class  Animal{
		private String name;
		private int id;
		public Animal(String name,int id){
			this.name = name ;
			this.id = id;
		}
		public void eat(){
			System.out.println(name+"正在吃");
		}
		public void sleep(){
			System.out.println(name+"正在睡");
		}
		public void introduction(){
			System.out.println("大家好！我是"+id+"号"+name+".");
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

