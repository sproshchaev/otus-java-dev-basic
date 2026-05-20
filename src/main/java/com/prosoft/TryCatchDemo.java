package com.prosoft;

public class TryCatchDemo {

    public static void main(String[] args) {
        System.out.println("Начало ");
        try {
            int a = 0;
            int b = 10 / a;
            System.out.println("Не будет напечатано");
            throw new ArrayIndexOutOfBoundsException("Нельзя обращаться к несуществующему индексу массива!");
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Найдена ошибка!");
            e.printStackTrace();
        } finally {
            System.out.println("Выполняется в любом случае!");
        }

        System.out.println("Продолжение");

    }

}
