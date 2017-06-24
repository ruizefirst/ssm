package hello;

import org.joda.time.LocalTime;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 22, 2017 10:13:52 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @parameter
 * @since  
 * @return
 * 
 **/
public class HelloWorld {
	public static void main(String[] args) {
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);
		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());
    }

}

