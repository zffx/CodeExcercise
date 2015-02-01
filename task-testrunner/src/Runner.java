import com.rebtel.codetest.testrunner.annotations.*;
import com.rebtel.codetest.testrunner.FooBarTest;
import java.lang.reflect.Method;

//@TestRunner
public class Runner {

	public static void main(String[] args) throws Exception {
		
		FooBarTest testsuite = new FooBarTest();
		Method[] methods = testsuite.getClass().getMethods();
		
		for (Method method : methods) {
			if (method.isAnnotationPresent(Test.class)) {
				try {
					method.invoke(testsuite);
				} catch (Exception e) {
					String assertionMessage = e.getCause().toString();
					System.out.println(assertionMessage);
				} 
			}
		}

	}

}
