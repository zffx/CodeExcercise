package com.rebtel.codetest.testrunner.annotations;

import java.lang.annotation.Retention;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Test {

    /**
     * Description of the test case which is annotated with @Test
     */
    public String description() default "";
}
