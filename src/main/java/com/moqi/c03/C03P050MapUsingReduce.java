package com.moqi.c03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 进阶练习第一题
 * Advanced Exercises Question 1
 */
public class C03P050MapUsingReduce {

    /**
     * 只用reduce和Lambda表达式写出实现Stream上的map操作的代码，如果不想返回Stream，可以返回一个List。
     */
    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(new ArrayList<>(), (acc, x) -> {
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
            List<O> newAcc = new ArrayList<>(acc);
            newAcc.add(mapper.apply(x));
            return newAcc;
        }, (List<O> left, List<O> right) -> {
            // We are copying left to new list to avoid mutating it.
            // 我们正在向左复制到新列表，以避免对其进行更改。
            List<O> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }

}
