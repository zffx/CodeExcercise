import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.rebtel.codetest.testrunner.runner.*;
import com.rebtel.codetest.testrunner.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main extends Log{

	public static void main(String[] args) throws Exception {

		/* 
		 * Here I assume that the class that I have implemented(Runner) can be
		 * used directly in main, instead of searching for all classes with 
		 * annotation "TestRunner" and iterating through them. 
		 * 
		 * If I am not allowed to use my class Runner directly here, please 
		 * check the commented code at the end of main() method. It will search 
		 * through a given package to find the class with annotation TestRunner, 
		 * and execute all test cases in a given package. Of course the scenario 
		 * can be extended based on requirements, e.g. we can feed in a list of 
		 * pairs <testRunnerPackage, testSuitesPackage>, and each test runner 
		 * will be found to run their associated test suites, you are welcome to 
		 * discuss with me about how the test runner should be used in main(). 
		 * I found other requirements of this task are very clear but this one 
		 * is a bit open. 
		 */
		
		String testSuitesPackage = "com.rebtel.codetest.testrunner.testsuites";
		Class testRunner = Runner.class;
		
		TestRunner annotation = 
				(TestRunner) testRunner.getAnnotation(TestRunner.class);
		
		Method method = 
				testRunner.getMethod(annotation.runMethodName(), String.class);
		Log.log = "Running test in \'" + 
				testSuitesPackage + "\'";
		method.invoke(
				testRunner.newInstance(), 
				testSuitesPackage);
		System.out.print(Log.log);
		
		/*The implementation below illustrates that the test runner class can
		 * also be found by searching a given package, so if the requirements 
		 * say that my "Runner" class cannot be used directly in main(), there 
		 * is still some way to make it work. It is only a demo, not all 
		 * logical concerns are considered. Extensions can be done easily to 
		 * adapt to further requirements. 
		 */
		/*
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
		}*/
		
	}
}
