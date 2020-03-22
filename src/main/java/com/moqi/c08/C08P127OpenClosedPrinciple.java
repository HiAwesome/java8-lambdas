package com.moqi.c08;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class C08P127OpenClosedPrinciple {

    public void asHigherOrderFunctions() {
        // BEGIN local_formatter
        // One implementation
        // 实现
        ThreadLocal<DateFormat> localFormatter
                = ThreadLocal.withInitial(SimpleDateFormat::new);

        // Usage
        // 使用
        DateFormat formatter = localFormatter.get();
        // END local_formatter

        // BEGIN local_thread_id
        // Or...
        // 或者这样实现
        AtomicInteger threadId = new AtomicInteger();
        ThreadLocal<Integer> localId
                = ThreadLocal.withInitial(threadId::getAndIncrement);

        // Usage
        // 使用
        int idForThisThread = localId.get();
        // END local_thread_id
    }


}
