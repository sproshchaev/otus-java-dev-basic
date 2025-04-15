package ru.otus;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 15-04-2025
 * <p>
 * FileReader с указанием StandardCharsets (ранее CharSet)
 * Если файл по умолчанию в кодировке UTF-8, то будет считываться корректно.
 * Если отличная кодировка от UTF-8, то указываем в конструкторе.
 */
public class FileReaderDemo {

    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("1.txt", StandardCharsets.UTF_8)) {
            int bytesRead;
            while ((bytesRead = fileReader.read()) != -1) {
                System.out.print((char) bytesRead);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
