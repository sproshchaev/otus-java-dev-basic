package com.prosoft;

public class ThrowDemo {

    public static void main(String[] args) {
        sqrt(-5);
    }

    public static double sqrt(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Нельзя вычислить корень из числа < 0!");
        }
        return Math.sqrt(value);
    }

}
