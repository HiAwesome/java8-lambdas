package com.moqi.c05;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C05P078StringCombinerTest {
    private C05P078StringCombiner combiner;

    @Before
    public void before() {
        this.combiner = new C05P078StringCombiner(", ", "[", "]");

        combiner.add("A").add("B").add("C").add("D");
    }

    @Test
    public void add() throws Exception {
        assertEquals("[A, B, C, D]", combiner.toString());
    }

    @Test
    public void mergeWithOther() throws Exception {
        C05P078StringCombiner other = new C05P078StringCombiner(", ", "[", "]");

        other.add("E").add("F").add("G");

        this.combiner.merge(other);

        assertEquals("[A, B, C, D, E, F, G]", this.combiner.toString());
    }

    @Test
    public void mergeWithEmpty() {
        this.combiner.merge(new C05P078StringCombiner(", ", "[", "]"));

        assertEquals("[A, B, C, D]", this.combiner.toString());
    }

    @Test
    public void mergeSelf() throws Exception {
        assertEquals("[A, B, C, D]", this.combiner.merge(this.combiner).toString());
    }

    @Test
    public void twiceCallToString() throws Exception {
        assertEquals("[A, B, C, D]", this.combiner.toString());
        assertEquals("[A, B, C, D]", this.combiner.toString());
    }
}