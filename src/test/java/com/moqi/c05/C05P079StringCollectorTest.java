package com.moqi.c05;

import org.junit.Test;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class C05P079StringCollectorTest {

    @Test
    public void testIdentityConstraint() {
        /*
         * From javadoc of Collector interface:
         * The identity constraint says that for any partially accumulated result,
         * combining it with an empty result container must produce an equivalent result.
         * That is, for a partially accumulated result a that is the result of any series of
         * accumulator and combiner invocations, a must be equivalent to combiner.apply(a, supplier.get()).
         *
         * 来自Collector接口的javadoc：身份约束表明，对于任何部分累加的结果，
         * 将其与空结果容器组合必须产生等效的结果。
         * 也就是说，对于部分累加的结果a（它是任何一系列累加器和合并器调用的结果），
         * a 必须等效于 Combiner.apply(a，provider.get())。
         */
        C05P079StringCollector collector = new C05P079StringCollector(", ", "<!--", "-->");
        Supplier<C05P078StringCombiner> supplier = collector.supplier();
        BiConsumer<C05P078StringCombiner, String> accumulator = collector.accumulator();
        BinaryOperator<C05P078StringCombiner> combiner = collector.combiner();
        Function<C05P078StringCombiner, String> finisher = collector.finisher();

        C05P078StringCombiner stringCombiner1 = supplier.get();
        accumulator.accept(stringCombiner1, "one");
        accumulator.accept(stringCombiner1, "two");
        String result1 = finisher.apply(stringCombiner1);

        C05P078StringCombiner stringCombiner2 = supplier.get();
        accumulator.accept(stringCombiner2, "one");
        accumulator.accept(stringCombiner2, "two");
        stringCombiner2 = combiner.apply(stringCombiner2, supplier.get());
        String result2 = finisher.apply(stringCombiner2);

        assertEquals(result1, result2);
    }

    @Test
    public void testAssociativityConstraint() {
        /*
         * From javadoc of Collector interface:
         * The associativity constraint says that splitting the computation must produce an equivalent result.
         *
         * 从Collector接口的javadoc中获取：关联性约束表明拆分计算必须产生等效的结果。
         */
        C05P079StringCollector collector = new C05P079StringCollector(", ", "<!--", "-->");
        Supplier<C05P078StringCombiner> supplier = collector.supplier();
        BiConsumer<C05P078StringCombiner, String> accumulator = collector.accumulator();
        BinaryOperator<C05P078StringCombiner> combiner = collector.combiner();
        Function<C05P078StringCombiner, String> finisher = collector.finisher();

        C05P078StringCombiner a1 = supplier.get();
        accumulator.accept(a1, "one");
        accumulator.accept(a1, "two");
        String r1 = finisher.apply(a1);  // result without splitting

        C05P078StringCombiner a2 = supplier.get();
        accumulator.accept(a2, "one");
        C05P078StringCombiner a3 = supplier.get();
        accumulator.accept(a3, "two");
        String r2 = finisher.apply(combiner.apply(a2, a3));  // result with splitting

        assertEquals(r1, r2);
    }

    @Test
    public void testCollectEmpty() {
        Stream<String> stream = Stream.of();
        String result = stream.collect(new C05P079StringCollector(", ", "<!--", "-->"));
        assertEquals("<!---->", result);
    }

    @Test
    public void testCollectSimple() {
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        String result = stream.collect(new C05P079StringCollector(", ", "<!--", "-->"));
        assertEquals("<!--one, two, three, four-->", result);
    }

    @Test
    public void testCollectParallel() {
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        String result = stream.parallel().collect(new C05P079StringCollector(", ", "<!--", "-->"));
        assertEquals("<!--one, two, three, four-->", result);
    }

    @Test
    public void testCollectParallelLargeDataSet() {
        List<String> data = IntStream.iterate(1, i -> i + 1)
                .mapToObj(Integer::toString)
                .limit(10000)
                .collect(Collectors.toList());

        String simpleResult = data.stream().collect(new C05P079StringCollector(", ", "<!--", "-->"));
        String parallelResult = data.parallelStream().collect(new C05P079StringCollector(", ", "<!--", "-->"));
        assertEquals(simpleResult, parallelResult);
    }

}
