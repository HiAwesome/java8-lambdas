package com.moqi.c04;

import com.moqi.bean.Artist;

import java.util.List;
import java.util.Optional;

/**
 * 例 4-26 所示的 Artists 类表示了一组艺术家，重构该类，使得 getArtist 方法返回一个 Optional<Artist> 对象。
 * 如果索引在有效范围内，返回对应的元素，否则返回一个空 Optional 对象。
 * 此外，还需重构 getArtistName 方法，保持相同的行为。
 */
public class C04P066ArtistsFixed {

    private final List<Artist> artists;

    public C04P066ArtistsFixed(List<Artist> artists) {
        this.artists = artists;
    }

    public Optional<Artist> getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
            return Optional.empty();
        }
        return Optional.of(artists.get(index));
    }

    public String getArtistName(int index) {
        Optional<Artist> artist = getArtist(index);
        return artist.map(Artist::getName)
                .orElse("unknown");
    }

}
