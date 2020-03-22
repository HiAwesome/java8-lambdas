package com.moqi.c04;

import java.util.function.Supplier;

public class C04P053Logger {

    @SuppressWarnings("FieldCanBeLocal")
    private final boolean debug = true;

    public boolean isDebugEnabled() {
        return debug;
    }

    public void debug(String message) {
        if (isDebugEnabled()) {
            System.out.println(message);
        }
    }

    /**
     * 使用 isDebugEnabled 方法降低日志性能开销
     */
    public void example() {
        // BEGIN debug_optimised
        C04P053Logger logger = new C04P053Logger();
        if (logger.isDebugEnabled()) {
            logger.debug("Look at this: " + expensiveOperation());
        }
        // END debug_optimised
    }

    private String expensiveOperation() {
        return "";
    }

    /**
     * 启用 Lambda 表达式实现的日志记录器
     */
    public void debug(Supplier<String> message) {
        // BEGIN debug_lambda
        if (isDebugEnabled()) {
            debug(message.get());
        }
        // END debug_lambda
    }

    /**
     * 使用 Lambda 表达式简化日志代码
     */
    public void exampleWithLambda() {
        // BEGIN debug_optimised_lambda
        C04P053Logger logger = new C04P053Logger();
        logger.debug(() -> "Look at this: " + expensiveOperation());
        // END debug_optimised_lambda
    }

}
