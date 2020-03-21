package com.moqi.c03;

import com.moqi.bean.Artist;

import java.util.Iterator;
import java.util.List;

/**
 * @author moqi
 * On 3/21/20 17:17
 */

@SuppressWarnings({"WhileLoopReplaceableByForEach", "ResultOfMethodCallIgnored", "unused"})
public class C03P032Iteration {

    /**
     * 使用 for 循环计算来自伦敦的艺术家人数
     */
    public int externalCountArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN external_count_londoners
        int count = 0;
        for (Artist artist : allArtists) {
            if (artist.isFrom("London")) {
                count++;
            }
        }
        // END external_count_londoners
        return count;
    }

    /**
     * 使用迭代器计算来自伦敦的艺术家人数
     */
    public int externalCountArtistsFromLondonExpanded(List<Artist> allArtists) {
        // BEGIN external_count_londoners_expanded
        int count = 0;
        Iterator<Artist> iterator = allArtists.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("London")) {
                count++;
            }
        }
        // END external_count_londoners_expanded
        return count;
    }

    /**
     * 使用内部迭代计算来自伦敦的艺术家人数
     */
    public long internalCountArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN internal_count_londoners
        return allArtists.stream()
                .filter(artist -> artist.isFrom("London"))
                .count();
        // END internal_count_londoners
    }

    /**
     * 只过滤，不计数
     */
    public void filterArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN filter_londoners
        allArtists.stream()
                .filter(artist -> artist.isFrom("London"));
        // END filter_londoners
    }

    /**
     * 由于使用了惰性求值，没有输出艺术家的名字
     */
    public void filterArtistsFromLondonPrinted(List<Artist> allArtists) {
        // BEGIN filter_londoners_printed
        allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                });
        // END filter_londoners_printed
    }

    /**
     * 输出艺术家的名字
     */
    public void internalCountArtistsFromLondonPrinted(List<Artist> allArtists) {
        // BEGIN internal_count_londoners_printed
        allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                })
                .count();
        // END internal_count_londoners_printed
    }

}
