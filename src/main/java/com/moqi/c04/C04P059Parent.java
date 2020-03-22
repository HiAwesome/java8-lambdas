package com.moqi.c04;

// BEGIN body
public interface C04P059Parent {

    public void message(String body);

    public default void welcome() {
        message("Parent: Hi!");
    }

    public String getLastMessage();

}
// END body
