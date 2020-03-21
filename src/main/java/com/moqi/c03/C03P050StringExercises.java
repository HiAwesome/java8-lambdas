package com.moqi.c03;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class C03P050StringExercises {

    /**
     * 计算一个字符串中小写字母的个数（提示：参阅 String 对象的 chars 方法）。
     */
    public static int countLowercaseLetters(String string) {
        return (int) string.chars()
                .filter(Character::isLowerCase)
                .count();
    }

    /**
     * 在一个字符串列表中， 找出包含最多小写字母的字符串。 对于空列表， 返回 Optional<String> 对象。
     */
    public static Optional<String> mostLowercaseString(List<String> strings) {
        return strings.stream().max(Comparator.comparing(
                C03P050StringExercises::countLowercaseLetters));
    }

}
