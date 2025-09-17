package com.prosoft.demo;

/**
 * Обработка нескольких исключений в одном catch
 */
public class MultipleExceptionsInOneCatch {

    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 30 / a;
            int[] c = {1, 2, 3};
            c[42] = 10;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Перехватили исключение: " + e.getClass().getSimpleName());
        }
        System.out.println("После блока операторов try/catch");
    }
}
