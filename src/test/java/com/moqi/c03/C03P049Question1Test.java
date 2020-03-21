package com.moqi.c03;

import com.moqi.bean.Album;
import com.moqi.bean.SampleData;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static com.moqi.bean.SampleData.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class C03P049Question1Test {

    @Test
    public void addsEmptyList() {
        int result = C03P049Question1.addUp(Stream.empty());
        assertEquals(0, result);
    }

    @Test
    public void addsListWithValues() {
        int result = C03P049Question1.addUp(Stream.of(1, 3, -2));
        assertEquals(2, result);
    }

    @Test
    public void extractsNamesAndOriginsOfArtists() {
        List<String> namesAndOrigins = C03P049Question1.getNamesAndOrigins(SampleData.getThreeArtists());
        assertEquals(asList("John Coltrane", "US", "John Lennon", "UK", "The Beatles", "UK"), namesAndOrigins);
    }

    @Test
    public void findsShortAlbums() {
        List<Album> input = asList(manyTrackAlbum, sampleShortAlbum, aLoveSupreme);
        List<Album> result = C03P049Question1.getAlbumsWithAtMostThreeTracks(input);
        assertEquals(asList(sampleShortAlbum, aLoveSupreme), result);
    }

}
