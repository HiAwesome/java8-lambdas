package com.moqi.c03;

import com.moqi.bean.SampleData;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class C03P050Question2Test {

    @Test
    public void internal() {
        assertEquals(4, C03P050Question2.countBandMembersInternal(Arrays.asList(SampleData.johnColtrane, SampleData.theBeatles)));
    }

}
