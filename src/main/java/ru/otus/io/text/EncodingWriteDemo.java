package ru.otus.io.text;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Пример 7. Явное указание кодировки при записи: OutputStreamWriter.
 * Зеркальный мост — из символов в байты с явной кодировкой UTF-8.
 */
public class EncodingWriteDemo {
    public static void main(String[] args) {
        try (OutputStreamWriter writer =
                     new OutputStreamWriter(new FileOutputStream("utf8.txt"), StandardCharsets.UTF_8)) {
            writer.write("Текст в кодировке UTF-8: Привет!");
            System.out.println("Файл utf8.txt записан в UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
