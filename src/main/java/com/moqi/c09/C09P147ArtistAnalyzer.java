package com.moqi.c09;

import java.util.function.Consumer;

/**
 * 需要实现的 ArtistAnalyzer 接口
 */
// BEGIN class
public interface C09P147ArtistAnalyzer {

    public void isLargerGroup(String artistName,
                              String otherArtistName,
                              Consumer<Boolean> handler);
    
}
// END class
