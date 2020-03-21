package com.moqi.c03;

/*
 * Question 1:
 *  See the Question1 class
 *
 * Question 2:
 *  see the Question2 class
 *
 * Question 3:
 * 求值。 根据 Stream 方法的签名，判断其是惰性求值还是及早求值。
 *  a. boolean anyMatch(Predicate<? super T> predicate);
 *  b. Stream<T> limit(long maxSize);
 *
 * This question is to test how much we know about evaluation. So as we understood, Streams are lazy and others are Eager.
 * 这个问题是测试我们对 evaluation 了解多少。因此，据我们了解，Streams 是懒惰求值，其他是及早求值。
 *  a. Eager
 *  b. Lazy
 *
 * Question 4:
 * 下面的 Stream 函数是高阶函数吗？为什么？
 *  a. boolean anyMatch(Predicate<? super T> predicate);
 *  b. Stream<T> limit(long maxSize);
 *
 *  a. Yes - takes a function as an argument（以函数作为参数）
 *  b. No
 *
 * Question 5:
 *
 * 下面的 Lambda 表达式有无副作用，或者说它们是否更改了程序状态？
 *  a. x -> x + 1
 * 示例代码如下所示：
 *      AtomicInteger count = new AtomicInteger(0);
 *      List<String> origins = album.musicians() .forEach(musician -> count.incAndGet();)
 *  b. AtomicInteger
 *
 *  a. Side Effect Free（无副作用）
 *  b. Mutates count（改变 count 的值为副作用）
 *
 * Question 6:
 *  StringExercises
 *
 * Question 7:
 *  StringExercises
 */
