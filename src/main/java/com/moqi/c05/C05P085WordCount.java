package com.moqi.c05;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class C05P085WordCount {

    public static Map<String, Long> countWords(Stream<String> names) {
        return names.collect(groupingBy(name -> name, counting()));
    }

}
