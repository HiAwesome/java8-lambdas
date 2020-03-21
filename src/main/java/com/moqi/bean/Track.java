package com.moqi.bean;

/**
 * Bean 类 Track：专辑中的一支曲目。
 *
 * @author moqi
 * On 3/21/20 16:06
 */
public class Track {

    /**
     * 曲目长度
     */
    private final int length;
    /**
     * 曲目名称（例如《黄色潜水艇》）
     */
    private final String name;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public Track copy() {
        return new Track(name, length);
    }

}
