package com.moqi.c05;

import java.util.HashMap;
import java.util.Map;

public class C05P085Fibonacci {

    private final Map<Integer, Long> cache;

    public C05P085Fibonacci() {
        cache = new HashMap<>();
        cache.put(0, 0L);
        cache.put(1, 1L);
    }

    public long fibonacci(int x) {
        return cache.computeIfAbsent(x, n -> fibonacci(n-1) + fibonacci(n-2));
    }

}
