package com.moqi.c02;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;

public class C02P030Question2 {

    private static final String DD_MMM_YYYY = "dd-MMM-yyyy";

    /**
     * ThreadLocalLambda表达式。Java有一个ThreadLocal类，作为容器保存了当前线程里局部变量的值。
     * Java8为该类新加了一个工厂方法，接受一个Lambda表达式，并产生一个新的ThreadLocal对象，
     * 而不用使用继承，语法上更加简洁。
     *
     * a. 在Javadoc或集成开发环境（IDE）里找出该方法。
     * b. DateFormatter类是非线程安全的。
     *    使用构造函数创建一个线程安全的DateFormatter对象，并输出日期，如“01-Jan-1970”。
     */
     public final static ThreadLocal<DateFormatter> DATE_FORMATTER_THREAD_LOCAL = ThreadLocal.withInitial(
             () -> new DateFormatter(new SimpleDateFormat(DD_MMM_YYYY)));

}
