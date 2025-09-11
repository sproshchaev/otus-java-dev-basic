package com.prosoft.practice;

/**
 * 5) Изменение элементов массива
 */
public class ArrayPractice5 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Исходный массив:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // Умножаем каждый элемент на 2
        System.out.println("Умножаем каждый элемент на 2:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * 2;
        }

        System.out.println("Новый массив:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}