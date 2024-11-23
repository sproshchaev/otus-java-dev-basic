package com.prosoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Этот метод класса")
class SimpleCalculatorTest {

    // Подход AAA (Arrange-Act-Assert)
    // 1) Arrange - подготовка данных и окружения для теста
    private SimpleCalculator calculator;

    // 2) Act - выполнение тестируемого кода
    // 3) Assert - проверка результата

    @Test
    @DisplayName("testAdd() - этот метод сложения")
    void testAdd() {
        calculator = new SimpleCalculator();
                              // expected,  actual
        Assertions.assertTrue(calculator.add(1, 1) == 2); // 2) и 3)
    }

    @Test
    void testSubtract() {
        calculator = new SimpleCalculator();
        Assertions.assertEquals(0, calculator.subtract(1, 1));
    }

    @Test
    void testMultiply() {
        calculator = new SimpleCalculator();
        Assertions.assertEquals(1, calculator.multiply(1, 1));
    }

    @Test
    void testDivide() {
        calculator = new SimpleCalculator();
        Assertions.assertEquals(1, calculator.divide(1, 1));
    }

}