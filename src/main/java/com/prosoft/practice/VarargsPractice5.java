package com.prosoft.practice;

/**
 * 5) Проверка наличия элемента
 */


public class VarargsPractice5 {
    // Метод, который проверяет, есть ли число в переданных аргументах
    public static boolean contains(int searchNumber, int... numbers) {
        for (int number : numbers) {
            if (number == searchNumber) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Ищем 5 в 1, 2, 3, 4, 5: " +
                contains(5, 1, 2, 3, 4, 5));
        System.out.println("Ищем 10 в 1, 2, 3, 4, 5: " +
                contains(10, 1, 2, 3, 4, 5));
        System.out.println("Ищем 7 без чисел: " +
                contains(7));
    }
}

