package com.moqi.c04;

// BEGIN body
public interface C04P059Child extends C04P059Parent {

    @Override
    public default void welcome() {
        message("Child: Hi!");
    }

}
// END body
