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

public class AlbumLookupTest {

    @Test
    public void albumLookedUp() {
        Album album = SampleData.aLoveSupreme;
        List<Track> trackList = album.getTrackList();
        List<Artist> musicianList = album.getMusicianList();

        AlbumLookupFactory completable = CompletableAlbumLookup::new;
        AlbumLookupFactory future = FutureAlbumLookup::new;

        Stream.of(completable, future)
                .forEach(factory -> {
                    AlbumLookup lookup = factory.apply(trackList, musicianList);
                    System.out.println("Testing: " + lookup.getClass().getSimpleName());
                    Album result = lookup.lookupByName(album.getName());

                    assertEquals(trackList, result.getTrackList());
                    assertEquals(musicianList, result.getMusicianList());
                });
    }

    interface AlbumLookupFactory extends BiFunction<List<Track>, List<Artist>, AlbumLookup> {

    }

}
