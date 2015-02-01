import java.util.ArrayList;

import com.rebtel.codetest.testrunner.runner.*;
import com.rebtel.codetest.testrunner.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception {
		String testRunnerPackage = "com.rebtel.codetest.testrunner.runner";		
		String testSuitesPackage = "com.rebtel.codetest.testrunner.testsuites";
		
		ArrayList<Class> classes = 
				utils.getClasses(testRunnerPackage);
		
		for(Class testrunner : classes) {
			if (testrunner.isAnnotationPresent(TestRunner.class)) {
				TestRunner annotation = 
						(TestRunner) testrunner.getAnnotation(TestRunner.class);
		
				String methodNameStr = annotation.runMethodName();
				
				Method method = 
						testrunner.getMethod(methodNameStr, String.class);
				method.invoke(
						testrunner.newInstance(), 
						testSuitesPackage);
			}
		}
	}
}
