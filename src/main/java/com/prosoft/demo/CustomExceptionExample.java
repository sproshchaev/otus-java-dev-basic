package com.prosoft.demo;

import com.prosoft.demo.exception.TransformException;

/**
 * Использование собственных типов исключений
 */
public class CustomExceptionExample {
    public static void main(String[] args) {
        try {
            processData("invalid_format");
        } catch (TransformException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Формат: " + e.getFormat());
        }
    }

    private static void processData(String format) {
        if ("invalid_format".equals(format)) {
            throw new TransformException("Неверный формат данных", format);
        }
    }
}