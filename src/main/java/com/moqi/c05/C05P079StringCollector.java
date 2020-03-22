package com.moqi.c05;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 定义字符串收集器
 */
// BEGIN class_def
public class C05P079StringCollector implements Collector<String, C05P078StringCombiner, String> {
// END class_def

    private static final Set<Characteristics> characteristics = Collections.emptySet();

    private final String delim;
    private final String prefix;
    private final String suffix;

    public C05P079StringCollector(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    /**
     * Supplier 是创建容器的工厂
     */
    @Override
    // BEGIN supplier
    public Supplier<C05P078StringCombiner> supplier() {
        return () -> new C05P078StringCombiner(delim, prefix, suffix);
    }
    // END supplier

    /**
     * accumulator 是一个函数，它将当前元素叠加到收集器
     */
    @Override
    // BEGIN accumulator
    public BiConsumer<C05P078StringCombiner, String> accumulator() {
        return C05P078StringCombiner::add;
    }
    // END accumulator

    /**
     * combiner 合并两个容器
     */
    @Override
    // BEGIN combiner
    public BinaryOperator<C05P078StringCombiner> combiner() {
        return C05P078StringCombiner::merge;
    }
    // END combiner

    /**
     * finisher 方法返回收集操作的最终结果
     */
    @Override
    // BEGIN finisher
    public Function<C05P078StringCombiner, String> finisher() {
        return C05P078StringCombiner::toString;
    }
    // END finisher

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }

}
