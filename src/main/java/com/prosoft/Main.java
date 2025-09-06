package com.prosoft;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Функциональные интерфейсы в Java
 */
public class Main {

    public static void main(String[] args) {

        // (1) Function: для преобразования типов, метод .apply()
        Function<String, Integer> lenString = str -> str.length();
        System.out.println("Длина строки " + lenString.apply("Hello!"));

        // (2) Predicat: проверяет условие - boolean, метод .test()
        Predicate<String> isLong = str -> str.length() == 10;
        System.out.println("Длина строки =10 " +  isLong.test("Hello!"));
        System.out.println("Длина строки =10 " +  isLong.test("Hello!Hell"));

        // или можно оформить на метод
        Predicate<String> isLong2 = str -> isLengthTen(str);
        System.out.println("Длина строки =10 " +  isLong2.test("Hello!Hell"));

        // (3) Consumer: потребляет и ничего не возвращает, метод .accept()
        Consumer<String> toConsole = str -> {
            System.out.println("Строка в консоль: " + str);
        };
        toConsole.accept("Hello!");

        // (4) Supplier: поставляет объект, метод .get
        Supplier<String> someString = () -> "Hello from Supplier!";
        System.out.println(someString.get());

    }

    private static boolean isLengthTen(String str) {
        return str.length() == 10;
    }



}