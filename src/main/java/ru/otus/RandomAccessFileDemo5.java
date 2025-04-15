package ru.otus;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 15-04-2025
 * <p>
 * Запись в конец файла.
 */
public class RandomAccessFileDemo5 {

    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("4.txt", "rw")) {
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(66);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
