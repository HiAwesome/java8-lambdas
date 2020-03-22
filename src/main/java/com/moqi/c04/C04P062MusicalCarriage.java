package com.moqi.c04;

/**
 * javac 并不明确应该继承哪个接口中的方法，因此编译器会报错：
 * class Musical Carriage inherits unrelated defaults for rock() from types Carriage and Jukebox。
 * 当然，在类 中实现 rock 方法就能解决这个问题。
 */
// BEGIN body
public class C04P062MusicalCarriage
        implements C04P062Carriage, C04P062Jukebox {

    /**
     * 实现 rock 方法
     * 该例中使用了增强的 super 语法，用来指明使用接口 Carriage 中定义的默认方法。
     */
    @Override
    public String rock() {
        return C04P062Carriage.super.rock();
    }

}
// END body
