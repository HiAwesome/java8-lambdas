package com.moqi.c04;

public class C04P059ParentImpl implements C04P059Parent {

    private String body;

    @Override
    public void message(String body) {
        this.body = body;
    }

    @Override
    public String getLastMessage() {
        return body;
    }

}
