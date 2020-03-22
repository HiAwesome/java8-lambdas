package com.moqi.c05;


import com.moqi.bean.Artist;
import com.moqi.bean.SampleData;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class C05P074StringExamplesTest {

    @Test
    public void beatlesExample() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("John");
        joiner.add("Paul");
        joiner.add("Ringo");
        assertEquals("[John, Paul, Ringo]", joiner.toString());
    }

    @Test
    public void allStringJoins() {
        List<Function<List<Artist>, String>> formatters = Arrays.asList(
                C05P074StringExamples::formatArtists,
                C05P074StringExamples::formatArtistsForLoop,
                C05P074StringExamples::formatArtistsRefactor1,
                C05P074StringExamples::formatArtistsRefactor2,
                C05P074StringExamples::formatArtistsRefactor3,
                C05P074StringExamples::formatArtistsRefactor4,
                C05P074StringExamples::formatArtistsRefactor5
        );

        formatters.forEach(formatter -> {
            System.out.println("Testing: " + formatter.toString());
            String result = formatter.apply(SampleData.getThreeArtists());
            assertEquals("[John Coltrane, John Lennon, The Beatles]", result);

            result = formatter.apply(Collections.emptyList());
            assertEquals("[]", result);
        });
    }

    @Test
    public void explicitForLoop() {
        String result = C05P074StringExamples.formatArtists(SampleData.getThreeArtists());
        assertEquals("[John Coltrane, John Lennon, The Beatles]", result);
    }

}
