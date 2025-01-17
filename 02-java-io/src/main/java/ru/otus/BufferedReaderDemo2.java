package ru.otus;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 16-01-2025
 * <p>
 * Использование BufferedReader с FileInputStream с указанием кодировки.
 */
public class BufferedReaderDemo2 {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("1.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
