package hello;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

//import org.hamcrest.CoreMatchers;
//import org.junit.Assert;
import org.junit.Test;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 22, 2017 11:02:01 AM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)
 * @parameter
 * @since  
 * @return
 * 
 **/
public class GreeterTest {
	private Greeter greeter = new Greeter();
	
	@Test
	public void gerrterSaysHello(){
		assertThat(greeter.sayHello(),containsString("Hello"));//��̬����   ��ʡ�ô���Ĺ�����
		//Assert.assertThat(greeter.sayHello(),CoreMatchers.containsString("Hello"));//�Ǿ�̬����
		//System.out.println(greeter.sayHello());
	}
}

