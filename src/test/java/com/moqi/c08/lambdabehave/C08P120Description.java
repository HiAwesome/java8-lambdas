package com.moqi.c08.lambdabehave;

import com.moqi.c08.lambdabehave.expectations.C08P120Expect;

public final class C08P120Description {

    private final String suite;

    C08P120Description(String suite) {
        this.suite = suite;
    }

    /**
     * 将用 Lambda 表达式表示的规则传入 should 方法
     */
    // BEGIN should
    public void should(String description, C08P120Specification specification) {
        try {
            C08P120Expect expect = new C08P120Expect();
            specification.specifyBehaviour(expect);
            C08P120Runner.current.recordSuccess(suite, description);
        } catch (AssertionError cause) {
            C08P120Runner.current.recordFailure(suite, description, cause);
        } catch (Throwable cause) {
            C08P120Runner.current.recordError(suite, description, cause);
        }
    }
    // END should

}
