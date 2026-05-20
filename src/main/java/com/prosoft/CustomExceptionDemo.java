package com.prosoft;

public class CustomExceptionDemo {

    public static void main(String[] args) {
        try {
            validateAge(-10);
        }  catch (InvalidAgeException e) {
            System.out.println("Возраст не корректен!" + e.getMessage());
        }

        validateAge(25);

    }

    public static void validateAge(int age) {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Возраст " +
                    "должен быть от 0 до 150");
        }
        System.out.println("Возраст корректен");
    }

}
