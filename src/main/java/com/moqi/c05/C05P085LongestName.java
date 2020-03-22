package com.moqi.c05;

import com.moqi.bean.Artist;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class C05P085LongestName {

    private static final Comparator<Artist> BY_NAME_LENGTH = comparing(artist -> artist.getName().length());

    public static Artist byReduce(List<Artist> artists) {
        return artists.stream()
                      .reduce((acc, artist) -> {
                          return (BY_NAME_LENGTH.compare(acc, artist) >= 0) ? acc : artist;
                      })
                      .orElseThrow(RuntimeException::new);
    }

    public static Artist byCollecting(List<Artist> artists) {
        return artists.stream()
                      .collect(Collectors.maxBy(BY_NAME_LENGTH))
                      .orElseThrow(RuntimeException::new);
    }

}
