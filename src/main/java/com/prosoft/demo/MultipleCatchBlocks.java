package com.prosoft.demo;

/**
 * Несколько блоков catch
 */
public class MultipleCatchBlocks {
    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 30 / a;
            int[] c = {1, 2, 3};
            c[42] = 10;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка индексации массива: " + e);
        }
        System.out.println("После блока операторов try/catch");
    }
}

