package com.moqi.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Bean 类 Artist：创作音乐的个人或团队。
 *
 * @author moqi
 * On 3/21/20 16:04
 */

public class Artist {

    /**
     * 艺术家的名字（例如：甲壳虫乐队）
     */
    private final String name;

    /**
     * 乐队成员（例如：约翰列侬），该字段可为空。
     */
    private final List<Artist> members;

    /**
     * 乐队来自哪里（例如：利物浦）
     */
    private final String nationality;

    public Artist(String name, String nationality) {
        this(name, Collections.emptyList(), nationality);
    }

    public Artist(String name, List<Artist> members, String nationality) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        Objects.requireNonNull(nationality);
        this.name = name;
        this.members = new ArrayList<>(members);
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public Stream<Artist> getMembers() {
        return members.stream();
    }

    public String getNationality() {
        return nationality;
    }

    public boolean isSolo() {
        return members.isEmpty();
    }

    public boolean isFrom(String nationality) {
        return this.nationality.equals(nationality);
    }

    @Override
    public String toString() {
        return getName();
    }

    public Artist copy() {
        List<Artist> members = getMembers().map(Artist::copy).collect(toList());
        return new Artist(name, members, nationality);
    }
}
