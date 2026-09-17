package com.prosoft;

public class CustomExceptionDemo {

    public static void main(String[] args) {
        validateAge(200);
    }

    public static void validateAge(int age) {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Возраст должен быть от 0 - 150: " + age);
        }
    }


}
