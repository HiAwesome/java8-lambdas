package com.moqi.c08.lambdabehave.example;

import java.util.Stack;

import static com.moqi.c08.lambdabehave.Lets.describe;

/**
 * 描述 stack 的案例
 */
// BEGIN C08P120StackSpec
public class C08P120StackSpec {
    static {

        describe("a stack", it -> {

            it.should("be empty when created", expect -> {
                expect.that(new Stack<>()).isEmpty();
            });

            it.should("push new elements onto the top of the stack", expect -> {
                Stack<Integer> stack = new Stack<>();
                stack.push(1);

                expect.that(stack.get(0)).isEqualTo(1);
            });

            it.should("pop the last element pushed onto the stack", expect -> {
                Stack<Integer> stack = new Stack<>();
                // 这里调换 push 的顺序，使得方法成立
                stack.push(1);
                stack.push(2);

                expect.that(stack.pop()).isEqualTo(2);
            });

        });

    }
}
// END C08P120StackSpec
