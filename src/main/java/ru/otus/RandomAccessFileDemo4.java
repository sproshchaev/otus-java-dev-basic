package ru.otus;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 15-04-2025
 * <p>
 * Как перепрыгнуть на несколько позиций .skipBytes(n) и записать символ с кодом 66.
 */
public class RandomAccessFileDemo4 {

    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("4.txt", "rw")) {
            randomAccessFile.seek(0);
            randomAccessFile.skipBytes(5);
            randomAccessFile.write(66);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
