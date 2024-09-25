package com.prosoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SimpleCalculatorTest {

    private SimpleCalculator calculator;

    @ParameterizedTest
    @MethodSource("provideAdditionArguments")
    void testAdd(int a, int b, int expectedSum) {
        calculator = new SimpleCalculator();
        Assertions.assertEquals(expectedSum, calculator.add(a, b));
    }

    static Stream<Arguments> provideAdditionArguments() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(2, 3, 5),
                Arguments.of(5, 5, 10),
                Arguments.of(10, 20, 30)
        );
    }
}