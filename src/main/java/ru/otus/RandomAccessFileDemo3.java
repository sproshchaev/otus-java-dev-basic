package ru.otus;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 09-07-2025
 * <p>
 * Если перескочить весь текст, то незаполненные позиции будут замещены как NULL
 */
public class RandomAccessFileDemo3 {

    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("4.txt", "rw")) {
            randomAccessFile.seek(30);
            randomAccessFile.write(65);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
