package com.prosoft;

/**
 * Модификаторы доступа
 */
public class Main {

    public static void main(String[] args) {
        MyPrivateMethod();
    }

    // Модификатор public доступен ото всюду
    public static void MyPublicMethod() {
        System.out.println("Hello, My public Method");
    }

    // Модификатор private доступен только внутри класса
    private static void MyPrivateMethod() {
        System.out.println("Hello, My private Method");
    }

    // Модификатор default (пакетный или package-private) доступен внутри класса и из других классов этого же пакета
    static void MyDefaultMethod() {
        System.out.println("Hello, My default Method");
    }

    // Модификатор protected доступен для классов этого пакета и наследников класса из любых пакетов
    static protected void MyProtectedMethod() {
        System.out.println("Hello, My Protected Method");
    }



}