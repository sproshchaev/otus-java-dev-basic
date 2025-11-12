package ru.otus.example;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 15-04-2025
 * <p>
 * Запись символа с кодом 65 в позицию по умолчанию.
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("4.txt", "rw")) {
            randomAccessFile.write(65);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
