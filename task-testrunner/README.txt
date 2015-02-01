
The task is to implement a small test runner, which can be used to run
test cases which have been annotated with Java Annotations.

The test runner itself should be annotated using
com.rebtel.codetest.testrunner.annotations.TestRunner.

Methods implementing test cases are annotated with
com.rebtel.codetest.testrunner.annotations.Test. 
For an example of a class containing annotated test methods, please
see the file FooBarTest.java.

When your test runner's entry point method is invoked, all annotated
test methods should be run, and output according the following
criteria:

1. If a test case fails, the test case name and failure cause should
be printed.

2. At the end, there should be a summary indicating the total number
of tests that was run, and number of failures.

Example:

  Running tests in 'com.some.package' --- Results: FAILED: A positive
  test case Foo == Foo java.lang.AssertionError: Foo should be equal
  to Foo --- Tests run: N, Failures: X




Assumptions:

The source must compile for Java 7, i.e. for language version "1.7".

The test runner entry point (declared with the TestRunner annotation),
will be invoked with one parameter, a package name.  You may assume
that all classes on the class path which belong to that package have
been loaded by the current class loader.


Restrictions:

No external dependencies may be used at runtime.



