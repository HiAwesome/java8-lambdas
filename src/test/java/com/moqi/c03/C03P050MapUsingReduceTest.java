package com.moqi.c03;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class C03P050MapUsingReduceTest {

    @Test
    public void emptyList() {
        assertMapped(Function.identity(), Collections.emptyList(), Collections.emptyList());
    }

    @Test
    public void identityMapsToItself() {
        assertMapped((Integer x) -> x, asList(1, 2, 3), asList(1, 2, 3));
    }

    @Test
    public void incrementingNumbers() {
        assertMapped((Integer x) -> x + 2, asList(1, 2, 3), asList(3, 4, 5));
    }

    private <I, O> void assertMapped(Function<I, O> mapper, List<I> input, List<O> expectedOutput) {
        List<O> output = C03P050MapUsingReduce.map(input.stream(), mapper);
        assertEquals(expectedOutput, output);

        List<O> parallelOutput = C03P050MapUsingReduce.map(input.parallelStream(), mapper);
        assertEquals(expectedOutput, parallelOutput);
    }

}
