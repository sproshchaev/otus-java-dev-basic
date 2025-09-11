package com.prosoft.practice;


/**
 * 2) Поиск максимального значения
 */
public class VarargsPractice2 {
    // Метод, который находит максимальное из переданных чисел
    public static int findMax(int... numbers) {
        if (numbers.length == 0) {
            System.out.println("Нет чисел для сравнения!");
            return 0;
        }

        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Максимум из 5, 3, 8, 1: " + findMax(5, 3, 8, 1));
        System.out.println("Максимум из 100, 50: " + findMax(100, 50));
        System.out.println("Максимум из одного числа 7: " + findMax(7));
        findMax(); // Нет аргументов
    }
}
