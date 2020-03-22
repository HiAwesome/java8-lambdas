package com.moqi.c08.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 包含操作序列的宏，可按顺序执行操作
 */
// BEGIN C08P110Macro
public class C08P110Macro {

    private final List<C08P110Action> actions;

    public C08P110Macro() {
        actions = new ArrayList<>();
    }

    public void record(C08P110Action action) {
        actions.add(action);
    }

    public void run() {
        actions.forEach(C08P110Action::perform);
    }

}
// END C08P110Macro
