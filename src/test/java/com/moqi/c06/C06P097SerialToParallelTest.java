package com.moqi.c06;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C06P097SerialToParallelTest {

    @Test
    public void testSerialToParallel() {
        IntStream range = IntStream.range(0, 100);
        assertEquals(328350, C06P097SerialToParallel.sumOfSquares(range));
    }

}
