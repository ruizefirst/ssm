package com.dsy.www.coding.senior.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 13, 2017 10:43:17 AM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)  java2������  ���Ͽ��  ����java.util���У�
 * @parameter
 * @since  
 * @return
 * java2���Ͽ�ܳ��ֽ�������⣺
 * 1���ÿ�ܱ����Ǹ����ܵġ��������ϣ���̬���飬����������ϣ����ʵ��Ҳ�����Ǹ�Ч��
 * 2���ÿ������ͬ���͵ļ��ϣ������Ƶķ�ʽ���������и߶ȵĻ�������
 * 3����һ�����ϵ���չ����Ӧ�����Ǽ򵥵�
 * 
 * 
 * ���еļ��Ͽ�ܶ������������ݣ�
 * 1���ӿڣ������ϵĳ������͡��ӿ������϶�������������ϸ�ڡ��ӿ� ͨ���γ�һ�����
 * 2��ʵ���ࣺ�Ǽ��Ͻӿڵľ���ʵ�֡��ӱ����Ͻ��������ǿ��ظ�ʹ�õ����ݽṹ��
 * 3���㷨����ʵ�ּ��ϽӿڵĶ����﷽��ִ�е�һЩ���ü��㣬���磺������������Щ�㷨����Ϊ��̬����ӦΪ��ͬ�ķ������������ƵĽӿ������Ų�ͬ��ʵ��
 * 
 * 
 * 
 * List  ������ظ�  ͨ����������
 * Set  ������Collenction��ȫһ���Ľӿڣ�ֻ����Ϊ�ϲ�ͬ��Set�������ظ���Ԫ�أ������ظ� ����ͨ���������ʣ�
 * SortedSet  �̳���Set��������ļ���
 * Map  ��Ψһ�ļ�ӳ�䵽ֵ
 * Map.Entry ������һ��Map�е�һ��Ԫ�أ���/ֵ�ԣ�����һ��map���ڲ���
 * SortedMap �̳���Map��ʹKey��������������
 * Enumeration   ����һ����ͳ�ĽӿںͶ���ķ�����ͨ��������ö�٣�һ�λ��һ�������󼯺��е�Ԫ�ء������ͳ�ӿ��ѱ�������ȡ����
 * 
 * 
 * 
 * 
 * -----------------------
 * 
 * Set��List������
 * 1��Set�洢���򡢲��ظ����ݡ�List�洢���򡢿��ظ����ݡ�
 * 2��Set����Ч�ʵͣ�ɾ���Ͳ���Ч�ʸߣ������ɾ����������Ԫ��λ�øı�<ʵ������HashSet��TreeSet>��
 * 3��List���������ƣ����Զ�̬����������ʵ�ʴ洢�����ݳ����Զ�����list�ĳ��ȡ�����Ԫ��Ч�ʸߣ�����ɾ��Ч�ʵͣ�
 * ��Ϊ����������Ԫ��λ�õĸı�<ʵ������ArrayList��LinkedList,Vector>
 * 
 * 
 * 
 * ��׼������Ľ���:
 * LinkedList:����ʵ����List�ӿڣ�������null���գ�Ԫ�ء���Ҫ���ڴ����������ݽṹ��
 * ����û��ͬ��������������߳�ͬʱ����һ��List��������Լ�ʵ�ַ���ͬ����������������ڴ���List��ʱ����һ��ͬ����List ���磺
 * List list = Collections.synchronizedList(new LinkedList(...));
 * LinkedList����Ч�ʵ͡�
 * -----------------
 * ArrayList������Ҳ��ʵ����List�ӿڣ�ʵ���˿ɱ��С�����飬������ʺͱ���Ԫ��ʱ���ṩ���õ����ܡ�
 * ����Ҳ�Ƿ�ͬ���ģ��ڶ��̵߳�����²�Ҫʹ�á�ArrayList������ǰ���ȵ�50%������ɾ��Ч�ʵ͡�
 * 
 * -----------------
 * HashMap :��һ��ɢ�б����洢�������Ǽ�ֵ�ԣ�key-value��ӳ�䡣
 * ����ʵ����Map�Ľӿڣ����ݼ���HashCodeֵ�洢���ݣ����кܿ�ķ����ٶȣ��������һ����¼�ļ�Ϊnull,��֧���߳�ͬ����
 * ��������null������֧��ͬ����
 * 
 * -----------------
 * TreeMap ���̳���AbstractMap������ʹ��һ������
 * 
 * -----------------
 * Vector:�����ArrayList�ǳ����ƣ����Ǹ�����ͬ���ģ��������ڶ��̵߳������������������Ĭ�ϵ��������ȣ�Ĭ�����ݷ�ʽ��ԭ����2����
 * ��ArrayList���ơ�ͬ����Ĭ������Ϊԭ��2���������Լ��趨����
 * 
 * -----------------
 * Stack ջ��Vector��һ�����࣬��ʵ����һ����׼�ĺ���ȳ���ջ
 * 
 * -----------------
 * Dictionary ����һ�������࣬�����洢��ֵ�ԣ����ú�Map�����ơ�
 * ----------------
 * Hashtable :��Dictionary���ֵ䣩���һ�����࣬λ��java.util���С�
 * 
 * ---------------
 * Properties:�̳���Hashtable,��ʶһ���־õ����Լ��������б���ÿ���������Ӧ��ֵ����һ���ַ�����
 * 
 * --------------
 * BitSet��һ��Bitset�ഩ��һ���������͵����鱣��λֵ��BitSit�������С������Ҫ���ӡ�
 * 
 * 
 * 
 **/
public class CollectionsDemo {

}

//����ArrayList
class Test1{
	public static void main(String args[]){
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("World");
		list.add("HAHAHAHA");
		//��һ�ֱ���ʹ��foreach����list  forѭ��  ��forѭ����ǿ
		for(String str:list){
			System.out.println(str);
		}
		
		//�ڶ��ֱ�������������������ص����ݽ��б���
		String[] strArray = new String[list.size()];
		list.toArray(strArray);
		for(int i = 0 ;i<strArray.length;i++){
			System.out.println(strArray[i]);
		}
		
		//�����ֱ���  ʹ�õ�����������ر���
		
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
	}
}

//����Map
class Test2{
	public static void main(String args[]){
		Map<String,String> map = new HashMap<String,String>();
		map.put("1","value1");
		map.put("2","value2");
		map.put("3","vlaue3");
		
		//��һ�֣��ձ�ʹ�ã�����ȡֵ
		System.out.println("ͨ��Map.keySet����key��value��");
		for(String key:map.keySet()){
			System.out.println("key="+key+"and value="+map.get(key));
		}
		
		//�ڶ���
		System.out.println("ͨ��Map.entrySetʹ��iterator����key��value��");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			System.out.println("key="+entry.getKey()+"and value = "+entry.getValue());
		}
		
		//������ ���Ƽ� ��������������ʱ
		System.out.println("ͨ��Map.entrySet����key��value");
		for(Map.Entry<String,String> entry:map.entrySet()){
			System.out.println("key="+entry.getKey()+"and value ="+entry.getValue());
		}
		
		//������
		System.out.println("ͨ��Map.values()��������value,�����ܱ���key");
		for(String str:map.values()){
				System.out.println("value="+str);
		}
			
	}
}

