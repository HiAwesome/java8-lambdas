package com.moqi.c06;


import com.moqi.bean.Album;
import com.moqi.bean.SampleData;
import com.moqi.bean.Track;
import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * 参考 https://stackoverflow.com/a/34840064
 * 将 @GenerateMicroBenchmark 替换为 @Benchmark
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class C06P088ArraySum {

    public List<Album> albums;

    public static void main(String[] ignore) throws IOException {
        final String[] args = {
                ".*ArraySum.*",
                "-wi",
                "5",
                "-i",
                "5"
        };
        Main.main(args);
    }

    @Setup
    public void initAlbums() {
        int n = Integer.getInteger("arraysum.size", 1000);
        albums = IntStream.range(0, n)
                .mapToObj(i -> SampleData.aLoveSupreme.copy())
                .collect(toList());
    }

    @Benchmark
    // BEGIN serial
    public int serialArraySum() {
        return albums.stream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }
    // END serial

    @Benchmark
    // BEGIN parallel
    public int parallelArraySum() {
        return albums.parallelStream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }
    // END parallel

}
