package com.moqi.c08.command;

import org.junit.Test;

public class C08P110MacrosTest {

    /**
     * 使用命令者模式构建宏
     */
    @Test
    public void classBasedCommand() {
        C08P110MockEditor editor = new C08P110MockEditor();

        // BEGIN classBasedCommand
        C08P110Macro macro = new C08P110Macro();
        macro.record(new C08P110Open(editor));
        macro.record(new C08P110Save(editor));
        macro.record(new C08P110Close(editor));
        macro.run();
        // END classBasedCommand

        editor.check();
    }

    /**
     * 使用 Lambda 表达式构建宏
     */
    @SuppressWarnings("Convert2MethodRef")
    @Test
    public void lambdaBasedCommand() {
        C08P110MockEditor editor = new C08P110MockEditor();

        // BEGIN lambdaBasedCommand
        C08P110Macro macro = new C08P110Macro();
        macro.record(() -> editor.open());
        macro.record(() -> editor.save());
        macro.record(() -> editor.close());
        macro.run();
        // END lambdaBasedCommand

        editor.check();
    }

    /**
     * 使用方法引用构建宏
     */
    @Test
    public void referenceBasedCommand() {
        C08P110MockEditor editor = new C08P110MockEditor();

        // BEGIN referenceBasedCommand
        C08P110Macro macro = new C08P110Macro();
        macro.record(editor::open);
        macro.record(editor::save);
        macro.record(editor::close);
        macro.run();
        // END referenceBasedCommand

        editor.check();
    }

}
