package com.prosoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleCalculatorTest2 {

    private SimpleCalculator calculator = new SimpleCalculator();

    private static final int ARG1 = 1;
    private static final int ARG2 = 1;
    private static final int EXPECTED_RESULT = 2;

    @Test
    void testAddTrue() {
        // Проверка, что результат сложения равен ожидаемому значению 2
        Assertions.assertTrue(calculator.add(ARG1, ARG2) == EXPECTED_RESULT);
    }

    @Test
    void testAddFalse() {
        // Проверка, что результат сложения НЕ равен 3
        Assertions.assertFalse(calculator.add(1, 1) == 3);
    }

    @Test
    void testAddFail() {
        // Принудительный провал теста
        Assertions.fail("Тест принудительно провален для метода add");
    }

    @Test
    void testAddEquals() {
        // Проверка, что результат сложения равен 2
        Assertions.assertEquals(2, calculator.add(1, 1));
    }

    @Test
    void testAddNotEquals() {
        // Проверка, что результат сложения не равен 3
        Assertions.assertNotEquals(3, calculator.add(1, 1));
    }

    @Test
    void testAddNull() {
        // Проверка на null (для сложения не применимо, но для примера)
        Integer result = null;
        Assertions.assertNull(result, "Результат должен быть null");
    }

    @Test
    void testAddNotNull() {
        // Проверка, что результат сложения не является null
        Assertions.assertNotNull(calculator.add(1, 1), "Результат не должен быть null");
    }

}
