package com.moqi.c03;

import com.moqi.bean.Artist;

import java.util.List;

public class C03P050Question2 {
    /**
     * 迭代。修改如下代码，将外部迭代转换成内部迭代：
     *
     * int totalMembers = 0;
     * for (Artist artist : artists) {
     *     Stream<Artist> members = artist.getMembers();
     *     totalMembers += members.count.
     * }
     */
    public static int countBandMembersInternal(List<Artist> artists) {
        // NB: readers haven't learnt about primitives yet, so can't use the sum() method
        // 注意：读者尚未了解原始类型，因此不能使用sum（）方法
        return artists.stream()
                .map(artist -> artist.getMembers().count())
                .reduce(0L, Long::sum)
                .intValue();
    }
}
