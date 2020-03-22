package com.moqi.c04;

/**
 * 继承了 Parent 接口的 Child 接口。
 */
// BEGIN body
public interface C04P059Child extends C04P059Parent {

    @Override
    public default void welcome() {
        message("Child: Hi!");
    }

}
// END body
