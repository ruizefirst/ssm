package com.dsy.www.coding.interfaces;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 13, 2017 9:15:15 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)  接口说明
 * @parameter
 * @since  
 * @return
 * 
 **/
public class IntefacesDemo {
/**
 * 接口是一个抽象类型，是一个抽象方法的集合。一个类通过继承接口的方式来继承接口的抽象方法
 * 1、接口中的方法都为public abstract 即使不声明  也被隐式的声明为此类型
 * 2、接口中的变量都为public static final类型的 ，不声明也被隐式的声明为此类型
 * 3、接口支持多重继承，类只能是单继承
 * 4、接口没有构造函数，不能用于实例化对象，但是可以被实现类创建
 * 5、要实现一个接口，必须实现该接口中的所有方法，否则此类必须被声明为抽象类
 * 6、一个类只能继承一个类，但是能实现多个接口
 * 7、标识接口：不包含任何属性和方法的接口
 * 标记接口主要用于以下两种目的：
 * 1、建立一个公共的父接口
 * 	正如EventListener接口，这是由几十个其他接口扩展的Java API，你可以使用一个标记接口来建立一组接口的父接口。例如：当一个接口继承了EventListener接口，Java虚拟机(JVM)就知道该接口将要被用于一个事件的代理方案。
 * 2、向一个类添加数据类型
 *  这种情况是标记接口最初的目的，实现标记接口的类不需要定义任何接口方法(因为标记接口根本就没有方法)，但是该类通过多态性变成一个接口类型
 *
 * 
 * 
 * 
 * */
}

