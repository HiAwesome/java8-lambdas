package com.moqi.c04;

/**
 * 重写 welcome 默认实现的父类
 */
// BEGIN body
public class C04P059OverridingParent extends C04P059ParentImpl {

    @Override
    public void welcome() {
        message("Class Parent: Hi!");
    }

}
// END body
