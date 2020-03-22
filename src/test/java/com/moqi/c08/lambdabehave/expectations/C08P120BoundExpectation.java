package com.moqi.c08.lambdabehave.expectations;

import static org.junit.Assert.assertEquals;

public class C08P120BoundExpectation {

    private final Object objectUnderTest;

    public C08P120BoundExpectation(Object value) {
        this.objectUnderTest = value;
    }
    
    public void isEqualTo(Object expected) {
        assertEquals(expected, objectUnderTest);
    }

}
