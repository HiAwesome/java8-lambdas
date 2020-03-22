package com.moqi.c05;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SuppressWarnings("SimplifyStreamApiCallChains")
public class C05P069EncounterOrderTest {

    /**
     * 　 顺序测试永远通过
     */
    @Test
    public void listToStream() {
        // BEGIN LIST_TO_STREAM
        List<Integer> numbers = asList(1, 2, 3, 4);

        List<Integer> sameOrder = numbers.stream().collect(toList());
        assertEquals(numbers, sameOrder);
        // END LIST_TO_STREAM
    }

    /**
     * 顺序测试不能保证每次通过
     * 注意：要使此操作失败，您需要颠倒数字的顺序。
     */
    // NB: to actually get this to fail you need to reverse the order of the numbers.
    @Ignore
    @Test
    public void hashSetToStream() {
        // BEGIN HASHSET_TO_STREAM
        Set<Integer> numbers = new HashSet<>(asList(4, 3, 2, 1));

        List<Integer> sameOrder = numbers.stream().collect(toList());
        // This may not pass
        assertEquals(asList(4, 3, 2, 1), sameOrder);
        // END HASHSET_TO_STREAM
    }

    /**
     * 生成出现顺序
     */
    @Test
    public void hashSetToStreamSorted() {
        // BEGIN HASHSET_TO_STREAM_SORTED
        Set<Integer> numbers = new HashSet<>(asList(4, 3, 2, 1));

        List<Integer> sameOrder = numbers.stream()
                .sorted()
                .collect(toList());

        assertEquals(asList(1, 2, 3, 4), sameOrder);
        // END HASHSET_TO_STREAM_SORTED
    }

    /**
     * 本例中关于顺序的假设永远是正确的
     */
    @Test
    public void toStreamMapped() {
        // BEGIN TO_STREAM_MAPPED
        List<Integer> numbers = asList(1, 2, 3, 4);

        List<Integer> stillOrdered = numbers.stream()
                .map(x -> x + 1)
                .collect(toList());

        // Reliable encounter ordering
        // 顺序得到了保留
        assertEquals(asList(2, 3, 4, 5), stillOrdered);

        Set<Integer> unordered = new HashSet<>(numbers);

        List<Integer> stillUnordered = unordered.stream()
                .map(x -> x + 1)
                .collect(toList());

        // Can't assume encounter ordering
        // 顺序得不到保证
        assertThat(stillUnordered, hasItem(2));
        assertThat(stillUnordered, hasItem(3));
        assertThat(stillUnordered, hasItem(4));
        assertThat(stillUnordered, hasItem(5));
        // END TO_STREAM_MAPPED
    }

}
