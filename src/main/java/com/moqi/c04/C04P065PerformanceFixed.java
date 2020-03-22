package com.moqi.c04;

import com.moqi.bean.Artist;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/**
 * 添加 getAllMusicians 方法，该方法返回包含所有艺术家名字的 Stream ，如果对象是乐队，则返回每个乐队成员的名字。
 * 例如，如果 getMusicians 方法返回甲壳虫乐队，则 getAllMusicians 方法返回乐队名和乐队成员，
 * 如约翰·列侬、保罗·麦卡特尼等。
 *
 * A Performance by some musicians - eg an Album or Gig.
 */
public interface C04P065PerformanceFixed {

    public String getName();

    public Stream<Artist> getMusicians();

    public default Stream<Artist> getAllMusicians() {
        return getMusicians().flatMap(
                artist -> concat(Stream.of(artist), artist.getMembers()));
    }

}
