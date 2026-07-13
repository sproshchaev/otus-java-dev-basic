package ru.otus.io.text;

import java.io.FileReader;
import java.io.IOException;

/**
 * Пример 2. Посимвольное чтение файла через FileReader.
 * Читаем текстовый файл по одному символу и определяем конец потока.
 */
public class CharFileReadDemo {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("notes.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
