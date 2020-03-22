package com.moqi.c04;

import com.moqi.bean.Artist;
import com.moqi.bean.SampleData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class C04P066ArtistsTest {

    private final C04P066ArtistsFixed optionalExamples = new C04P066ArtistsFixed(SampleData.getThreeArtists());

    @Test
    public void indexWithinRange() {
        Optional<Artist> artist = optionalExamples.getArtist(0);
        assertTrue(artist.isPresent());
    }

    @Test
    public void indexOutsideRange() {
        Optional<Artist> artist = optionalExamples.getArtist(4);
        assertFalse(artist.isPresent());
    }

    @Test
    public void nameIndexInsideRange() {
        String artist = optionalExamples.getArtistName(0);
        Assert.assertEquals("John Coltrane", artist);
    }

    @Test
    public void nameIndexOutsideRange() {
        String artist = optionalExamples.getArtistName(4);
        assertEquals("unknown", artist);
    }

}
