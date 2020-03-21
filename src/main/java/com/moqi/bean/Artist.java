package com.moqi.bean;

import lombok.Data;

/**
 * Bean 类 Artist：创作音乐的个人或团队。
 *
 * @author moqi
 * On 3/21/20 16:04
 */
@Data
public class Artist {

    /**
     * 艺术家的名字（例如：甲壳虫乐队）
     */
    private String name;

    /**
     * 乐队成员（例如：约翰列侬），该字段可为空。
     */
    private String members;

    /**
     * 乐队来自哪里（例如：利物浦）
     */
    private String origin;

}
