package com.moqi.c03;

import com.moqi.bean.SampleData;
import org.junit.Test;

public class C03P035IterationTest {

    @Test
    public void lazyPrintOuts() {
        C03P032Iteration iteration = new C03P032Iteration();
        iteration.filterArtistsFromLondonPrinted(SampleData.membersOfTheBeatles);
    }

    @Test
    public void evaluatedPrintOuts() {
        C03P032Iteration iteration = new C03P032Iteration();
        iteration.internalCountArtistsFromLondonPrinted(SampleData.membersOfTheBeatles);
    }
}
