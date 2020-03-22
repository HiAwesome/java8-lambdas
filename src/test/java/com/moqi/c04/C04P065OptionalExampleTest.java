package com.moqi.c04;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

@SuppressWarnings("ALL")
public class C04P065OptionalExampleTest {

    @Test
    public void examples() {
        // 创建某个值的 Optional 对象
        // BEGIN value_creation
        Optional<String> a = Optional.of("a");
        assertEquals("a", a.get());
        // END value_creation

        // 创建一个空的 Optional 对象，并检查其是否有值
        // BEGIN is_present
        Optional emptyOptional = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);

        assertFalse(emptyOptional.isPresent());

        // a is defined above
        assertTrue(a.isPresent());
        // END is_present

        // 使用 orElse 和 orElseGet 方法
        // BEGIN orElse
        assertEquals("b", emptyOptional.orElse("b"));
        assertEquals("c", emptyOptional.orElseGet(() -> "c"));
        // END orElse
    }

}
