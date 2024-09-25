package com.prosoft;

public class Main {
    public static void main(String[] args) {

        SimpleCalculator simpleCalculator = new SimpleCalculator();

        // Тест для метода add
        if (simpleCalculator.add(1, 1) == 2) {
            System.out.println("Test add(1, 1) passed.");
        } else {
            System.out.println("Test add(1, 1) failed.");
        }

        // Тест для метода subtract
        if (simpleCalculator.subtract(1, 1) == 0) {
            System.out.println("Test subtract(1, 1) passed.");
        } else {
            System.out.println("Test subtract(1, 1) failed.");
        }

        // Тест для метода multiply
        if (simpleCalculator.multiply(1, 1) == 1) {
            System.out.println("Test multiply(1, 1) passed.");
        } else {
            System.out.println("Test multiply(1, 1) failed.");
        }

        // Тест для метода divide
        if (simpleCalculator.divide(1, 1) == 1) {
            System.out.println("Test divide(1, 1) passed.");
        } else {
            System.out.println("Test divide(1, 1) failed.");
        }
    }
}
