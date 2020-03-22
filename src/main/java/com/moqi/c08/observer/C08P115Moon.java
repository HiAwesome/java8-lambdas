package com.moqi.c08.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Moon 类——当然不如现实世界中那么完美
 */
// BEGIN C08P115Moon
public class C08P115Moon {

    private final List<C08P115LandingObserver> observers = new ArrayList<>();

    public static void main(String[] args) {
        classBasedExample();
        lambdaBasedExample();
    }

    /**
     * 使用类的方式构建用户代码
     */
    private static void classBasedExample() {
        // BEGIN classBasedExample
        C08P115Moon moon = new C08P115Moon();
        moon.startSpying(new C08P115Nasa());
        moon.startSpying(new C08P115Aliens());

        moon.land("An asteroid");
        moon.land("Apollo 11");
        // END classBasedExample
    }

    /**
     * 使用 Lambda 表达式构建用户代码
     */
    private static void lambdaBasedExample() {
        // BEGIN lambdaBasedExample
        C08P115Moon moon = new C08P115Moon();

        moon.startSpying(name -> {
            if (name.contains("Apollo"))
                System.out.println("We made it!");
        });

        moon.startSpying(name -> {
            if (name.contains("Apollo"))
                System.out.println("They're distracted, lets invade earth!");
        });

        moon.land("An asteroid");
        moon.land("Apollo 11");
        // END lambdaBasedExample
    }

    public void land(String name) {
        for (C08P115LandingObserver observer : observers) {
            observer.observeLanding(name);
        }
    }

    public void startSpying(C08P115LandingObserver observer) {
        observers.add(observer);
    }

}
// END C08P115Moon