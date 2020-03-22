package com.moqi.c04;

// BEGIN body
public interface C04P059Parent {

    public void message(String body);

    /**
     * Parent 接口，其中的 welcome 是一个默认方法。
     */
    public default void welcome() {
        message("Parent: Hi!");
    }

    public String getLastMessage();

}
// END body
