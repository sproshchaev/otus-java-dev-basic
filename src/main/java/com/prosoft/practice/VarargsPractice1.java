package com.prosoft.practice;

/**
 * 1) Суммирование чисел
 */
public class VarargsPractice1 {
    // Метод, который складывает все переданные числа
    public static int sum(int... numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Сумма 1, 2, 3: " + sum(1, 2, 3));
        System.out.println("Сумма 10, 20, 30, 40: " + sum(10, 20, 30, 40));
        System.out.println("Сумма одного числа 5: " + sum(5));
        System.out.println("Сумма без чисел: " + sum());
    }
}
