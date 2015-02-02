package com.rebtel.codetest.testrunner.testsuites;

import com.rebtel.codetest.testrunner.annotations.Test;
import com.rebtel.codetest.testrunner.asserts.Asserts;

public class FooBarTest {

	//This test case will FAIL
    @Test(description = "A negative test case Foo != Bar")
    public void testFooIsBarExpectFailure() {
   		Asserts.assertNotEquals("Foo", "Foo", "Foo should not be equal to Bar");
    }

	//This test case will FAIL
    @Test(description = "A positive test case Foo == Foo")
    public void testFooIsFooExpectSuccess() {
        Asserts.assertEquals("Foo", "Bar", "Foo should be equal to Foo");
    }

}

