package ru.otus;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 16-01-2025
 * <p>
 * Для перемещения по файлу используем seek() - запишем "A" в 5-ую позицию
 */
public class RandomAccessFileDemo2 {

    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("4.txt", "rw")) {
            randomAccessFile.seek(5);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
