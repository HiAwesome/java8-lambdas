package com.moqi.c08.command;

/**
 * 保存操作代理给 Editor 方法
 */
// BEGIN C08P110Save
public class C08P110Save implements C08P110Action {

    private final C08P110Editor editor;

    public C08P110Save(C08P110Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.save();
    }
}
// END C08P110Save
