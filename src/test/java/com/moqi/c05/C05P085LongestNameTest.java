package com.moqi.c05;

import com.moqi.bean.Artist;
import com.moqi.bean.SampleData;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C05P085LongestNameTest {

    @Test
    public void findsLongestNameByReduce() {
        Artist artist = C05P085LongestName.byReduce(SampleData.getThreeArtists());
        assertEquals(SampleData.johnColtrane, artist);
    }

    @Test
    public void findsLongestNameByCollecting() {
        Artist artist = C05P085LongestName.byCollecting(SampleData.getThreeArtists());
        assertEquals(SampleData.johnColtrane, artist);
    }

}
