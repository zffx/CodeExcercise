package com.rebtel.codetest.testrunner.asserts;

public class Asserts {

	public static void assertNotEquals(
			final Object actual, 
			final Object expected, 
			String message) 
	{

		if (isEqual(actual, expected)) {
			if (message != null) {
				throw new AssertionError(message);
			}
			throw new AssertionError();			
		}
	}

	public static void assertEquals(
			final Object actual, 
			final Object expected, 
			String message) 
	{
		if (isEqual(actual, expected)) {
			return;
		} else if (message != null) {
			throw new AssertionError(message);
		} else {
			throw new AssertionError();
		}
	}
	
	private static boolean isEqual(final Object actual, final Object expected) {
		if (actual == null) {
			return expected == null;
		}
		return actual.equals(expected);
	}	
}
