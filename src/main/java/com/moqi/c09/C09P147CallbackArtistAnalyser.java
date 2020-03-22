package com.moqi.c09;

import com.moqi.bean.Artist;

import java.util.function.Consumer;
import java.util.function.Function;

public class C09P147CallbackArtistAnalyser implements C09P147ArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public C09P147CallbackArtistAnalyser(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
        boolean isLarger = getNumberOfMembers(artistName) > getNumberOfMembers(otherArtistName);
        handler.accept(isLarger);
    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName)
                .getMembers()
                .count();
    }

}
