package com.moqi.c02;

import org.junit.Test;

import javax.swing.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C02P30LambdaExercises {

    @Test
    public void _1a() {
        assertTrue("Shown in the next chapter", true);
    }

    /**
     * 若要编写一个计算器程序，你会使用该接口表示什么样的 Lambda 表达式？
     * 如果要在计算器上将每个操作建模为函数。
     */
    @Test
    public void _1b() {
        // If you were to model each operation on a calculator as a function.
        // 负数
        Function<Double, Double> negate = (x) -> -1 * x;
        // 平方
        Function<Double, Double> square = (x) -> x * x;
        // 百分比
        Function<Double, Double> percent = (x) -> 100 * x;
    }

    /**
     * 下列哪些 Lambda 表达式有效实现了 Function<T, R> ？
     * Function 接收一个参数并输出一个参数，因此 2 并非有效实现了 Function，编译出错
     */
    @Test
    public void _1c() {
        Function<Integer, Integer> one = x -> x + 1;
        // 2 isn't
        // (x, y) -> x + 1;
        Function<Integer, Boolean> three = x -> x == 1;
    }

    /*
     * ThreadLocalLambda表达式。Java有一个ThreadLocal类，作为容器保存了当前线程里局部变量的值。
     * Java8为该类新加了一个工厂方法，接受一个Lambda表达式，并产生一个新的ThreadLocal对象，
     * 而不用使用继承，语法上更加简洁。
     * */

    /**
     * a. 在Javadoc或集成开发环境（IDE）里找出该方法。
     *
     * @see java.lang.ThreadLocal#withInitial(Supplier)
     */
    @Test
    public void _2a() {
        assertTrue("ThreadLocal.withInitial", true);
    }

    /**
     * b. DateFormatter类是非线程安全的。使用构造函数创建一个线程安全的DateFormatter对象，
     * 并输出日期，如“01-Jan-1970”。
     */
    @Test
    public void _2b() {
        ThreadLocal<DateFormat> threadSafeFormatter = ThreadLocal.withInitial(() -> DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK));
        DateFormat formatter = threadSafeFormatter.get();
        assertEquals("01-Jan-1970", formatter.format(new Date(0)));
    }

    /* 类型推断规则。 下面是将 Lambda 表达式作为参数传递给函数的一些例子。
     * javac 能正 确推断出 Lambda 表达式中参数的类型吗？换句话说，程序能编译吗？
     * */

    /**
     * 这个可以通过
     */
    @Test
    public void _3a() {
        // yes
        Runnable helloWorld = () -> System.out.println("hello world");
    }

    /**
     * 这个也可以通过
     */
    @Test
    public void _3b() {
        // 使用 Lambda 表达式实现 ActionListener 接口
        // Yes
        JButton button = new JButton();
        button.addActionListener(event -> System.out.println(event.getActionCommand()));
    }

    /**
     * 不能，重载丢失了泛型信息?
     */
    @Test
    public void _3c() {
        // No
        // check(x -> x > 5);
    }

    private boolean check(Predicate<Integer> predicate) {
        System.out.println("wat?");
        return true;
    }

    private boolean check(IntPred predicate) {
        return true;
    }

    /**
     * 以如下方式重载 check 方法后，还能正确推断出 check(x -> x > 5) 的类型吗？
     */
    interface IntPred {
        boolean test(Integer value);
    }

}
