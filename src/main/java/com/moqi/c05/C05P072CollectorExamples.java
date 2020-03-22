package com.moqi.c05;

import com.moqi.bean.Album;
import com.moqi.bean.Artist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.nio.charset.Charset.defaultCharset;
import static java.util.Comparator.comparing;
import static java.util.Map.Entry;
import static java.util.stream.Collectors.*;

@SuppressWarnings("ALL")
public class C05P072CollectorExamples {

    private static final Pattern SPACES = Pattern.compile("\\w+");

    public static Map<String, Long> countWords(Stream<String> words) {
        return words.collect(groupingBy(word -> word, counting()));
    }
    // END BIGGEST_GROUP

    public static Map<String, Long> countWordsIn(Path path) throws IOException {
        Stream<String> words = Files.readAllLines(path, defaultCharset())
                .stream()
                .flatMap(line -> SPACES.splitAsStream(line));

        return countWords(words);
    }
    // END BANDS_AND_SOLO

    /**
     * 使用 toCollection ，用定制的集合收集元素
     */
    public void toCollectionTreeset() {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        // BEGIN TO_COLLECTION_TREESET
        stream.collect(toCollection(TreeSet::new));
        // END TO_COLLECTION_TREESET
    }
    // END BANDS_AND_SOLO_REF

    /**
     * 找出成员最多的乐队
     */
    // BEGIN BIGGEST_GROUP
    public Optional<Artist> biggestGroup(Stream<Artist> artists) {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return artists.collect(maxBy(comparing(getCount)));
    }
    // END ALBUMS_BY_ARTIST

    /**
     * 将艺术家组成的流分成乐队和独唱歌手两部分
     */
    // BEGIN BANDS_AND_SOLO
    public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(partitioningBy(artist -> artist.isSolo()));
    }

    /**
     * 使用方法引用将艺术家组成的 Stream 分成乐队和独唱歌手两部分
     */
    // BEGIN BANDS_AND_SOLO_REF
    public Map<Boolean, List<Artist>> bandsAndSoloRef(Stream<Artist> artists) {
        return artists.collect(partitioningBy(Artist::isSolo));
    }
    // END NUMBER_OF_ALBUMS

    /**
     * 使用主唱对专辑分组
     */
    // BEGIN ALBUMS_BY_ARTIST
    public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        return albums.collect(groupingBy(album -> album.getMainMusician()));
    }
    // END NAME_OF_ALBUMS_DUMB

    /**
     * 计算每个艺术家专辑数的简单方式
     */
    public Map<Artist, Integer> numberOfAlbumsDumb(Stream<Album> albums) {
        // BEGIN NUMBER_OF_ALBUMS_DUMB
        Map<Artist, List<Album>> albumsByArtist
                = albums.collect(groupingBy(album -> album.getMainMusician()));

        Map<Artist, Integer> numberOfAlbums = new HashMap<>();
        for (Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            numberOfAlbums.put(entry.getKey(), entry.getValue().size());
        }
        // END NUMBER_OF_ALBUMS_DUMB
        return numberOfAlbums;
    }
    // END NAME_OF_ALBUMS

    /**
     * 使用收集器计算每个艺术家的专辑数
     */
    // BEGIN NUMBER_OF_ALBUMS
    public Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
        return albums.collect(groupingBy(album -> album.getMainMusician(),
                counting()));
    }

    /**
     * 使用简单方式求每个艺术家的专辑名
     */
    // BEGIN NAME_OF_ALBUMS_DUMB
    public Map<Artist, List<String>> nameOfAlbumsDumb(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist =
                albums.collect(groupingBy(album -> album.getMainMusician()));

        Map<Artist, List<String>> nameOfAlbums = new HashMap<>();
        for (Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            nameOfAlbums.put(entry.getKey(), entry.getValue()
                    .stream()
                    .map(Album::getName)
                    .collect(toList()));
        }
        return nameOfAlbums;
    }

    /**
     * 使用收集器求每个艺术家的专辑名
     */
    // BEGIN NAME_OF_ALBUMS
    public Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums) {
        return albums.collect(groupingBy(Album::getMainMusician,
                mapping(Album::getName, toList())));
    }

    /**
     * 找出一组专辑上曲目的平均数
     */
    // BEGIN averagingTracks
    public double averageNumberOfTracks(List<Album> albums) {
        return albums.stream()
                .collect(averagingInt(album -> album.getTrackList().size()));
    }
    // END averagingTracks

}

