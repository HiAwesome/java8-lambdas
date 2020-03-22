package com.moqi.c08;

import com.moqi.c08.C08P124SingleResponsibilityPrinciple.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static groovy.util.GroovyTestCase.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class C08P124SingleResponsibilityPrincipleTest {

    private final PrimeCounter primeCounter;

    public C08P124SingleResponsibilityPrincipleTest(PrimeCounter primeCounter) {
        this.primeCounter = primeCounter;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{new ImperativeRefactoredPrimeCounter()},
                {new ImperativeSingleMethodPrimeCounter()},
                {new FunctionalPrimeCounter()},
                {new ParallelFunctionalPrimeCounter()}};
        return Arrays.asList(data);
    }

    @Test
    public void countsPrimesTo10() {
        assertEquals(5, primeCounter.countPrimes(10));
        assertEquals(9, primeCounter.countPrimes(20));
    }

    @Test
    public void countsPrimesTo20() {
        assertEquals(9, primeCounter.countPrimes(20));
    }

    @Test
    public void countsPrimesTo30() {
        assertEquals(11, primeCounter.countPrimes(30));
    }

}

