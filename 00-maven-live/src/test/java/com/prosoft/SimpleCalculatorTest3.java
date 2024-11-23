package com.prosoft;

import org.junit.jupiter.api.*;

public class SimpleCalculatorTest3 {
    private SimpleCalculator calculator;

    // Выполняется перед всеми тестами, метод должен быть статическим
    @BeforeAll
    static void setupAll() {
        System.out.println("Выполняется перед всеми тестами");
    }

    // Выполняется перед каждым тестом
    @BeforeEach
    void setup() {
        calculator = new SimpleCalculator();
        System.out.println("Выполняется перед каждым тестом");
    }

    // Пример использования @DisplayName
    @Test
    @DisplayName("Тест сложения двух чисел")
    void testAdd() {
        Assertions.assertEquals(2, calculator.add(1, 1));
    }

    @Test
    @DisplayName("Тест вычитания двух чисел")
    void testSubtract() {
        Assertions.assertEquals(0, calculator.subtract(1, 1));
    }

    @Test
    @DisplayName("Тест умножения двух чисел")
    void testMultiply() {
        Assertions.assertEquals(1, calculator.multiply(1, 1));
    }

    @Test
    @DisplayName("Тест деления двух чисел")
    void testDivide() {
        Assertions.assertEquals(1, calculator.divide(1, 1));
    }

    // Выполняется после каждого теста
    @AfterEach
    void tearDown() {
        System.out.println("Выполняется после каждого теста");
    }

    // Выполняется после всех тестов, метод должен быть статическим
    @AfterAll
    static void tearDownAll() {
        System.out.println("Выполняется после всех тестов");
    }
}
