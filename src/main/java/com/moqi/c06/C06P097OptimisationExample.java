package com.moqi.c06;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Just run this class's main method and it will time benchmarks using the harness
 * 只需运行此类的主要方法，它将使用线束来计时基准
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
public class C06P097OptimisationExample {

    public static void main(String[] ignore) throws IOException {
        final String[] args = {
                ".*C06P097OptimisationExample.*",
                "-wi",
                "10",
                "-i",
                "10",
                "-f",
                "1"
        };
        Main.main(args);
    }

    private List<Integer> linkedListOfNumbers;

    @Setup
    public void init() {
        linkedListOfNumbers = new LinkedList<>();
        addNumbers(linkedListOfNumbers);
        // TODO: put any additional setup code here
    }

    private void addNumbers(List<Integer> container) {
        IntStream.range(0, 1_000_000)
                 .forEach(container::add);
    }

    @Benchmark
    // BEGIN slowSumOfSquares
    public int slowSumOfSquares() {
        return linkedListOfNumbers.parallelStream()
                                  .map(x -> x * x)
                                  .reduce(0, Integer::sum);
    }
    // END slowSumOfSquares

    @Benchmark
    public int fastSumOfSquares() {
        // TODO: implement faster version of slowSumOfSquares here
        return 0;
    }

}
