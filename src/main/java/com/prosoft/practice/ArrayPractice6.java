package com.prosoft.practice;

/**
 * 6) Работа с массивом строк
 */
public class ArrayPractice6 {
    public static void main(String[] args) {
        String[] fruits = {"яблоко", "банан", "апельсин", "груша", "киви"};

        System.out.println("Список фруктов:");
        // Выводим все фрукты заглавными буквами
        for (int i = 0; i < fruits.length; i++) {
            System.out.println((i + 1) + ". " + fruits[i].toUpperCase());
        }

        System.out.println("\nФрукты, начинающиеся на 'а':");
        // Ищем фрукты, начинающиеся на букву 'а'
        for (String fruit : fruits) {
            if (fruit.startsWith("а")) {
                System.out.println("- " + fruit);
            }
        }
    }
}
