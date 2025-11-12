package ru.otus.example;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 15-04-2025
 * <p>
 * Для перемещения по файлу используем seek() - запишем "A" в 5-ую позицию
 */
public class RandomAccessFileDemo2 {

    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("4.txt", "rw")) {
            randomAccessFile.seek(5);
            randomAccessFile.write(65);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
