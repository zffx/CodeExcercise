package com.rebtel.codetest.testrunner.testsuites;

import com.rebtel.codetest.testrunner.annotations.Test;
import com.rebtel.codetest.testrunner.asserts.Asserts;

/**
 * This class is to add one more class and two test methods in the same package
 * of FooBarTest.java
 */
public class AdditionalTest {

	//This test case will FAIL
    @Test(description = "A negative test case Int != Double")
    public void testIntIsDoubleExpectFailure() {
   		Asserts.assertNotEquals(
   				"Int", 
   				"Int", 
   				"Int should not be equal to Double");
    }

    //This test case will PASS
    @Test(description = "A positive test case String == String")
    public void testStringIsStringExpectSuccess() { 	
        Asserts.assertEquals(
        		"String", 
        		"String", 
        		"String should be equal to String");
    }

}
