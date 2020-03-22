package com.moqi.c04;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C04P059TestDefaultSubClassing {

    // BEGIN parent_default_used
    @Test
    public void parentDefaultUsed() {
        C04P059Parent parent = new C04P059ParentImpl();
        parent.welcome();
        assertEquals("Parent: Hi!", parent.getLastMessage());
    }
    // END parent_default_used

    // BEGIN child_override_default
    @Test
    public void childOverrideDefault() {
        C04P059Child child = new C04P059ChildImpl();
        child.welcome();
        assertEquals("Child: Hi!", child.getLastMessage());
    }
    // END child_override_default

    // BEGIN concrete_beats_default
    @Test
    public void concreteBeatsDefault() {
        C04P059Parent parent = new C04P059OverridingParent();
        parent.welcome();
        assertEquals("Class Parent: Hi!", parent.getLastMessage());
    }
    // END concrete_beats_default

    // BEGIN concrete_beats_closer_default
    @Test
    public void concreteBeatsCloserDefault() {
        C04P059Child child = new C04P059OverridingChild();
        child.welcome();
        assertEquals("Class Parent: Hi!", child.getLastMessage());
    }
    // END concrete_beats_closer_default

}
