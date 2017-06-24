package com.dsy.www.coding.senior.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 13, 2017 10:43:17 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)  java2出现了  集合框架  （在java.util包中）
 * @parameter
 * @since  
 * @return
 * java2集合框架出现解决的问题：
 * 1、该框架必须是高性能的。基本集合（动态数组，链表，树，哈希表）的实现也必须是高效的
 * 2、该框架允许不同类型的集合，以类似的方式工作，具有高度的互操作性
 * 3、对一个集合的扩展和适应必须是简单的
 * 
 * 
 * 所有的集合框架都包含以下内容：
 * 1、接口：代表集合的抽象类型。接口允许集合独立操纵其代表的细节。接口 通常形成一个层次
 * 2、实现类：是集合接口的具体实现。从本质上讲，它们是可重复使用的数据结构。
 * 3、算法：是实现集合接口的对象里方法执行的一些有用计算，例如：搜索和排序。这些算法被称为多态，是应为相同的方法可以在相似的接口上有着不同的实现
 * 
 * 
 * 
 * List  有序可重复  通过索引访问
 * Set  具有与Collenction完全一样的接口，只是行为上不同，Set不保存重复的元素（无序不重复 不能通过索引访问）
 * SortedSet  继承与Set保存有序的集合
 * Map  将唯一的键映射到值
 * Map.Entry 描述在一个Map中的一个元素（键/值对）。是一个map的内部类
 * SortedMap 继承于Map，使Key保持在升序排列
 * Enumeration   这是一个传统的接口和定义的方法，通过它可以枚举（一次获得一个）对象集合中的元素。这个传统接口已被迭代器取代。
 * 
 * 
 * 
 * 
 * -----------------------
 * 
 * Set和List的区别：
 * 1、Set存储无序、不重复数据。List存储有序、可重复数据。
 * 2、Set检索效率低，删除和插入效率高，插入和删除不会引起元素位置改变<实现类由HashSet，TreeSet>。
 * 3、List和数组类似，可以动态增长，根据实际存储的数据长度自动增长list的长度。查找元素效率高，插入删除效率低，
 * 因为会引起其他元素位置的改变<实现类由ArrayList，LinkedList,Vector>
 * 
 * 
 * 
 * 标准集合类的介绍:
 * LinkedList:该类实现了List接口，允许有null（空）元素。主要用于创建链表数据结构，
 * 该类没有同步方法，如果多线程同时访问一个List，则必须自己实现访问同步，解决方法就是在创建List的时候构造一个同步的List 比如：
 * List list = Collections.synchronizedList(new LinkedList(...));
 * LinkedList查找效率低。
 * -----------------
 * ArrayList：该类也是实现了List接口，实现了可变大小的数组，随机访问和遍历元素时，提供更好的性能。
 * 该类也是非同步的，在多线程的情况下不要使用。ArrayList增长当前长度的50%，插入删除效率低。
 * 
 * -----------------
 * HashMap :是一个散列表，它存储的内容是键值对（key-value）映射。
 * 该类实现了Map的接口，根据键的HashCode值存储数据，具有很快的访问速度，最多允许一条记录的键为null,不支持线程同步。
 * （允许有null键，不支持同步）
 * 
 * -----------------
 * TreeMap ：继承了AbstractMap，并且使用一棵树。
 * 
 * -----------------
 * Vector:该类和ArrayList非常相似，但是该类是同步的，可以用在多线程的情况，该类允许设置默认的增长长度，默认扩容方式是原来的2倍。
 * （ArrayList相似、同步、默认扩容为原来2倍（允许自己设定））
 * 
 * -----------------
 * Stack 栈是Vector的一个子类，它实现了一个标准的后进先出的栈
 * 
 * -----------------
 * Dictionary 类是一个抽象类，用来存储键值对，作用和Map类相似。
 * ----------------
 * Hashtable :是Dictionary（字典）类的一个子类，位于java.util包中。
 * 
 * ---------------
 * Properties:继承与Hashtable,标识一个持久的属性集，属性列表中每个键及其对应的值都是一个字符串。
 * 
 * --------------
 * BitSet：一个Bitset类穿件一种特殊类型的数组保存位值。BitSit中数组大小会随需要增加。
 * 
 * 
 * 
 **/
public class CollectionsDemo {

}

//遍历ArrayList
class Test1{
	public static void main(String args[]){
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("World");
		list.add("HAHAHAHA");
		//第一种遍历使用foreach遍历list  for循环  及for循环增强
		for(String str:list){
			System.out.println(str);
		}
		
		//第二种遍历，把链表变成数组相关的内容进行遍历
		String[] strArray = new String[list.size()];
		list.toArray(strArray);
		for(int i = 0 ;i<strArray.length;i++){
			System.out.println(strArray[i]);
		}
		
		//第三种遍历  使用迭代器进行相关遍历
		
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
	}
}

//遍历Map
class Test2{
	public static void main(String args[]){
		Map<String,String> map = new HashMap<String,String>();
		map.put("1","value1");
		map.put("2","value2");
		map.put("3","vlaue3");
		
		//第一种：普遍使用，二次取值
		System.out.println("通过Map.keySet遍历key和value：");
		for(String key:map.keySet()){
			System.out.println("key="+key+"and value="+map.get(key));
		}
		
		//第二种
		System.out.println("通过Map.entrySet使用iterator遍历key和value：");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			System.out.println("key="+entry.getKey()+"and value = "+entry.getValue());
		}
		
		//第三种 ：推荐 ，尤其是容量大时
		System.out.println("通过Map.entrySet遍历key和value");
		for(Map.Entry<String,String> entry:map.entrySet()){
			System.out.println("key="+entry.getKey()+"and value ="+entry.getValue());
		}
		
		//第四种
		System.out.println("通过Map.values()遍历所有value,但不能遍历key");
		for(String str:map.values()){
				System.out.println("value="+str);
		}
			
	}
}

