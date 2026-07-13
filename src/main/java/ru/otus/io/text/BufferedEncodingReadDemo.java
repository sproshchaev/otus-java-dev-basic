package ru.otus.io.text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Пример 9. Чтение текста в UTF-8 построчно: BufferedReader + InputStreamReader.
 * «Боевой» способ читать текстовый файл — построчно и с явной кодировкой.
 */
public class BufferedEncodingReadDemo {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("utf8.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
