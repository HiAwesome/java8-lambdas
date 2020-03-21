package com.moqi.c03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 进阶练习第二题
 * Advanced Exercises Question 2
 */
public class C03P050FilterUsingReduce {

    /**
     * 只用reduce和Lambda表达式写出实现Stream上的filter操作的代码，如果不想返回Stream，可以返回一个List。
     */
    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        List<I> initial = new ArrayList<>();
        return stream.reduce(initial,
                (List<I> acc, I x) -> {
                    if (predicate.test(x)) {
                        /*
                         * We are copying data from acc to new list instance. It is very inefficient,
                         * but contract of Stream.reduce method requires that accumulator function does
                         * not mutate its arguments.
                         * Stream.collect method could be used to implement more efficient mutable reduction,
                         * but this exercise asks to use reduce method.
                         *
                         * 我们正在将数据从acc复制到新的列表实例。这是非常低效的，
                         * 但是，Stream.reduce方法的协定要求累加器函数不能对其参数进行突变。
                         * Stream.collect方法可用于实现更有效的可变约简，但本练习要求使用reduce方法。
                         */
                        List<I> newAcc = new ArrayList<>(acc);
                        newAcc.add(x);
                        return newAcc;
                    } else {
                        return acc;
                    }
                }, C03P050FilterUsingReduce::combineLists);
    }

    private static <I> List<I> combineLists(List<I> left, List<I> right) {
        // We are copying left to new list to avoid mutating it.
        // 我们正在向左复制到新列表，以避免对其进行更改。
        List<I> newLeft = new ArrayList<>(left);
        newLeft.addAll(right);
        return newLeft;
    }

}
