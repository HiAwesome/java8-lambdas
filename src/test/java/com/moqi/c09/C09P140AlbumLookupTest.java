package com.moqi.c09;


import com.moqi.bean.Album;
import com.moqi.bean.Artist;
import com.moqi.bean.SampleData;
import com.moqi.bean.Track;
import org.junit.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C09P140AlbumLookupTest {

    @Test
    public void albumLookedUp() {
        Album album = SampleData.aLoveSupreme;
        List<Track> trackList = album.getTrackList();
        List<Artist> musicianList = album.getMusicianList();

        AlbumLookupFactory completable = C09P140CompletableAlbumLookup::new;
        AlbumLookupFactory future = C09P140FutureAlbumLookup::new;

        Stream.of(completable, future)
                .forEach(factory -> {
                    C09P140AlbumLookup lookup = factory.apply(trackList, musicianList);
                    System.out.println("Testing: " + lookup.getClass().getSimpleName());
                    Album result = lookup.lookupByName(album.getName());

                    assertEquals(trackList, result.getTrackList());
                    assertEquals(musicianList, result.getMusicianList());
                });
    }

    interface AlbumLookupFactory extends BiFunction<List<Track>, List<Artist>, C09P140AlbumLookup> {

    }

}
