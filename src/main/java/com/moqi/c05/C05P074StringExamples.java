package com.moqi.c05;

import com.moqi.bean.Artist;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
public class C05P074StringExamples {

    /**
     * 使用流和收集器格式化艺术家姓名
     */
    public static String formatArtists(List<Artist> artists) {
        // BEGIN collectors_joining
        String result =
                artists.stream()
                        .map(Artist::getName)
                        .collect(Collectors.joining(", ", "[", "]"));
        // END collectors_joining
        return result;
    }

    /**
     * 使用 for 循环和 StringBuilder 格式化艺术家姓名
     */
    public static String formatArtistsForLoop(List<Artist> artists) {
        // BEGIN for_loop
        StringBuilder builder = new StringBuilder("[");
        for (Artist artist : artists) {
            if (builder.length() > 1)
                builder.append(", ");

            String name = artist.getName();
            builder.append(name);
        }
        builder.append("]");
        String result = builder.toString();
        // END for_loop
        return result;
    }

    /**
     * 使用 forEach 循环和 StringBuilder 格式化艺术家姓名
     */
    public static String formatArtistsRefactor1(List<Artist> artists) {
        // BEGIN refactor_1
        StringBuilder builder = new StringBuilder("[");
        artists.stream()
                .map(Artist::getName)
                .forEach(name -> {
                    if (builder.length() > 1)
                        builder.append(", ");

                    builder.append(name);
                });
        builder.append("]");
        String result = builder.toString();
        // END refactor_1
        return result;
    }

    /**
     * 使用 reduce 循环和 StringBuilder 格式化艺术家姓名
     */
    public static String formatArtistsRefactor2(List<Artist> artists) {
        // BEGIN refactor_2
        StringBuilder reduced =
                artists.stream()
                        .map(Artist::getName)
                        .reduce(new StringBuilder(), (builder, name) -> {
                            if (builder.length() > 0)
                                builder.append(", ");

                            builder.append(name);
                            return builder;
                        }, (left, right) -> left.append(right));

        reduced.insert(0, "[");
        reduced.append("]");
        String result = reduced.toString();
        // END refactor_2
        return result;
    }


    /**
     * 使用 reduce 循环和 StringCombiner 格式化艺术家姓名
     */
    public static String formatArtistsRefactor3(List<Artist> artists) {
        // BEGIN refactor_3
        C05P078StringCombiner combined =
                artists.stream()
                        .map(Artist::getName)
                        .reduce(new C05P078StringCombiner(", ", "[", "]"),
                                C05P078StringCombiner::add,
                                C05P078StringCombiner::merge);

        String result = combined.toString();
        // END refactor_3
        return result;
    }

    /**
     * 使用 reduce 操作，将工作代理给 StringCombiner 对象
     */
    public static String formatArtistsRefactor4(List<Artist> artists) {
        // BEGIN refactor_4
        String result =
                artists.stream()
                        .map(Artist::getName)
                        .reduce(new C05P078StringCombiner(", ", "[", "]"),
                                C05P078StringCombiner::add,
                                C05P078StringCombiner::merge)
                        .toString();
        // END refactor_4
        return result;
    }

    /**
     * 使用定制的收集器 StringCollector 收集字符串
     */
    public static String formatArtistsRefactor5(List<Artist> artists) {
        // BEGIN refactor_5
        String result =
                artists.stream()
                        .map(Artist::getName)
                        .collect(new C05P079StringCollector(", ", "[", "]"));
        // END refactor_5
        return result;
    }

    /**
     * reducing 是一种定制收集器的简便方式
     */
    public static String formatArtistsReducing(List<Artist> artists) {
        // BEGIN reducing
        String result =
                artists.stream()
                        .map(Artist::getName)
                        .collect(Collectors.reducing(
                                new C05P078StringCombiner(", ", "[", "]"),
                                name -> new C05P078StringCombiner(", ", "[", "]").add(name),
                                C05P078StringCombiner::merge))
                        .toString();
        // END reducing
        return result;
    }

    /*.reduce(,
    ,
    C05P078StringCombiner::merge)
            .toString()*/

}
