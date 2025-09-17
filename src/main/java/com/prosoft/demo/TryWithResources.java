package com.prosoft.demo;

import java.io.FileWriter;
import java.io.IOException;

/**
 * try-with-resources
 */
public class TryWithResources {
    public static void main(String[] args) {
        // try-with-resources - автоматическое закрытие ресурсов
        try (FileWriter writer = new FileWriter("test.txt")) {
            writer.write("Hello World");
            // ... основная логика
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
        // Ресурс автоматически закрывается после выхода из блока try
        System.out.println("Файл автоматически закрыт");
    }
}