package com.prosoft;

public class UnionCatchDemo {

    public static void main(String[] args) {
        try {
            int[] arr = new int[2];
            arr[5] = 100;
            int a = 10 / 0;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка с арифметикой/массивом");
        }
    }
}
