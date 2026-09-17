package com.prosoft;

public class FinallyDemo {

    public static void main(String[] args) {

        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль!");
        } finally {
            System.out.println("Это выполниться в любом случае!");
        }

    }

}
