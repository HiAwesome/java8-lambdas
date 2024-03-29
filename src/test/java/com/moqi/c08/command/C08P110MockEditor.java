package com.moqi.c08.command;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class C08P110MockEditor implements C08P110Editor {

    private final List<String> actions = new ArrayList<>();

    @Override
    public void save() {
        actions.add("save");
    }

    @Override
    public void open() {
        actions.add("open");
    }

    @Override
    public void close() {
        actions.add("close");
    }

    public void check() {
        assertEquals("open", actions.get(0));
        assertEquals("save", actions.get(1));
        assertEquals("close", actions.get(2));
    }

}
