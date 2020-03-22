package com.moqi.c09;

import com.moqi.bean.Artist;
import com.moqi.bean.SampleData;

public class C09P140FakeLookupService {

    public Artist lookupArtistName(String name) {
        sleepToSimulateLookupLatency();

        switch (name) {
            case "The Beatles":
                return SampleData.theBeatles;

            case "John Coltrane":
                return SampleData.johnColtrane;

            default:
                throw new IllegalArgumentException("Unknown artist: " + name);
        }
    }

    private void sleepToSimulateLookupLatency() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
