package com.rebtel.codetest.testrunner.testsuites;

import com.rebtel.codetest.testrunner.annotations.Test;
import com.rebtel.codetest.testrunner.asserts.Asserts;

public class AdditionalTest {

    @Test(description = "A negative test case Int != Double")
    public void testIntIsDoubleExpectFailure() {
    	/*I changed the input a bit just to make the test case fail,
    	  so the output of the runner can be verified */
   		Asserts.assertNotEquals(
   				"Int", 
   				"Int", 
   				"Int should not be equal to Double");
    }

    @Test(description = "A positive test case String == String")
    public void testStringIsStringExpectSuccess() {
    	/*I changed the input a bit just to make the test case fail,
  	  	  so the output of the runner can be verified */    	
        Asserts.assertEquals(
        		"String", 
        		"String", 
        		"String should be equal to String");
    }

}
