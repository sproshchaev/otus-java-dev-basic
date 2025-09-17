package com.prosoft.demo;

/**
 * Порядок блоков catch
 */
public class CatchOrder {
    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 30 / a;
        } catch (ArithmeticException e) { // Правильный порядок - сначала подкласс
            System.out.println("ArithmeticException");
        } catch (Exception e) { // Потом суперкласс
            System.out.println("Exception");
        }
    }
}