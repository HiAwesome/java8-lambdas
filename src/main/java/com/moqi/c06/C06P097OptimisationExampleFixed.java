package com.moqi.c06;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
public class C06P097OptimisationExampleFixed {

    public static void main(String[] ignore) throws IOException {
        final String[] args = {
                ".*C06P097OptimisationExampleFixed.*",
                "-wi",
                "10",
                "-i",
                "10",
                "-f",
                "1"
        };
        Main.main(args);
    }

    private List<Integer> arrayListOfNumbers;
    private List<Integer> linkedListOfNumbers;

    @Setup
    public void init() {
        arrayListOfNumbers= new ArrayList<>();
        addNumbers(arrayListOfNumbers);

        linkedListOfNumbers = new LinkedList<>();
        addNumbers(linkedListOfNumbers);
    }

    private void addNumbers(List<Integer> container) {
        IntStream.range(0, 1_000_000)
                .forEach(container::add);
    }

    @Benchmark
    public int slowSumOfSquares() {
        return linkedListOfNumbers.parallelStream()
                                  .map(x -> x * x)
                                  .reduce(0, Integer::sum);
    }

    @Benchmark
    public int serialSlowSumOfSquares() {
        return linkedListOfNumbers.stream()
                                  .map(x -> x * x)
                                  .reduce(0, Integer::sum);
    }

    @Benchmark
    public int intermediateSumOfSquares() {
        return arrayListOfNumbers.parallelStream()
                                 .map(x -> x * x)
                                 .reduce(0, Integer::sum);
    }

    @Benchmark
    public int serialIntermediateSumOfSquares() {
        return arrayListOfNumbers.stream()
                                 .map(x -> x * x)
                                 .reduce(0, Integer::sum);
    }

    @Benchmark
    public int fastSumOfSquares() {
        return arrayListOfNumbers.parallelStream()
                                 .mapToInt(x -> x * x)
                                 .sum();
    }

    @Benchmark
    public int serialFastSumOfSquares() {
        return arrayListOfNumbers.stream()
                           .mapToInt(x -> x * x)
                           .sum();
    }

}
