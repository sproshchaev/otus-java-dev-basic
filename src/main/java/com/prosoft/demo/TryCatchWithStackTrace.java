package com.prosoft.demo;

/**
 * Перехват исключения через try-catch с распечаткой stack trace
 */
public class TryCatchWithStackTrace {
    public static void main(String[] args) {
        System.out.println(1);
        try {
            int a = 0;
            int b = 30 / a;
            System.out.println(2);
        } catch (ArithmeticException e) {
            System.out.println(3);
            e.printStackTrace();
        }
        System.out.println(4);
    }
}