package com.prosoft;

public class MultipleCatchDemo {

    public static void main(String[] args) {
        try {
            int[] arr = new int[2];
            arr[5] = 100; // ArrayIndexOutOfBoundsException
            int a = 10 / 0; // / by zero
        } catch (ArithmeticException ex) {
            System.out.println("Деление на ноль");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Вышли за границы массива!");
        }
    }

}
