package com.moqi.c07;


import com.moqi.bean.Album;

import java.util.List;

public abstract class C07P105Order {

    protected final List<Album> albums;

    public C07P105Order(List<Album> albums) {
        this.albums = albums;
    }

    public abstract long countRunningTime();

    public abstract long countMusicians();

    public abstract long countTracks();

}
