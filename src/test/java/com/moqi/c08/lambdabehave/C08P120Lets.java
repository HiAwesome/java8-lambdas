package com.moqi.c08.lambdabehave;

public final class C08P120Lets {

    /**
     * 从 describe 方法开始定义规则
     */
    // BEGIN describe
    public static void describe(String name, C08P120Suite behavior) {
        C08P120Description description = new C08P120Description(name);
        behavior.specifySuite(description);
    }
    // END describe

}
