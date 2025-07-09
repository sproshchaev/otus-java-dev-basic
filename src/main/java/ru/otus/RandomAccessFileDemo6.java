package ru.otus;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 15-04-2025
 * <p>
 * Чтение из файла.
 */
public class RandomAccessFileDemo6 {

    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("4.txt", "rw")) {
            randomAccessFile.seek(30);
            System.out.println((char) randomAccessFile.read());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
