package com.moqi.c09;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class C09P147BlockingArtistAnalyzerTest {

    private final C09P147BlockingArtistAnalyzer analyser = new C09P147BlockingArtistAnalyzer(new C09P147FakeLookupService()::lookupArtistName);

    @Test
    public void largerGroupsAreLarger() {
        assertTrue(analyser.isLargerGroup("The Beatles", "John Coltrane"));
    }

    @Test
    public void smallerGroupsAreNotLarger() {
        assertFalse(analyser.isLargerGroup("John Coltrane", "The Beatles"));
    }

}
