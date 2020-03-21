package com.moqi.c02;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class C02P030Question2Test {

    @Test
    public void exampleInB() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        String formatted = C02P030Question2.DATE_FORMATTER_THREAD_LOCAL.get().getFormat().format(cal.getTime());

        assertEquals("01-Jan-1970", formatted);
    }

}
