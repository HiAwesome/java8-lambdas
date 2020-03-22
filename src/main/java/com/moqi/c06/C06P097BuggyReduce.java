package com.moqi.c06;

import java.util.List;

public class C06P097BuggyReduce {

    /*
    Buggy Version:
    // BEGIN buggyMultiplyThrough
public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
    return linkedListOfNumbers.stream()
                  .reduce(5, (acc, x) -> x * acc);
}
    // END buggyMultiplyThrough
    */

    public static int multiplyThrough(List<Integer> numbers) {
        return 5 * numbers.parallelStream()
                          .reduce(1, (acc, x) -> x * acc);
    }

}
