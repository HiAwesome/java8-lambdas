package com.moqi.c06;

import java.util.stream.IntStream;

public class C06P097SerialToParallel {

    public static int sumOfSquares(IntStream range) {
        return range.parallel()
                    .map(x -> x * x)
                    .sum();
    }

    public static int sequentialSumOfSquares(IntStream range) {
        return range.map(x -> x * x)
                    .sum();
    }

}
