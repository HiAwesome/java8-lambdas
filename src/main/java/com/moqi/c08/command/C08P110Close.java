package com.moqi.c08.command;

public class C08P110Close implements C08P110Action {

    private final C08P110Editor editor;

    public C08P110Close(C08P110Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.close();
    }

}
