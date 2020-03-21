package com.moqi.c02;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @author moqi
 * On 3/21/20 16:13
 */

public class C2P022 {

    /**
     * 使用匿名内部类将行为和按钮单击进行关联
     */
    public void firstLambda1() {
        JButton button = new JButton();
        // BEGIN lambda_button_class
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("button clicked");
            }
        });
        // END lambda_button_class
    }

    /**
     * 使用匿名内部类将行为和按钮单击进行关联，使用 Lambda
     */
    public void firstLambda2() {
        JButton button = new JButton();
        // BEGIN lambda_button_lambda
        button.addActionListener(event -> System.out.println("button clicked"));
        // END lambda_button_lambda
    }

    /**
     * 使用匿名内部类将行为和按钮单击进行关联，使用 Lambda 且参数声明类型
     */
    public void firstLambda3() {
        JButton button = new JButton();
        // BEGIN lambda_button_lambda2
        button.addActionListener((ActionEvent event) -> {
            System.out.println("button clicked");
        });
        // END lambda_button_lambda2
    }

    /**
     * 编写 Lambda 表达式的不同形式
     */
    public void allLambdaForms() {
        // BEGIN all_lambda_forms
        // 无参数
        Runnable noArguments = () -> System.out.println("Hello World"); // <1>

        // 单参数
        ActionListener oneArgument = event -> System.out.println("button clicked"); // <2>

        // 无参数，多语句
        Runnable multiStatement = () -> { // <3>
            System.out.print("Hello");
            System.out.println(" World");
        };

        // 多参数，不声明类型
        BinaryOperator<Long> add = (x, y) -> x + y; // <4>

        // 多参数，声明类型
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y; // <5>
        // END all_lambda_forms
    }

    /**
     * 匿名内部类中使用 final 局部变量
     */
    public void firstLambda5() {
        JButton button = new JButton();
        // BEGIN variable_capture1
        final String name = getUserName();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("hi " + name);
            }
        });
        // END variable_capture1
    }

    /**
     * Lambda 表达式中引用既成事实上的 final 变量
     */
    public void firstLambda6() {
        JButton button = new JButton();
        // BEGIN variable_capture2
        String name = getUserName();
        button.addActionListener(event -> System.out.println("hi " + name));
        // END variable_capture2
    }

    /**
     * Lambda 表达式中引用既成事实上的 final 变量
     * 未使用既成事实上的 final 变量，导致无法通过编译
     */
    @Test
    public void firstLambda7() {
        JButton button = new JButton();
        // BEGIN variable_capture2
        String name = getUserName();
        // 对 name 二次赋值，导致编译出错
        name = "123";
        // Error:(118, 70) java: local variables referenced from a lambda expression must be final or effectively final
        // button.addActionListener(event -> System.out.println("hi " + name));
        // END variable_capture2
    }

    /**
     * 使用菱形操作符，根据变量类型做推断
     */
    public void diamondInference() {
        // BEGIN diamond_inference
        Map<String, Integer> oldWordCounts = new HashMap<String, Integer>(); // <1>
        Map<String, Integer> diamondWordCounts = new HashMap<>(); // <2>
        // END diamond_inference
    }

    /**
     * 使用菱形操作符，根据方法签名做推断
     */
    public void diamondInferenceMethod() {
        // BEGIN diamond_inference_method
        useHashmap(new HashMap<>());
    }

    private void useHashmap(Map<String, String> values) {
        // END diamond_inference_method
    }

    public void firstBiFunction() {
        // BEGIN first_bifunction
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        // END first_bifunction
    }

    public void biFunctionDeclaration() {
        // BEGIN bifunction_declaration
        BiFunction<Integer, Integer, Integer> add;
        // END bifunction_declaration
    }

    /**
     * 类型推断
     */
    public void typeInferenceExamples() {
        // BEGIN type_inference_examples
        Predicate<Integer> atLeast5 = x -> x > 5;
        // END type_inference_examples
    }

    /**
     * 略显复杂的类型推断
     */
    public void typeInferenceExamples2() {
        // BEGIN type_inference_examples2
        BinaryOperator<Long> addLongs = (x, y) -> x + y;
        // END type_inference_examples2
    }

    @Test
    public void mostSpecific() {
        // BEGIN most_specific_overload_call
        overloadedMethod("abc");
        // END most_specific_overload_call
    }

    // BEGIN most_specific_overload
    private void overloadedMethod(Object o) {
        System.out.print("Object");
    }

    private void overloadedMethod(String s) {
        System.out.print("String");
    }
    // END most_specific_overload

    @Test
    public void mostSpecificBiFunction() {

        overloadedMethod((x, y) -> x + y);
    }

    private void overloadedMethod(BinaryOperator<Integer> lambda) {
        System.out.print("BinaryOperator");
    }

    private void overloadedMethod(IntegerBiFunction lambda) {
        System.out.print("IntegerBinaryOperator");
    }

    private String getUserName() {
        return "Moqi";
    }
    // END most_specific_bifunction

//    @Test
//    public void mostSpecificPredicate() {
//        overloadedMethod((x) -> true);
//    }

//    private interface IntPredicate  {
//        public boolean test(int value);
//    }

//    private void overloadedMethod(Predicate<Integer> predicate) {
//        System.out.print("Predicate");
//    }

//    private void overloadedMethod(IntPredicate predicate) {
//        System.out.print("IntPredicate");
//    }

    // BEGIN most_specific_bifunction
    private interface IntegerBiFunction extends BinaryOperator<Integer> {

    }

}
