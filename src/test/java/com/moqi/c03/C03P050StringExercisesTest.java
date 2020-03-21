package com.moqi.c03;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class C03P050StringExercisesTest {

    @Test
    public void noLowercaseLettersInAnEmptyString() {
        assertEquals(0, C03P050StringExercises.countLowercaseLetters(""));
    }

    @Test
    public void countsLowercaseLetterExample() {
        assertEquals(3, C03P050StringExercises.countLowercaseLetters("aBcDeF"));
    }

    @Test
    public void supportsNoLowercaseLetters() {
        assertEquals(0, C03P050StringExercises.countLowercaseLetters("ABCDEF"));
    }

    @Test
    public void noStringReturnedForEmptyList() {
        assertFalse(C03P050StringExercises.mostLowercaseString(Collections.emptyList()).isPresent());
    }

    @Test
    public void findsMostLowercaseString() {
        Optional<String> result = C03P050StringExercises.mostLowercaseString(Arrays.asList("a", "abc", "ABCde"));
        assertEquals(Optional.of("abc"), result);
    }

}
