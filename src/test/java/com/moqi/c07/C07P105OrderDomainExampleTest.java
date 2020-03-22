package com.moqi.c07;

import com.moqi.bean.Album;
import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Sample code for chapter7 OrderDomain from the
 * previous chapter.
 */
public class C07P105OrderDomainExampleTest {

    /**
     * 使用 Lambda 表达式编写测试替身，传给 countFeature 方法
     */
    // BEGIN can_count_albums
    @Test
    public void canCountFeatures() {
        C07P105OrderDomain order = new C07P105OrderDomain(asList(
                newAlbum("Exile on Main St."),
                newAlbum("Beggars Banquet"),
                newAlbum("Aftermath"),
                newAlbum("Let it Bleed")));

        assertEquals(8, order.countFeature(album -> 2));
    }
    // END can_count_albums

    private Album newAlbum(String name) {
        return new Album(name, emptyList(), emptyList());
    }

}
