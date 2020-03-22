package com.moqi.c09;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class C09P147ArtistAnalyzerTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        C09P140FakeLookupService lookupService = new C09P140FakeLookupService();
        Object[][] data = new Object[][] {
            { new C09P147CallbackArtistAnalyser(lookupService::lookupArtistName) },
            { new C09P147CompletableFutureArtistAnalyser(lookupService::lookupArtistName) },
        };
        return Arrays.asList(data);
    }

    private final C09P147ArtistAnalyzer analyser;

    public C09P147ArtistAnalyzerTest(C09P147ArtistAnalyzer analyser) {
        this.analyser = analyser;
    }

    @Test
    public void largerGroupsAreLarger() {
        assertLargerGroup(true, "The Beatles", "John Coltrane");
    }

    @Test
    public void smallerGroupsArentLarger() {
        assertLargerGroup(false, "John Coltrane", "The Beatles");
    }

    private void assertLargerGroup(boolean expected, String artistName, String otherArtistName) {
        AtomicBoolean isLarger = new AtomicBoolean(!expected);
        analyser.isLargerGroup(artistName, otherArtistName, isLarger::set);
        assertEquals(expected, isLarger.get());
    }

}
