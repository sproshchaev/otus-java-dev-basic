package com.prosoft.practice;

/**
 * Правила!
 * №1: Varargs должен быть последним параметром
 * №2: Только один varargs в методе
 */
public class VarargsPractice {

    // Правило №1: Varargs должен быть последним параметром
    // ✅ ПРАВИЛЬНО
    public static void printInfo(String name, int... scores) {
        System.out.println("Имя: " + name);
        System.out.println("Оценки: " + java.util.Arrays.toString(scores));
    }

    // ❌ НЕПРАВИЛЬНО
    // public static void wrongMethod(int... scores, String name) {
    //     // Ошибка компиляции!
    // }

    public static void main(String[] args) {
        printInfo("Анна", 5, 4, 5, 3);  // Правильно
        printInfo("Иван");                      // Можно без varargs
    }

    // Правило №2: Только один varargs в методе

    // ❌ НЕПРАВИЛЬНО
    // public static void wrongMethod(int... first, String... second) {
    //     // Ошибка компиляции!
    // }

    // ✅ ПРАВИЛЬНО
    public static void correctMethod(String message, int... numbers) {
        System.out.println(message);
        for (int number : numbers) {
            System.out.println(number);
        }
    }

}
