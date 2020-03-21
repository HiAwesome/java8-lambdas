package com.moqi.bean;

import lombok.Data;

import java.util.List;

/**
 * Bean 类 Album：专辑，由若干曲目组成。
 *
 * @author moqi
 * On 3/21/20 16:06
 */

@Data
public class Album {

    /**
     * 专辑名（例如《左轮手枪》）
     */
    private String name;

    /**
     * 专辑上所有曲目的列表。
     */
    private List<Track> tracks;

    /**
     * 参与创作本专辑的艺术家列表。
     */
    private List<Artist> musicians;

}
