package com.moqi.c09;

import com.moqi.bean.Artist;
import com.moqi.bean.SampleData;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RxExamplesTest {

    /**
     * 根据 https://stackoverflow.com/questions/54767187/how-to-avoid-toblocking-in-rxjava-2 重构
     */
    @Test
    public void filtersAlbums() {
        RxExamples examples = new RxExamples(SampleData.getThreeArtists());
        Artist artist = examples
                .search("John", "UK", 5)
                .blockingFirst();

        assertEquals(SampleData.johnLennon, artist);
    }

}
