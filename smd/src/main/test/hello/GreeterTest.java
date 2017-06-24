package hello;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

//import org.hamcrest.CoreMatchers;
//import org.junit.Assert;
import org.junit.Test;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 22, 2017 11:02:01 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @parameter
 * @since  
 * @return
 * 
 **/
public class GreeterTest {
	private Greeter greeter = new Greeter();
	
	@Test
	public void gerrterSaysHello(){
		assertThat(greeter.sayHello(),containsString("Hello"));//静态导入   节省敲代码的工作量
		//Assert.assertThat(greeter.sayHello(),CoreMatchers.containsString("Hello"));//非静态导入
		//System.out.println(greeter.sayHello());
	}
}

