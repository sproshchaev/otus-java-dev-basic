package ru.otus;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 16-01-2025
 * <p>
 * Используется FileReader, который по умолчанию читает файл, используя кодировку по умолчанию для системы.
 * FileReader не поддерживает указание кодировки.
 * Для того чтобы явно указывать кодировку нужно вместо FileReader нужно использовать InputStreamReader.
 */
public class BufferedReaderDemo {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("1.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
