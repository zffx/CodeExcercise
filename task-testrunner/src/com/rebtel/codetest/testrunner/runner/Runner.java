package com.rebtel.codetest.testrunner.runner;

import com.rebtel.codetest.testrunner.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayList;

@TestRunner
public class Runner extends Log{

	public static void run(String packageName) throws Exception 
	{
		int counterExecuted = 0, counterFailed = 0;
		
		ArrayList<Class> testsuites = Utils.getClasses(packageName);
		
		for(Class testsuite : testsuites) {
			Method[] testcases = testsuite.getMethods();	
			for (Method method : testcases) {
				if (method.isAnnotationPresent(Test.class)) {
					++counterExecuted;
					try {
						method.invoke(testsuite.newInstance());					
					} catch (Exception e) {
						Log.log += "\n --- Results: FAILED: \n";
						String testDescription = 
								method.getAnnotation(Test.class).description();
						Log.log += testDescription + "\n";
						String assertionMessage = e.getCause().toString();
						Log.log += assertionMessage + "\n --- \n";
						++counterFailed;
					} 
				}
			}
		}
		Log.log += "Tests run: " + counterExecuted + 
				", Failures: " + counterFailed;
	}	
	

}
