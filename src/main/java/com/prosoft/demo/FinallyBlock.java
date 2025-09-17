package com.prosoft.demo;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Оператор finally
 */
public class FinallyBlock {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("test.txt");
            writer.write("Hello World");
            // ... основная логика
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            // Блок finally выполняется всегда
            if (writer != null) {
                try {
                    writer.close();
                    System.out.println("Ресурс закрыт в finally");
                } catch (IOException e) {
                    System.out.println("Ошибка закрытия файла: " + e.getMessage());
                }
            }
        }
    }
}