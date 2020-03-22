package com.moqi.c08.observer;

/**
 * 外星人观察到人类登陆月球
 */
// BEGIN C08P115Aliens
public class C08P115Aliens implements C08P115LandingObserver {

    @Override
    public void observeLanding(String name) {
        if (name.contains("Apollo")) {
            System.out.println("They're distracted, lets invade earth!");
        }
    }

}
// END C08P115Aliens
