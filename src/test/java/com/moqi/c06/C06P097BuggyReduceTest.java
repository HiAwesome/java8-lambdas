package com.moqi.c06;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class C06P097BuggyReduceTest {

    @Test
    public void sample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int result = C06P097BuggyReduce.multiplyThrough(numbers);
        assertEquals(30, result);
    }

}
