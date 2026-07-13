package ru.otus.io.text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Пример 4. Построчное чтение через BufferedReader.
 * Самый частый способ читать текст — целыми строками, а не символами.
 */
public class BufferedLineReadDemo {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("notes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
