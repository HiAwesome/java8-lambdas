package com.moqi.c05;

import org.junit.Test;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class C05P085WordCountTest {

    @Test
    public void passesBookExample() {
        Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");
        Map<String, Long> counts = C05P085WordCount.countWords(names);

        assertEquals(3, counts.size());
        assertEquals(Long.valueOf(3), counts.get("John"));
        assertEquals(Long.valueOf(2), counts.get("Paul"));
        assertEquals(Long.valueOf(1), counts.get("George"));
    }

}
