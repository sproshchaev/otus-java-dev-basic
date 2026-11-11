package com.prosoft;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        try {
            int a = 0;
            int b = 10 / a;
        } catch (ArithmeticException e) {
            System.out.println("Ошибка возникла!");
        }
        System.out.println("Конец программы");
    }

}