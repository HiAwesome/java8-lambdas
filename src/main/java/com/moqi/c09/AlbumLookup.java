package com.moqi.c09;

import com.moqi.bean.Album;

public interface AlbumLookup {
    Album lookupByName(String albumName);
}
