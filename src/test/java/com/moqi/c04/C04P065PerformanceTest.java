package com.moqi.c04;

import com.moqi.bean.Artist;
import com.moqi.bean.SampleData;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class C04P065PerformanceTest {

    @Test
    public void findsAllTheBeatles() {
        C04P065PerformanceFixed stub = new C04P065PerformanceFixed() {
            @Override
            public String getName() {
                throw new UnsupportedOperationException();
            }

            @Override
            public Stream<Artist> getMusicians() {
                return Stream.of(SampleData.theBeatles);
            }
        };

        List<Artist> allMusicians = stub.getAllMusicians().collect(toList());
        assertThat(allMusicians, hasItem(SampleData.theBeatles));
        // There really must be a better way than this
        assertThat(allMusicians, hasItems(SampleData.membersOfTheBeatles.toArray(new Artist[0])));
    }

}
