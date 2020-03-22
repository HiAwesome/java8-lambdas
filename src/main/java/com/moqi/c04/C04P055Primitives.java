package com.moqi.c04;

import com.moqi.bean.Album;
import com.moqi.bean.Track;

import java.util.IntSummaryStatistics;

public class C04P055Primitives {

    /**
     * 使用 summaryStatistics 方法统计曲目长度
     */
    public static void printTrackLengthStatistics(Album album) {
        // BEGIN printTrackLengthStatistics
        IntSummaryStatistics trackLengthStats
                = album.getTracks()
                .mapToInt(Track::getLength)
                .summaryStatistics();

        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum());
        // END printTrackLengthStatistics
    }

}
