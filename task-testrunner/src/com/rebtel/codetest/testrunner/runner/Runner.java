package com.rebtel.codetest.testrunner.runner;

import com.rebtel.codetest.testrunner.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * This class implements the logic of executing all "Test" methods in all
 * classes in a given package. 
 */

@TestRunner
public class Runner extends Logging{

	public static void run(String packageName) throws Exception 
	{
		int counterExecuted = 0, counterFailed = 0;
		
		ArrayList<Class> testsuites = TestRunnerUtils.getClasses(packageName);
		
		for(Class testsuite : testsuites) {
			Method[] testcases = testsuite.getMethods();	
			for (Method method : testcases) {
				if (method.isAnnotationPresent(Test.class)) {
					++counterExecuted;
					try {
						method.invoke(testsuite.newInstance());					
					} catch (Exception e) {
						Logging.log += "\n --- Results: FAILED: \n";
						String testDescription = 
								method.getAnnotation(Test.class).description();
						Logging.log += testDescription + "\n";
						String assertionMessage = e.getCause().toString();
						Logging.log += assertionMessage + "\n --- \n";
						++counterFailed;
					} 
				}
			}
		}
		Logging.log += "Tests run: " + counterExecuted + 
				", Failures: " + counterFailed;
	}	
	

}
