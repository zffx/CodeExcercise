package com.rebtel.codetest.testrunner.testsuites;

import com.rebtel.codetest.testrunner.annotations.Test;
import com.rebtel.codetest.testrunner.asserts.Asserts;

public class FooBarTest {

    @Test(description = "A negative test case Foo != Bar")
    public void testFooIsBarExpectFailure() {
    	/*I changed the input a bit just to make the test case fail,
    	  so the output of the runner can be verified */
   		Asserts.assertNotEquals("Foo", "Foo", "Foo should not be equal to Bar");
    }

    @Test(description = "A positive test case Foo == Foo")
    public void testFooIsFooExpectSuccess() {
    	/*I changed the input a bit just to make the test case fail,
  	  	  so the output of the runner can be verified */    	
        Asserts.assertEquals("Foo", "Bar", "Foo should be equal to Foo");
    }

}

