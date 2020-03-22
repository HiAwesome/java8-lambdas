package com.moqi.c07;


import com.moqi.bean.Album;
import com.moqi.bean.Track;

import java.util.List;
import java.util.function.ToLongFunction;

public class C07P105OrderDomain extends C07P105Order {

    public C07P105OrderDomain(List<Album> albums) {
        super(albums);
    }

    // BEGIN body
    public long countFeature(ToLongFunction<Album> function) {
        return albums.stream()
                .mapToLong(function)
                .sum();
    }

    public long countTracks() {
        return countFeature(album -> album.getTracks().count());
    }

    public long countRunningTime() {
        return countFeature(album -> album.getTracks()
                .mapToLong(Track::getLength)
                .sum());
    }

    public long countMusicians() {
        return countFeature(album -> album.getMusicians().count());
    }
// END body

}
