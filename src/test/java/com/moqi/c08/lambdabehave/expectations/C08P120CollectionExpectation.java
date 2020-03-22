package com.moqi.c08.lambdabehave.expectations;

import java.util.Collection;

import static junit.framework.Assert.assertTrue;

public class C08P120CollectionExpectation extends C08P120BoundExpectation {

    private final Collection<?> objectUnderTest;

    public C08P120CollectionExpectation(Collection<?> objectUnderTest) {
        super(objectUnderTest);
        this.objectUnderTest = objectUnderTest;
    }

    public void isEmpty() {
        assertTrue(objectUnderTest.isEmpty());
    }

}
