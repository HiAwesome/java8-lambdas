package com.moqi.c09;


import com.moqi.bean.Artist;

import java.util.function.Function;

/**
 * BlockingArtistAnalyzer 告诉用户哪位艺术家的成员更多
 */
// BEGIN class
public class C09P147BlockingArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public C09P147BlockingArtistAnalyzer(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    public boolean isLargerGroup(String artistName, String otherArtistName) {
        return getNumberOfMembers(artistName) > getNumberOfMembers(otherArtistName);
    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName)
                .getMembers()
                .count();
    }

}
// END class
