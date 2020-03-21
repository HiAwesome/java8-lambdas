package com.moqi.c03;


import com.moqi.bean.Album;
import com.moqi.bean.Artist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class C03P044Decisions {

    /**
     * 符合 Stream 使用习惯的链式调用
     */
    public Set<String> originsOfBands(Album album) {
        // BEGIN origins_of_bands
        // END origins_of_bands
        return album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(Artist::getNationality)
                .collect(toSet());
    }

    /**
     * 误用 Stream 的例子
     * 每一步强制对函数求值，而不是将所有的方法调用链接在一起
     */
    public Set<String> originsOfBandsMisuse(Album album) {
        // BEGIN misuse
        List<Artist> musicians = album.getMusicians()
                .collect(toList());

        List<Artist> bands = musicians.stream()
                .filter(artist -> artist.getName().startsWith("The"))
                .collect(toList());

        // END misuse
        return bands.stream()
                .map(Artist::getNationality)
                .collect(toSet());
    }

    public static class Imperative {
        // BEGIN origins_of_bands_meth_imp
        public Set<String> originsOfBands(Album album) {
            Set<String> nationalities = new HashSet<>();
            for (Artist artist : album.getMusicianList()) {
                if (artist.getName().startsWith("The")) {
                    String nationality = artist.getNationality();
                    nationalities.add(nationality);
                }
            }
            return nationalities;
        }
        // END origins_of_bands_meth_imp
    }

}
