package com.rebtel.codetest.testrunner.annotations;

import java.lang.annotation.Retention;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface TestRunner {

    /**
     * Declares which method should be used as test-runner entry point.
     * The method must take a single parameter of type String, which will
     * be a package name, for which tests in that package shall be run.
     */
    public String runMethodName() default "run";

}