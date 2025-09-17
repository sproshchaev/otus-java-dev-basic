package com.prosoft.demo;

/**
 * Перехват исключения через try-catch
 */
public class TryCatchExample {
    public static void main(String[] args) {
        int a, b;
        try {
            a = 0;
            b = 10 / a;
            System.out.println("Это сообщение не будет выведено в консоль");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка деления на ноль");
        }
        System.out.println("Завершение работы");
    }
}