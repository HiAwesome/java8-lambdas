package com.moqi.c09;

import com.moqi.bean.Artist;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

public class C09P147CompletableFutureArtistAnalyser implements C09P147ArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public C09P147CompletableFutureArtistAnalyser(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
        CompletableFuture<Long> otherArtistMemberCount = CompletableFuture.supplyAsync(() -> getNumberOfMembers(otherArtistName));

        CompletableFuture<Long> artistMemberCount = CompletableFuture.completedFuture(getNumberOfMembers(artistName));

        artistMemberCount.thenCombine(otherArtistMemberCount, (count, otherCount) -> count > otherCount)
                .thenAccept(handler::accept);
    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName)
                .getMembers()
                .count();
    }

}
