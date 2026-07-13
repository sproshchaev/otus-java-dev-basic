package ru.otus.io.text;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Пример 6. Явное указание кодировки при чтении: InputStreamReader.
 * Мост от байтового потока к символьному с явным указанием кодировки UTF-8.
 */
public class EncodingReadDemo {
    public static void main(String[] args) {
        try (InputStreamReader reader =
                     new InputStreamReader(new FileInputStream("notes.txt"), StandardCharsets.UTF_8)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
