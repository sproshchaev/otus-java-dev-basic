package com.prosoft.demo;


import java.io.FileNotFoundException;

/**
 * Checked и unchecked исключения
 */
public class CheckedUncheckedExceptions {
    public static void main(String[] args) {
        // Unchecked exception - можно не обрабатывать
        int a = 0;
        int b = 30 / a; // ArithmeticException

        // Checked exception - обязательно обработать
        try {
            throw new FileNotFoundException("Файл не найден");
        } catch (FileNotFoundException e) {
            System.out.println("Checked exception: " + e.getMessage());
        }
    }
}