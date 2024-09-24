package com.prosoft;

public class Main {
    public static void main(String[] args) {

        SimpleCalculator simpleCalculator = new SimpleCalculator();
        System.out.println("1 + 1 = " + simpleCalculator.add(1, 1));
        System.out.println("1 - 1 = " + simpleCalculator.subtract(1, 1));
        System.out.println("1 * 1 = " + simpleCalculator.multiply(1, 1));
        System.out.println("1 / 1 = " + simpleCalculator.divide(1, 1));

    }
}