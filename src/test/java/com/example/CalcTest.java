package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    private final Calc calc = new Calc();

    @Test
    void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void testSub() {
        assertEquals(-1, calc.sub(2, 3));
    }

    @Test
    void testMul() {
        assertEquals(6, calc.mul(2, 3));
    }

    @Test
    void testDiv() {
        assertEquals(2, calc.div(6, 3));
    }

    @Test
    void testDivByZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.div(1, 0));
    }
}
