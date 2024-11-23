package com.prosoft;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SimpleCalculatorTest4 {

    private SimpleCalculator calculator;

    @BeforeAll
    static void setupAll() {
        System.out.println("Выполняется перед всеми тестами");
    }

    @BeforeEach
    void setup() {
        calculator = new SimpleCalculator();
        System.out.println("Выполняется перед каждым тестом");
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "5, 5, 10",
            "10, 20, 30"
    })
    @DisplayName("Тест параметризованного сложения чисел")
    void testAddParameterized(int a, int b, int expectedSum) {
        Assertions.assertEquals(expectedSum, calculator.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 0",
            "5, 3, 2",
            "10, 5, 5",
            "20, 10, 10"
    })
    @DisplayName("Тест параметризованного вычитания чисел")
    void testSubtractParameterized(int a, int b, int expectedDifference) {
        Assertions.assertEquals(expectedDifference, calculator.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1",
            "2, 3, 6",
            "5, 5, 25",
            "10, 10, 100"
    })
    @DisplayName("Тест параметризованного умножения чисел")
    void testMultiplyParameterized(int a, int b, int expectedProduct) {
        Assertions.assertEquals(expectedProduct, calculator.multiply(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1",
            "10, 2, 5",
            "20, 5, 4",
            "100, 10, 10"
    })
    @DisplayName("Тест параметризованного деления чисел")
    void testDivideParameterized(int a, int b, int expectedQuotient) {
        Assertions.assertEquals(expectedQuotient, calculator.divide(a, b));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Выполняется после каждого теста");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Выполняется после всех тестов");
    }

}
