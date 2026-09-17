package com.prosoft;

public class UnhandledExceptionDemo {

    public static void main(String[] args) {
        System.out.println("Начало программы");
        try {
            int a = 0;
            int b = 10 / a; // "/ by zero"
        } catch (ArithmeticException ex) {
            System.out.println("Поймали деление на ноль!");
            ex.printStackTrace(); // печатаем стек
        }
        System.out.println("Конец программы"); // Process finished with exit code 0

    }

}
