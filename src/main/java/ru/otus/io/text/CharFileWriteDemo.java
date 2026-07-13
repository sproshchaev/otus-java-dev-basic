package ru.otus.io.text;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Пример 1. Запись текста в файл через FileWriter.
 * Символьный поток записывает в файл сразу символы, а не байты.
 */
public class CharFileWriteDemo {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("notes.txt")) {
            writer.write("Привет, символьные потоки!");
            writer.write('\n');
            writer.write("Вторая строка");
            System.out.println("Текст записан в файл notes.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
