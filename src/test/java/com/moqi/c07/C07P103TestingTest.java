package com.moqi.c07;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class C07P103TestingTest {

    private final List<Integer> otherList = Arrays.asList(1, 2, 3);
    // END to_uppercase

    /**
     * 测试大写转换
     */
    // BEGIN to_uppercase
    @Test
    public void multipleWordsToUppercase() {
        List<String> input = Arrays.asList("a", "b", "hello");
        List<String> result = C07P103Testing.allToUpperCase(input);
        assertEquals(asList("A", "B", "HELLO"), result);
    }
    // END twoLetterStringConvertedToUppercaseLambdas

    /**
     * 测试字符串包含两个字符的情况，第一个字母被转换为大写
     */
    // BEGIN twoLetterStringConvertedToUppercaseLambdas
    @Test
    public void twoLetterStringConvertedToUppercaseLambdas() {
        List<String> input = Collections.singletonList("ab");
        List<String> result = C07P103Testing.elementFirstToUpperCaseLambdas(input);
        assertEquals(Collections.singletonList("Ab"), result);
    }
    // END twoLetterStringConvertedToUppercase

    /**
     * 测试单独的方法
     */
    // BEGIN twoLetterStringConvertedToUppercase
    @Test
    public void twoLetterStringConvertedToUppercase() {
        String input = "ab";
        String result = C07P103Testing.firstToUppercase(input);
        assertEquals("Ab", result);
    }

    /**
     * 结合 Mockito 框架使用 Lambda 表达式
     */
    @Test
    public void mockitoLambdas() {
        // BEGIN mockito_lambdas
        List<String> list = mock(List.class);

        when(list.size()).thenAnswer(inv -> otherList.size());

        assertEquals(3, list.size());

        when(list.toString()).thenAnswer(str -> otherList.toString());

        assertEquals("[1, 2, 3]", list.toString());
        // END mockito_lambdas
    }

}
