package com.moqi.c08.observer;

/**
 * NASA 也能观察到有人登陆月球
 */
// BEGIN C08P115Nasa
public class C08P115Nasa implements C08P115LandingObserver {
    @Override
    public void observeLanding(String name) {
        if (name.contains("Apollo")) {
            System.out.println("We made it!");
        }
    }
}
// END C08P115Nasa
