package com.moqi.c08.command;

/**
 * 打开文件操作代理给 Editor 方法
 */
// BEGIN C08P110Open
public class C08P110Open implements C08P110Action {

    private final C08P110Editor editor;

    public C08P110Open(C08P110Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.open();
    }
}
// END C08P110Open
