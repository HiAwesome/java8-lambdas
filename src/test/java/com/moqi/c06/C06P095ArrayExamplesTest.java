package com.moqi.c06;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@RunWith(value = Parameterized.class)
public class C06P095ArrayExamplesTest {

    private final int size;
    private final double[] output;

    public C06P095ArrayExamplesTest(int size, double[] output) {
        this.size = size;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {0, new double[]{}},
                {2, new double[]{0, 1}},
                {4, new double[]{0, 1, 2, 3}}
        };
        return Arrays.asList(data);
    }

    @Test
    public void parallel() {
        assertArrayEquals(output, C06P095ArrayExamples.parallelInitialize(size), 0.0);
    }

    @Test
    public void imperative() {
        assertArrayEquals(output, C06P095ArrayExamples.imperativeInitialize(size), 0.0);
    }

    @Test
    public void smallArray() {
        double[] input = {0, 1, 2, 3, 4, 3.5};
        double[] result = C06P095ArrayExamples.simpleMovingAverage(input, 3);
        System.out.println(Arrays.toString(result));
        double[] expected = {1, 2, 3, 3.5};
        Assert.assertArrayEquals(expected, result, 0.0);
    }


}
