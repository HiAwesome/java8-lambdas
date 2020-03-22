package com.moqi.c08.lambdabehave.expectations;

import java.util.Collection;

/**
 * 期望链的开始
 */
// BEGIN C08P120Expect
public final class C08P120Expect {

    public C08P120BoundExpectation that(Object value) {
        return new C08P120BoundExpectation(value);
    }

    // Rest of class omitted

    public C08P120CollectionExpectation that(Collection<?> collection) {
        return new C08P120CollectionExpectation(collection);
    }

}
// END C08P120Expect
