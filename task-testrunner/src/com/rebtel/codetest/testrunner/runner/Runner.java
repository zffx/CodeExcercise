package com.rebtel.codetest.testrunner.runner;

import com.rebtel.codetest.testrunner.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayList;

@TestRunner
public class Runner {

	public static void run(String packageName) throws Exception 
	{
		int counterExecuted = 0, counterFailed = 0;
		
		ArrayList<Class> testsuites = utils.getClasses(packageName);
		
		for(Class testsuite : testsuites) {
			//System.out.println(testsuite.getName());
			Method[] testcases = testsuite.getMethods();	
			for (Method method : testcases) {
				if (method.isAnnotationPresent(Test.class)) {
					++counterExecuted;
					try {
						method.invoke(testsuite.newInstance());					
					} catch (Exception e) {
						String testDescription = 
								method.getAnnotation(Test.class).description();
						System.out.println(testDescription);
						String assertionMessage = e.getCause().toString();
						System.out.println(assertionMessage);
						++counterFailed;
					} 
				}
			}
		}
	}	
	

}
