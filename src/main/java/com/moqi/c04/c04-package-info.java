package com.moqi.c04;

/*
 * Question 1:
 *  see PerformanceFixed
 *
 * Question 2:
 *  根据前面描述的重载解析规则，能否重写默认方法中的 equals 或 hashCode 方法？
 *  No - they are defined on java.lang.Object, and 'class always wins.'
 *  不能，因为它们定义在 Object 类中，类总是胜出。
 *
 * Question 3:
 *  See ArtistsFixed
 *
 */