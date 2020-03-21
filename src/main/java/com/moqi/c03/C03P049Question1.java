package com.moqi.c03;

import com.moqi.bean.Album;
import com.moqi.bean.Artist;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class C03P049Question1 {
    /**
     * 编写一个求和函数，计算流中所有数之和。例如，int addUp(Stream<Integer> numbers);
     */
    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, Integer::sum);
    }

    /**
     * 编写一个函数，接受艺术家列表作为参数，返回一个字符串列表，其中包含艺术家的姓名和国籍;
     */
    public static List<String> getNamesAndOrigins(List<Artist> artists) {
        return artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(toList());
    }

    /**
     * 编写一个函数，接受专辑列表作为参数，返回一个由最多包含 3 首歌曲的专辑组成的列表。
     */
    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
        return input.stream()
                .filter(album -> album.getTrackList().size() <= 3)
                .collect(toList());
    }
}
