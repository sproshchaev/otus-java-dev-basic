package com.prosoft;

/**
 * Основы синтаксиса Java: что важно знать при переходе с другого языка? (20-10-2025)
 */
public class Main {

    public static void main(String[] args) {

        Car car = new Car("bmw", "белый", 123);

        System.out.println("Автомобиль: марка " + car.getBrand()
                + " " + car.getColor() + " " + car.getNumber());

        // Объявление переменных
        int a = 100;
        int b = 200;

        System.out.println("a+b=" + (a + b));

        // 3,14
        double pi = 3.14;
        System.out.println("pi=" + pi);

        // String
        String stroka1 = "Это строка 1!";
        String stroka2 = "Это строка 2!";
        System.out.println(stroka1 + " " + stroka2);

    }

}