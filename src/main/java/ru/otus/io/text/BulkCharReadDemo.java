package ru.otus.io.text;

import java.io.FileReader;
import java.io.IOException;

/**
 * Пример 3. Чтение в буфер char[] (пакетное чтение).
 * Читаем не по одному символу, а порциями в массив — так эффективнее.
 */
public class BulkCharReadDemo {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("notes.txt")) {
            char[] buffer = new char[16];
            int count;
            while ((count = reader.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
