package com.prosoft.practice;

/**
 * 4) Среднее значение
 */
public class VarargsPractice4 {
    // Метод, который вычисляет среднее значение
    public static double average(double... numbers) {
        if (numbers.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }

    public static void main(String[] args) {
        System.out.println("Среднее 2, 4, 6: " + average(2, 4, 6));
        System.out.println("Среднее 10.5, 20.3: " + average(10.5, 20.3));
        System.out.println("Среднее одного числа 7.5: " + average(7.5));
        System.out.println("Среднее без чисел: " + average());
    }
}