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
	
	/* reference implementation */
	/*
	static public void assertNotEquals(String message, Object unexpected,
			Object actual) {
		if (equalsRegardingNull(unexpected, actual)) {
			failEquals(message, actual);
		}
	}

	private static void failEquals(String message, Object actual) {
		String formatted = "Values should be different. ";
		if (message != null) {
			formatted = message + ". ";
		}
		formatted += "Actual: " + actual;
		fail(formatted);
	}

	static public void assertEquals(
			String message, 
			Object expected, 
			Object actual) 
	{
		if (equalsRegardingNull(expected, actual)) {
			return;
		} else if (expected instanceof String && actual instanceof String) {
			String cleanMessage = message == null ? "" : message;
			throw new ComparisonFailure(cleanMessage, (String) expected,
					(String) actual);
		} else {
			failNotEquals(message, expected, actual);
		}
	}

	private static boolean equalsRegardingNull(Object expected, Object actual) {
		if (expected == null) {
			return actual == null;
		}
		return isEquals(expected, actual);
	}

	private static boolean isEquals(Object expected, Object actual) {
		return expected.equals(actual);
	}

	static private void failNotEquals(String message, Object expected,
			Object actual) {
		fail(format(message, expected, actual));
	}

	static public void fail(String message) {
		if (message == null) {
			throw new AssertionError();
		}
		throw new AssertionError(message);
	}

	static String format(String message, Object expected, Object actual) {
		String formatted = "";
		if (message != null && !message.equals("")) {
			formatted = message + " ";
		}
		String expectedString = String.valueOf(expected);
		String actualString = String.valueOf(actual);
		if (expectedString.equals(actualString)) {
			return formatted + "expected: "
					+ formatClassAndValue(expected, expectedString)
					+ " but was: " + formatClassAndValue(actual, actualString);
		} else {
			return formatted + "expected:<" + expectedString + "> but was:<"
					+ actualString + ">";
		}
	}

	private static String formatClassAndValue(Object value, String valueString) {
		String className = value == null ? "null" : value.getClass().getName();
		return className + "<" + valueString + ">";
	}	
	*/
}
